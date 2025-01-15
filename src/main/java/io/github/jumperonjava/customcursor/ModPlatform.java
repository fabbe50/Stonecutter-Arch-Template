package io.github.jumperonjava.template;

public interface ModPlatform {
    String getModloader();
    boolean isModLoaded(String modloader);
}
