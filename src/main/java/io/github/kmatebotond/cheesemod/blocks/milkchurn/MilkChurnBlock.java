package io.github.kmatebotond.cheesemod.blocks.milkchurn;

import io.github.kmatebotond.cheesemod.items.Items;
import io.github.kmatebotond.cheesemod.items.cheeses.AbstractCheeseItem;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.Pair;
import net.minecraft.util.function.BooleanBiFunction;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

import java.util.function.Supplier;

public class MilkChurnBlock extends Block {
    public static final int MAX_LEVEL = Properties.LEVEL_3_MAX;
    public static final IntProperty LEVEL = IntProperty.of("level", 0, MAX_LEVEL); // in Properties.LEVEL_3 min is incorrectly set to 1 instead of 0
    public static final Supplier<Pair[]> INGREDIENT_TO_CHEESE_ARRAY_SUPPLIER = () -> new Pair[] {
            new Pair<>(null, Items.CHEESE),
            new Pair<>(Items.HAZELNUT, Items.HAZELNUT_CHEESE),
            new Pair<>(net.minecraft.item.Items.GHAST_TEAR, Items.GHAST_CHEESE),
            new Pair<>(Items.CHILLI, Items.CHILLI_CHEESE),
            new Pair<>(Items.BLACK_PEPPER, Items.BLACK_PEPPER_CHEESE),
            new Pair<>(net.minecraft.item.Items.SLIME_BALL, Items.SLIMY_CHEESE),
            new Pair<>(net.minecraft.item.Items.SEA_PICKLE, Items.SEA_PICKLE_CHEESE),
            new Pair<>(net.minecraft.item.Items.CHORUS_FRUIT, Items.END_CHEESE)
    };
    public static final IntProperty INGREDIENT = IntProperty.of("ingredient", 0, INGREDIENT_TO_CHEESE_ARRAY_SUPPLIER.get().length);

    public MilkChurnBlock(Settings settings) {
        super(settings);

        setDefaultState(getStateManager().getDefaultState().with(LEVEL, 0).with(INGREDIENT, 0));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(LEVEL, INGREDIENT);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        int level = state.get(LEVEL);
        int ingredient = state.get(INGREDIENT);
        ItemStack itemStack = player.getStackInHand(hand);
        PlayerInventory inventory = player.getInventory();
        int selectedSlot = inventory.selectedSlot;
        int heldIngredient = getHeldIngredient(itemStack);
        // Isn't full and milk bucket is used -> add one level
        if (level != MAX_LEVEL && itemStack.isOf(net.minecraft.item.Items.MILK_BUCKET)) {
            world.setBlockState(pos, state.with(LEVEL, level + 1));
            if (!player.isCreative()) {
                itemStack.decrement(1);
                if (itemStack.getCount() > 0) {
                    player.giveItemStack(new ItemStack(net.minecraft.item.Items.BUCKET));
                } else {
                    inventory.setStack(selectedSlot, new ItemStack(net.minecraft.item.Items.BUCKET));
                }
            }
            world.playSound(player, pos, SoundEvents.ITEM_BUCKET_EMPTY, SoundCategory.BLOCKS, 1, MathHelper.nextBetween(world.random, 0.8f, 1.2f));

            return ActionResult.SUCCESS;
        }
        // Isn't empty, has no ingredients and bucket is used -> remove one level
        else if (level > 0 && ingredient == 0 && itemStack.isOf(net.minecraft.item.Items.BUCKET)) {
            world.setBlockState(pos, state.with(LEVEL, level - 1));
            if (!player.isCreative()) {
                itemStack.decrement(1);
            }
            ItemStack milkBucket = new ItemStack(net.minecraft.item.Items.MILK_BUCKET);
            if (itemStack.getCount() > 0) {
                if (!inventory.contains(milkBucket)) {
                    player.giveItemStack(milkBucket);
                }
            } else {
                inventory.setStack(selectedSlot, new ItemStack(net.minecraft.item.Items.MILK_BUCKET));
            }
            world.playSound(player, pos, SoundEvents.ITEM_BUCKET_FILL, SoundCategory.BLOCKS, 1, MathHelper.nextBetween(world.random, 0.8f, 1.2f));

            return ActionResult.SUCCESS;
        }
        // Is full and some kind of ingredient is used -> set ingredient
        else if (level == MAX_LEVEL && ingredient == 0 && heldIngredient != -1) {
            world.setBlockState(pos, state.with(INGREDIENT, heldIngredient));
            if (!player.isCreative()) {
                itemStack.decrement(1);
            }
            world.playSound(player, pos, SoundEvents.BLOCK_SWEET_BERRY_BUSH_PICK_BERRIES, SoundCategory.BLOCKS, 1, MathHelper.nextBetween(world.random, 0.8f, 1.2f));

            return ActionResult.SUCCESS;
        }
        // Is full and milk churner is used -> give cheese according to ingredient
        else if (level == MAX_LEVEL && itemStack.isOf(Items.MILK_CHURNER)){
            world.setBlockState(pos, getDefaultState());
            dropStack(world, pos, new ItemStack(getCheese(state.get(INGREDIENT))));
            world.playSound(player, pos, SoundEvents.ENTITY_SLIME_SQUISH, SoundCategory.BLOCKS, 1, MathHelper.nextBetween(world.random, 0.8f, 1.2f));

            return ActionResult.SUCCESS;
        }

        return super.onUse(state, world, pos, player, hand, hit);
    }
    private int getHeldIngredient(ItemStack itemStack) {
        for (int i = 0; i < INGREDIENT_TO_CHEESE_ARRAY_SUPPLIER.get().length; i++) {
            if (itemStack.isOf((Item) INGREDIENT_TO_CHEESE_ARRAY_SUPPLIER.get()[i].getLeft())) {
                return i;
            }
        }
        return -1;
    }
    private AbstractCheeseItem getCheese(int ingredient) {
        return (AbstractCheeseItem) INGREDIENT_TO_CHEESE_ARRAY_SUPPLIER.get()[ingredient].getRight();
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return VoxelShapes.combineAndSimplify(
                VoxelShapes.fullCube(),
                createCuboidShape(2, 2, 2, 14, 16, 14),
                BooleanBiFunction.ONLY_FIRST
        );
    }
}
