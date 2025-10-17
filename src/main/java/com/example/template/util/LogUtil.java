package com.example.template.util;

import com.example.template.TempLateInit;
import com.example.template.ModConfig;

public class LogUtil {
    public static void log(String msg) {
        TempLateInit.LOGGER.info(msg);
    }

    public static void debug(String msg) {
        if (ModConfig.debugMode.getValue()) {
            TempLateInit.LOGGER.info("[DEBUG] {}", msg);
        } else {
            TempLateInit.LOGGER.debug(msg);
        }
    }

    public static void warn(String msg) {
        TempLateInit.LOGGER.warn(msg);
    }

    public static void error(String msg) {
        TempLateInit.LOGGER.error(msg);
    }
}
