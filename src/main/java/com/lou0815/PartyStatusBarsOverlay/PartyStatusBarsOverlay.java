package com.lou0815.PartyStatusBarsOverlay;

import net.runelite.client.ui.overlay.OverlayPanel;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.components.LineComponent;

import javax.inject.Inject;
import java.awt.*;
import java.util.Map;

import static com.lou0815.PartyStatusBarsOverlay.BarType.*;


public class PartyStatusBarsOverlay extends OverlayPanel {

    private final Map<Long, PlayerStats> playerStatsMap;
    private final PartyStatusBarsOverlayConfig config;

    @Inject
    private PartyStatusBarsOverlay(Map<Long, PlayerStats> playerStatsMap, PartyStatusBarsOverlayConfig config) {
        this.playerStatsMap = playerStatsMap;
        this.config = config;

        setPosition(OverlayPosition.TOP_LEFT);
        setPriority(PRIORITY_LOW);
    }

    @Override
    public Dimension render(Graphics2D graphics) {
        int i = 0;
        int size = playerStatsMap.values().size();
        for (PlayerStats playerStats : playerStatsMap.values()) {
            i += 1;
            drawPlayerBox(playerStats, i != size); // if i == size we disable the spacer so the last entry is not followed by a spacer
        }
        return super.render(graphics);
    }

    private void drawPlayerBox(PlayerStats playerStats, boolean enableSpacer) {
        getPanelComponent().setGap(new Point(0, config.barGap()));
        if (config.showCharName()) {
            panelComponent.getChildren().add(LineComponent.builder()
                    .left(playerStats.getPlayerName())
                    .build());
        }
        if (config.showBarHealth()) {
            PartyStatusBarsComponent progressBarHP = new PartyStatusBarsComponent(config, HP, playerStats.getCurrHP(), playerStats.getMaxHP());
            panelComponent.getChildren().add(progressBarHP);
        }
        if (config.showBarPrayer()) {
            PartyStatusBarsComponent progressBarPray = new PartyStatusBarsComponent(config, PRAY, playerStats.getCurrPray(), playerStats.getMaxPray());
            panelComponent.getChildren().add(progressBarPray);
        }
        if (config.showBarSpecEnergy()) {
            PartyStatusBarsComponent progressBarSpec = new PartyStatusBarsComponent(config, SPEC, playerStats.getCurrSpec());
            panelComponent.getChildren().add(progressBarSpec);
        }
        if (config.showBarRunEnergy()) {
            PartyStatusBarsComponent progressBarRun = new PartyStatusBarsComponent(config, RUN, playerStats.getCurrRun());
            panelComponent.getChildren().add(progressBarRun);
        }
        if (config.showSpacer() && enableSpacer) {
            panelComponent.getChildren().add(LineComponent.builder()
                    .build());
        }

    }
}
