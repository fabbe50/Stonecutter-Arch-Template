package com.example.template;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;

public class ConfigScreen extends Screen {

    public ConfigScreen(Screen parent) {
        super(Text.empty());
    }

    @Override
    protected void init() {
       addDrawableChild(((context, mouseX, mouseY, delta) -> {
           context.drawCenteredTextWithShadow(client.textRenderer,
                   "Hello, world",
                   width / 2,
                   height / 2,
                   0xFFFFFFFF);
       }));
    }

    public static ConfigScreen createCursorEditScreen(Screen parent) {
        return new ConfigScreen(parent);
    }
}
