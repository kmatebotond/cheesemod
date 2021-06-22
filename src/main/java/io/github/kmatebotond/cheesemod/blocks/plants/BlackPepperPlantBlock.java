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

public class BlackPepperPlantBlock extends AbstractPlantBlock {
    public BlackPepperPlantBlock() {
        super(SETTINGS);
    }

    @Override
    public ItemStack getDropStack(Random random) {
        return new ItemStack(Items.BLACK_PEPPER, MathHelper.nextInt(random, 3, 4));
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        VoxelShape[] voxelShapes = {
                Block.createCuboidShape(4, 0, 4,13,5, 13),
                Block.createCuboidShape(3, 0, 3,14,11, 14),
                Block.createCuboidShape(1, 0, 1,15,16, 15),
                Block.createCuboidShape(1, 0, 1,15,16, 15),
        };
        return voxelShapes[state.get(AGE)];
    }
}
