package io.github.kmatebotond.cheesemod;

import io.github.kmatebotond.cheesemod.blocks.Blocks;
import io.github.kmatebotond.cheesemod.features.Features;
import io.github.kmatebotond.cheesemod.items.Items;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;

public class CheeseMod implements ModInitializer {
    public static final String MOD_ID = "cheesemod";

    @Override
    public void onInitialize() {
        registerBlock("milk_churn", Blocks.MILK_CHURN);
        registerItem("milk_churn", Items.MILK_CHURN);
        registerItem("milk_churner", Items.MILK_CHURNER);

        registerBlock("hazelnut_plant", Blocks.HAZELNUT_PLANT);
        registerItem("hazelnut_plant", Items.HAZELNUT);
        registerBlock("chilli_plant", Blocks.CHILLI_PLANT);
        registerItem("chilli_plant", Items.CHILLI);
        registerBlock("black_pepper_plant", Blocks.BLACK_PEPPER_PLANT);
        registerItem("black_pepper_plant", Items.BLACK_PEPPER);

        registerItem("cheese", Items.CHEESE);
        registerItem("smoked_cheese", Items.SMOKED_CHEESE);
        registerItem("hazelnut_cheese", Items.HAZELNUT_CHEESE);
        registerItem("smoked_hazelnut_cheese", Items.SMOKED_HAZELNUT_CHEESE);
        registerItem("ghast_cheese", Items.GHAST_CHEESE);
        registerItem("smoked_ghast_cheese", Items.SMOKED_GHAST_CHEESE);
        registerItem("chilli_cheese", Items.CHILLI_CHEESE);
        registerItem("smoked_chilli_cheese", Items.SMOKED_CHILLI_CHEESE);
        registerItem("black_pepper_cheese", Items.BLACK_PEPPER_CHEESE);
        registerItem("smoked_black_pepper_cheese", Items.SMOKED_BLACK_PEPPER_CHEESE);
        registerItem("slimy_cheese", Items.SLIMY_CHEESE);
        registerItem("smoked_slimy_cheese", Items.SMOKED_SLIMY_CHEESE);
        registerItem("sea_pickle_cheese", Items.SEA_PICKLE_CHEESE);
        registerItem("smoked_sea_pickle_cheese", Items.SMOKED_SEA_PICKLE_CHEESE);
        registerItem("end_cheese", Items.END_CHEESE);
        registerItem("smoked_end_cheese", Items.SMOKED_END_CHEESE);

        registerFeature("plant", Features.PLANT);
        RegistryKey<ConfiguredFeature<?, ?>> plant = registerConfiguredFeature("plant", Features.CONFIGURED_PLANT);
        BiomeModifications.addFeature(BiomeSelectors.categories(Biome.Category.PLAINS, Biome.Category.FOREST), GenerationStep.Feature.VEGETAL_DECORATION, plant);
    }

    private void registerItem(String path, Item entry) {
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, path), entry);
    }
    private void registerBlock(String path, Block entry) {
        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, path), entry);
    }
    private void registerFeature(String path, Feature<DefaultFeatureConfig> entry) {
        Registry.register(Registry.FEATURE, new Identifier(MOD_ID, path), entry);
    }
    private RegistryKey<ConfiguredFeature<?, ?>> registerConfiguredFeature(String path, ConfiguredFeature<?, ?> entry) {
        RegistryKey<ConfiguredFeature<?, ?>> configuredFeatureRegistryKey = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY, new Identifier(MOD_ID, path));
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, configuredFeatureRegistryKey.getValue(), entry);

        return configuredFeatureRegistryKey;
    }

    private static final Item DUMMY = Items.CHEESE; // This allows me to register the blocks and items in the order I want them to. This is some cursed shit...
}