package io.github.jokypond;

import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.api.ModInitializer;

import net.minecraft.resources.Identifier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static io.github.jokypond.PoxyMixinPlugin.isAndroid;

public class Poxy implements ModInitializer {
    public static final String MOD_ID = "poxy";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        LOGGER.info("Poxy loaded successfully!");
        if(!isAndroid()) {
            LOGGER.warn("Poxy has detected we are loaded on a non-Android platform! Disabling mixins.");
        }
    }

    public static Identifier id(String path) {
        return Identifier.fromNamespaceAndPath(MOD_ID, path);
    }
}