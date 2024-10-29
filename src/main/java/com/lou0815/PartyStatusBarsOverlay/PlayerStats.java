package com.lou0815.PartyStatusBarsOverlay;

import lombok.Getter;
import net.runelite.client.plugins.party.data.PartyData;

// PlayerStats Class for convenient Access to all Stats
public class PlayerStats {
    @Getter
    private final long playerId;
    @Getter
    private final String playerName;
    private PartyData partyData;

    public PlayerStats(Long playerId, String playerName, PartyData partyData) {
        this.playerId = playerId;
        this.playerName = playerName;
        this.partyData = partyData;
    }

    public int getMaxHP() {
        return partyData.getMaxHitpoints();
    }

    public int getCurrHP() {
        return partyData.getHitpoints();
    }

    public int getMaxPray() {
        return partyData.getMaxPrayer();
    }

    public int getCurrPray() {
        return partyData.getPrayer();
    }

    public int getCurrSpec() {
        return partyData.getSpecEnergy();
    }

    public int getCurrRun() {
        return partyData.getRunEnergy();
    }
}
