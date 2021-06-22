package io.github.kmatebotond.cheesemod.items.plants;

import net.minecraft.block.Block;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class

ChilliBlockItem extends BlockItem {
    public ChilliBlockItem(Block block, Settings settings) {
        super(block, settings);
    }

    @Override
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        user.damage(DamageSource.player((PlayerEntity) user), 1);

        return user.eatFood(world, stack);
    }
}
