//? if neoforge {
package io.github.jumperonjava.customcursor.platforms.neoforge;

import io.github.jumperonjava.customcursor.ConfigScreen;
import io.github.jumperonjava.customcursor.CustomCursorInit;
import io.github.jumperonjava.customcursor.ModPlatform;
import net.minecraft.client.gui.screen.Screen;
import net.neoforged.fml.ModList;
import net.neoforged.fml.ModLoadingContext;
import net.neoforged.fml.common.Mod;
//? if <1.21 {
import net.neoforged.neoforge.client.ConfigScreenHandler;
//?} else {
/*import net.neoforged.neoforge.client.gui.IConfigScreenFactory;
*///?}
@Mod("customcursor")
public class CustomCursorNeoForge {
	public CustomCursorNeoForge() {
		CustomCursorInit.entrypoint(new NeoForgePlatform());
        ModLoadingContext.get().registerExtensionPoint(
                //? if <1.21 {
                ConfigScreenHandler.ConfigScreenFactory.class,
                () -> new ConfigScreenHandler.ConfigScreenFactory(
                        ((client, parent) -> ConfigScreen.createCursorEditScreen(parent))
                )
                //?} else {
                /*IConfigScreenFactory.class,
                () -> (client, parent) -> CursorEditScreen.createCursorEditScreen(parent)
                *///?}
        );
	}
    public static class NeoForgePlatform implements ModPlatform {
        @Override
        public String getModloader() {
            return "NeoForge";
        }

        @Override
        public boolean isModLoaded(String modId) {
            return ModList.get().isLoaded(modId);
        }
    }
}
//?}