//? if fabric {
/*package io.github.jumperonjava.customcursor.platforms.fabric;

import io.github.jumperonjava.customcursor.ModPlatform;
import net.fabricmc.api.ModInitializer;
import io.github.jumperonjava.customcursor.CustomCursorInit;
import net.fabricmc.loader.api.FabricLoader;

public class CustomCursorFabric implements ModInitializer {
	@Override
	public void onInitialize() {
		CustomCursorInit.entrypoint(new FabricPlatform());
	}
	public static class FabricPlatform implements ModPlatform{

		@Override
		public String getModloader() {
			return "Fabric";
		}

		@Override
		public boolean isModLoaded(String modloader) {
			return FabricLoader.getInstance().isModLoaded(modloader);
		}
	}
}
*///?}