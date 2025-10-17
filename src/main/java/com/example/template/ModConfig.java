package com.example.template;

import com.example.template.config.*;
import dev.architectury.platform.Platform;
import me.shedaniel.clothconfig2.api.AbstractConfigListEntry;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;

public class ModConfig {
    private static File configFile;

    private static final Map<String, IConfigOption<?, ?>> configOptions = new LinkedHashMap<>();

    public static BooleanOption debugMode = addConfig(new BooleanOption("debugMode", true));

    // Config options go here:



    public static void register() {
        LogUtil.log("Registering config...");
        configFile = new File(Platform.getConfigFolder().toFile(), TempLateInit.MOD_ID + ".properties");
        load(configFile);
        LogUtil.log("Config registered!");
    }

    public static File getConfigFile() {
        return configFile;
    }

    public static void load(File file) {
        try {
            LogUtil.log("Loading config...");
            FileInputStream fis = new FileInputStream(file);
            Properties properties = new Properties();
            properties.load(fis);
            fis.close();

            for (String key : configOptions.keySet()) {
                IConfigOption<?, ?> config = configOptions.get(key);
                config.readData(properties);
            }

            LogUtil.log("Config loaded!");
        } catch (IOException e) {
            try {
                save(file);
                load(file);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    public static void save(File file) throws IOException {
        LogUtil.log("Saving config...");
        FileOutputStream fos = new FileOutputStream(file, false);

        for (String key : configOptions.keySet()) {
            IConfigOption<?, ?> config = configOptions.get(key);
            config.writeData(fos);
        }

        fos.close();
        LogUtil.log("Config saved!");
    }

    private static <T, R, V extends IConfigOption<T, R>> V addConfig(V configOption) {
        configOptions.put(configOption.getKey(), configOption);
        return configOption;
    }

    public static Map<String, IConfigOption<?, ?>> getConfigOptions() {
        return configOptions;
    }
}
