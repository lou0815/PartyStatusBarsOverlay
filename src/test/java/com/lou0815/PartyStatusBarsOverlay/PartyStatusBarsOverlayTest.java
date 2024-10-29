package com.lou0815.PartyStatusBarsOverlay;

import net.runelite.client.RuneLite;
import net.runelite.client.externalplugins.ExternalPluginManager;

public class PartyStatusBarsOverlayTest
{
	public static void main(String[] args) throws Exception
	{
		ExternalPluginManager.loadBuiltin(PartyStatusBarsOverlayPlugin.class);
		RuneLite.main(args);
	}
}