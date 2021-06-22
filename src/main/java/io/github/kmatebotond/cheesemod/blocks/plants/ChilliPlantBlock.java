package io.github.kmatebotond.cheesemod.blocks.plants;

import io.github.kmatebotond.cheesemod.items.Items;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;

import java.util.Random;

public class ChilliPlantBlock extends AbstractPlantBlock {
    public ChilliPlantBlock() {
        super(SETTINGS);
    }

    @Override
    public ItemStack getDropStack(Random random) {
        return new ItemStack(Items.CHILLI, MathHelper.nextInt(random, 2, 3));
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        VoxelShape[] voxelShapes = {
                Block.createCuboidShape(5, 0, 5,11,4, 11),
                Block.createCuboidShape(4, 0, 4,13,9, 13),
                Block.createCuboidShape(1, 0, 1,15,11, 15),
                Block.createCuboidShape(1, 0, 1,16,11, 16),
        };
        return voxelShapes[state.get(AGE)];
    }
}
