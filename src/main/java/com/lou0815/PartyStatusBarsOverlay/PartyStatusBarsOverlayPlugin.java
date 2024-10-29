package com.lou0815.PartyStatusBarsOverlay;

import com.google.inject.Provides;
import javax.inject.Inject;
import javax.inject.Singleton;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.events.GameTick;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.party.PartyMember;
import net.runelite.client.party.PartyService;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDependency;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.party.PartyPlugin;
import net.runelite.client.plugins.party.PartyPluginService;
import net.runelite.client.ui.overlay.OverlayManager;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@PluginDescriptor(
		name = "Party Status Bars Overlay",
		description = "An extension to show status bars for party members",
		tags = {"party", "status", "bars", "overlay"}
)

@PluginDependency(PartyPlugin.class)
public class PartyStatusBarsOverlayPlugin extends Plugin
{
	@Getter(AccessLevel.PACKAGE)
	@Inject
	private PartyPluginService partyPluginService;

	@Inject
	private PartyService partyService;

	@Inject
	private PartyStatusBarsOverlay partyStatusBarsOverlay;

	@Inject
	private OverlayManager overlayManager;

	@Inject
	private PartyStatusBarsOverlayConfig config;

	@Provides
	@Singleton // Singleton so we can use it here to update and in other classes to access the data
	Map<Long, PlayerStats> playerStatsMap() {
		return new HashMap<>();
	}

	@Inject
	private Map<Long, PlayerStats> playerStatsMap;

	@Override
	protected void startUp() throws Exception
	{
		overlayManager.add(partyStatusBarsOverlay);
	}

	@Override
	protected void shutDown() throws Exception
	{
		overlayManager.remove(partyStatusBarsOverlay);
	}

	@Provides
	PartyStatusBarsOverlayConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(PartyStatusBarsOverlayConfig.class);
	}

	public void refreshPlayerStatsMap() {
		// Remove players who are no longer in the party
		playerStatsMap.keySet().removeIf(id ->
				partyService.getMembers().stream().noneMatch(member -> String.valueOf(member.getMemberId()).equals(id))
		);

		for (PartyMember member : partyService.getMembers()) {
			Long memberId = member.getMemberId();
			PlayerStats existingStats = playerStatsMap.get(memberId);

			// adding a user to the playerStatsMap if not already exists and name not <unknown>
			if (existingStats == null && !member.getDisplayName().equals("<unknown>")) {

				playerStatsMap.put(memberId, new PlayerStats(
						memberId,
						member.getDisplayName(),
						partyPluginService.getPartyData(memberId)
				));
			}
		}
	}

	@Subscribe
	public void onGameTick(GameTick event) {
		refreshPlayerStatsMap();
	}
}
