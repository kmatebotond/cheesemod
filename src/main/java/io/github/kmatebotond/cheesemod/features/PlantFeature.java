package io.github.kmatebotond.cheesemod.features;

import com.mojang.serialization.Codec;
import io.github.kmatebotond.cheesemod.blocks.Blocks;
import io.github.kmatebotond.cheesemod.blocks.plants.AbstractPlantBlock;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.Heightmap;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.util.FeatureContext;

import java.util.Random;

public class PlantFeature extends Feature<DefaultFeatureConfig> {
    public PlantFeature(Codec<DefaultFeatureConfig> configCodec) {
        super(configCodec);
    }

    @Override
    public boolean generate(FeatureContext<DefaultFeatureConfig> context) {
        StructureWorldAccess world = context.getWorld();
        Random random = context.getRandom();
        BlockPos randomPosition = context.getOrigin().north(MathHelper.nextInt(random, -8, 8)).west(MathHelper.nextInt(random, -8, 8));
        BlockPos randomTopPosition = world.getTopPosition(Heightmap.Type.WORLD_SURFACE, randomPosition);
        BlockState blockState = switch (random.nextInt(3)) {
            case 0 -> Blocks.HAZELNUT_PLANT.getDefaultState();
            case 1 -> Blocks.CHILLI_PLANT.getDefaultState();
            case 2 -> Blocks.BLACK_PEPPER_PLANT.getDefaultState();
            default -> null;
        };
        if (blockState.canPlaceAt(world, randomTopPosition)) {
            world.setBlockState(randomTopPosition, blockState.with(AbstractPlantBlock.AGE, AbstractPlantBlock.MAX_AGE), 0);

            return true;
        }
        return false;
    }
}
