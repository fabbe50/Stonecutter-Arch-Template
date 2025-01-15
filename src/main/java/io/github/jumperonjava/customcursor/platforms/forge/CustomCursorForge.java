//? if forge {
/*package io.github.jumperonjava.customcursor.platforms.forge;

import io.github.jumperonjava.customcursor.ConfigScreen;
import io.github.jumperonjava.customcursor.CustomCursorInit;
import io.github.jumperonjava.customcursor.ModPlatform;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;

@Mod("customcursor")
public class CustomCursorForge {
	public CustomCursorForge() {
		CustomCursorInit.entrypoint(new ForgePlatform());
        MinecraftForge.registerConfigScreen(ConfigScreen::createCursorEditScreen);
	}
	public static class ForgePlatform implements ModPlatform {
		@Override
		public String getModloader() {
			return "LexForge";
		}

		@Override
		public boolean isModLoaded(String modId) {
			return ModList.get().isLoaded(modId);
		}
	}

}
*///?}