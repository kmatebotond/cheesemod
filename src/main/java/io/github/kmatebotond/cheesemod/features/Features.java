package io.github.kmatebotond.cheesemod.features;

import net.minecraft.world.gen.decorator.ChanceDecoratorConfig;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;

public class Features {
    public static Feature<DefaultFeatureConfig> PLANT = new PlantFeature(DefaultFeatureConfig.CODEC);
    public static ConfiguredFeature<?, ?> CONFIGURED_PLANT = PLANT.configure(FeatureConfig.DEFAULT).decorate(Decorator.CHANCE.configure(new ChanceDecoratorConfig(20)));
}
