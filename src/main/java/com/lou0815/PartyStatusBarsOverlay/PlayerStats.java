package com.lou0815.PartyStatusBarsOverlay;

import lombok.Getter;
import net.runelite.api.Skill;
import net.runelite.client.party.PartyMember;

// PlayerStats Class for convenient Access to all Stats
public class PlayerStats {
    @Getter
    private final long playerId;
    @Getter
    private final String playerName;
    private final PartyMember partyMember;

    public PlayerStats(Long playerId, String playerName, PartyMember partyMember) {
        this.playerId = playerId;
        this.playerName = playerName;
        this.partyMember = partyMember;
    }

    public int getMaxHP() {
        return partyMember.getStatBase(Skill.HITPOINTS);
    }

    public int getCurrHP() {
        return partyMember.getStatBoost(Skill.HITPOINTS);
    }

    public int getMaxPray() {
        return partyMember.getStatBase(Skill.PRAYER);
    }

    public int getCurrPray() {
        return partyMember.getStatBoost(Skill.PRAYER);
    }

    public int getCurrSpec() {
        return partyMember.getSpecEnergy();
    }

    public int getCurrRun() {
        return partyMember.getRunEnergy();
    }
}
