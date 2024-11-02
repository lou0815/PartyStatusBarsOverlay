package com.lou0815.PartyStatusBarsOverlay;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.ConfigSection;

import java.awt.*;

@ConfigGroup("PartyStatusBarsOverlay")
public interface PartyStatusBarsOverlayConfig extends Config
{
	@ConfigItem(
			keyName = "showCharName",
			name = "Show Player Names",
			description = "Show Player Names of party members in the Overlay",
			position = 10
	)
	default boolean showCharName()
	{
		return true;
	}

	@ConfigItem(
			keyName = "showSpacer",
			name = "Show Spacer",
			description = "Show Spacer after each party members in the Overlay",
			position = 20
	)
	default boolean showSpacer()
	{
		return true;
	}

	@ConfigItem(
			keyName = "barGap",
			name = "Gap Between Bars",
			description = "How far apart the bars should be",
			position = 30
	)
	default int barGap()
	{
		return 3;
	}

	@ConfigItem(
			keyName = "borderThickness",
			name = "Border Thickness",
			description = "Thickness of Threshold Warning Borders",
			position = 30
	)
	default int borderThickness()
	{
		return 3;
	}

	@ConfigSection(
			name = "Hitpoint Settings",
			description = "Settings for the Hitpoint Bars",
			position = 51
	)
	String HITPOINT_SETTINGS = "hitpointSettings";

	@ConfigSection(
			name = "Prayer Settings",
			description = "Settings for the Prayer Bars",
			position = 52
	)
	String PRAYER_SETTINGS = "PrayerSettings";

	@ConfigSection(
			name = "Special Attack Settings",
			description = "Settings for the Special Attack Bars",
			position = 53
	)
	String SPECIAL_ATTACK_SETTINGS = "specialAttackSettings";

	@ConfigSection(
			name = "Run Energy Settings",
			description = "Settings for the Run Energy Bars",
			position = 54
	)
	String RUN_ENERGY_SETTINGS = "runEnergySettings";

	@ConfigItem(
			section = HITPOINT_SETTINGS,
			keyName = "showBarHealth",
			name = "Show Health Bars",
			description = "Show health bars of party members in the Overlay",
			position = 100
	)
	default boolean showBarHealth()
	{
		return true;
	}

	@ConfigItem(
			section = PRAYER_SETTINGS,
			keyName = "showBarPrayer",
			name = "Show Prayer Bars",
			description = "Show prayer bars of party members in the Overlay",
			position = 200
	)
	default boolean showBarPrayer()
	{
		return true;
	}

	@ConfigItem(
			section = SPECIAL_ATTACK_SETTINGS,
			keyName = "showBarSpecEnergy",
			name = "Show Special Attack Energy Bars",
			description = "Show special attack energy bars of party members in the Overlay",
			position = 300
	)
	default boolean showBarSpecEnergy()
	{
		return false;
	}

	@ConfigItem(
			section = RUN_ENERGY_SETTINGS,
			keyName = "showBarRunEnergy",
			name = "Show Run Energy Bars",
			description = "Show run energy bars of party members in the Overlay",
			position = 400
	)
	default boolean showBarRunEnergy()
	{
		return false;
	}

	@ConfigItem(
			section = HITPOINT_SETTINGS,
			keyName = "hpColor",
			name = "Hitpoints Color",
			description = "Color of Hitpoints",
			position = 110
	)
	default Color hpColor() {return new Color(50, 255, 50, 125);}

	@ConfigItem(
			section = HITPOINT_SETTINGS,
			keyName = "overHpColor",
			name = "Overheal Color",
			description = "Color of Hitpoints above Players Maximum",
			position = 120
	)
	default Color overHpColor() {return new Color(50, 255, 50, 175);}

	@ConfigItem(
			section = HITPOINT_SETTINGS,
			keyName = "missingHpColor",
			name = "Missing Hitpoints Color",
			description = "Color of missing Hitpoints (Background)",
			position = 130
	)
	default Color missingHpColor() {return new Color(225, 35, 0, 125);}

	@ConfigItem(
			section = HITPOINT_SETTINGS,
			keyName = "showHpThresholdWarning",
			name = "Recolor Bar at Threshold",
			description = "Show HP Bar in Warning Color when the value is below the Threshold",
			position = 140
	)
	default boolean showHpThresholdWarning()
	{
		return false;
	}

	@ConfigItem(
			section = HITPOINT_SETTINGS,
			keyName = "thresholdHp",
			name = "HP Threshold",
			description = "HP Threshold",
			position = 150
	)
	default int thresholdHp() {return 10;}

	@ConfigItem(
			section = HITPOINT_SETTINGS,
			keyName = "thresholdHpColor",
			name = "Threshold Bar Color",
			description = "Color of HP Bar below Threshold",
			position = 160
	)
	default Color thresholdHpColor() {return new Color(194, 78, 255, 255);}

	@ConfigItem(
			section = PRAYER_SETTINGS,
			keyName = "prayColor",
			name = "Prayer Color",
			description = "Color of Prayer Points",
			position = 210
	)
	default Color prayColor() {return new Color(50, 200, 200, 175);}

	@ConfigItem(
			section = PRAYER_SETTINGS,
			keyName = "overPrayColor",
			name = "Over Prayer Color",
			description = "Color of Prayer Points above Players Maximum",
			position = 220
	)
	default Color overPrayColor() {return new Color(50, 255, 255, 175);}

	@ConfigItem(
			section = PRAYER_SETTINGS,
			keyName = "missingPrayColor",
			name = "Missing Prayer Points Color",
			description = "Color of missing Prayer Points (Background)",
			position = 230
	)
	default Color missingPrayColor() {return new Color(0, 0, 0, 150);}

	@ConfigItem(
			section = PRAYER_SETTINGS,
			keyName = "showPrayThresholdWarning",
			name = "Recolor Bar at Threshold",
			description = "Show Prayer Bar in Warning Color when the value is below the Threshold",
			position = 240
	)
	default boolean showPrayThresholdWarning()
	{
		return false;
	}

	@ConfigItem(
			section = PRAYER_SETTINGS,
			keyName = "thresholdPray",
			name = "Prayer Threshold",
			description = "Prayer Threshold",
			position = 250
	)
	default int thresholdPray() {return 10;}

	@ConfigItem(
			section = PRAYER_SETTINGS,
			keyName = "thresholdPrayColor",
			name = "Threshold Bar Color",
			description = "Color of Prayer Threshold Warning",
			position = 260
	)
	default Color thresholdPrayColor() {return new Color(194, 78, 255, 255);}

	@ConfigItem(
			section = SPECIAL_ATTACK_SETTINGS,
			keyName = "specColor",
			name = "Special Attack Color",
			description = "Color of Special Attack",
			position = 310
	)
	default Color specColor() {return new Color(255, 143, 51, 175);}

	@ConfigItem(
			section = SPECIAL_ATTACK_SETTINGS,
			keyName = "missingSpecColor",
			name = "Missing Special Attack Color",
			description = "Color of missing Special Attack (Background)",
			position = 320
	)
	default Color missingSpecColor() {return new Color(0, 0, 0, 150);}

	@ConfigItem(
			section = SPECIAL_ATTACK_SETTINGS,
			keyName = "showSpecThresholdWarning",
			name = "Recolor Bar at Threshold",
			description = "Show Special Attack Bar in Warning Color when the value is below the Threshold",
			position = 330
	)
	default boolean showSpecThresholdWarning()
	{
		return false;
	}

	@ConfigItem(
			section = SPECIAL_ATTACK_SETTINGS,
			keyName = "thresholdSpec",
			name = "Special Attack Threshold",
			description = "Special Attack Threshold",
			position = 340
	)
	default int thresholdSpec() {return 10;}

	@ConfigItem(
			section = SPECIAL_ATTACK_SETTINGS,
			keyName = "thresholdSpecColor",
			name = "Threshold Bar Color",
			description = "Color of Special Attack Threshold Warning",
			position = 350
	)
	default Color thresholdSpecColor() {return new Color(194, 78, 255, 255);}

	@ConfigItem(
			section = RUN_ENERGY_SETTINGS,
			keyName = "runColor",
			name = "Run Energy Color",
			description = "Color of Run Energy",
			position = 410
	)
	default Color runColor() {return new Color(255, 233, 78, 150);}

	@ConfigItem(
			section = RUN_ENERGY_SETTINGS,
			keyName = "missingRunColor",
			name = "Missing Run Energy Color",
			description = "Color of missing Run Energy (Background)",
			position = 420
	)
	default Color missingRunColor() {return new Color(0, 0, 0, 150);}

	@ConfigItem(
			section = RUN_ENERGY_SETTINGS,
			keyName = "showRunThresholdWarning",
			name = "Recolor Bar at Threshold",
			description = "Show Run Energy Bar in Warning Color when the value is below the Threshold",
			position = 430
	)
	default boolean showRunThresholdWarning()
	{
		return false;
	}

	@ConfigItem(
			section = RUN_ENERGY_SETTINGS,
			keyName = "thresholdRun",
			name = "Run Energy Threshold",
			description = "Run Energy Threshold",
			position = 440
	)
	default int thresholdRun() {return 10;}

	@ConfigItem(
			section = RUN_ENERGY_SETTINGS,
			keyName = "thresholdRunColor",
			name = "Threshold Bar Color",
			description = "Color of Run Energy Threshold Warning",
			position = 450
	)
	default Color thresholdRunColor() {return new Color(194, 78, 255, 255);}

	@ConfigItem(
			section = HITPOINT_SETTINGS,
			keyName = "showHpThresholdWarningBorder",
			name = "Show Hitpoint Threshold Border",
			description = "Show Hitpoint Bar Border when Hitpoints are below specified Threshold",
			position = 170
	)
	default boolean showHpThresholdWarningBorder()
	{
		return false;
	}

	@ConfigItem(
			section = HITPOINT_SETTINGS,
			keyName = "thresholdHpColorBorder",
			name = "Threshold Border Color",
			description = "Color of Hitpoint Bar Border when Hitpoints are below specified Threshold",
			position = 180
	)
	default Color thresholdHpColorBorder() {return new Color(194, 78, 255, 255);}

	@ConfigItem(
			section = PRAYER_SETTINGS,
			keyName = "showPrayThresholdWarningBorder",
			name = "Show Prayer Threshold Border",
			description = "Show Prayer Bar Border when Prayer Points are below specified Threshold",
			position = 270
	)
	default boolean showPrayThresholdWarningBorder()
	{
		return false;
	}

	@ConfigItem(
			section = PRAYER_SETTINGS,
			keyName = "thresholdPrayColorBorder",
			name = "Threshold Border Color",
			description = "Color of Prayer Bar Border when Prayer Points are below specified Threshold",
			position = 280
	)
	default Color thresholdPrayColorBorder() {return new Color(194, 78, 255, 255);}

	@ConfigItem(
			section = SPECIAL_ATTACK_SETTINGS,
			keyName = "showSpecThresholdWarningBorder",
			name = "Show Special Attack Threshold Border",
			description = "Show Special Attack Energy Bar Border when Special Attack Energy is below specified Threshold",
			position = 360
	)
	default boolean showSpecThresholdWarningBorder()
	{
		return false;
	}

	@ConfigItem(
			section = SPECIAL_ATTACK_SETTINGS,
			keyName = "thresholdSpecColorBorder",
			name = "Threshold Border Color",
			description = "Color of Special Attack Energy Bar Border when Special Attack Energy is below specified Threshold",
			position = 370
	)
	default Color thresholdSpecColorBorder() {return new Color(194, 78, 255, 255);}

	@ConfigItem(
			section = RUN_ENERGY_SETTINGS,
			keyName = "showRunThresholdWarningBorder",
			name = "Show Run Energy Threshold Border",
			description = "Show Special Attack Energy Bar Border when Special Attack Energy is below specified Threshold",
			position = 460
	)
	default boolean showRunThresholdWarningBorder()
	{
		return false;
	}

	@ConfigItem(
			section = RUN_ENERGY_SETTINGS,
			keyName = "thresholdRunColorBorder",
			name = "Threshold Border Color",
			description = "Color of Run Energy Bar Border when Run Energy is below specified Threshold",
			position = 470
	)
	default Color thresholdRunColorBorder() {return new Color(194, 78, 255, 255);}
}
