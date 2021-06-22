package io.github.kmatebotond.cheesemod.items.cheeses;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.world.World;

public class EndCheeseItem extends AbstractCheeseItem {
    public EndCheeseItem() {
        super(SETTINGS);
    }

    @Override
    public void effect(ItemStack stack, World world, LivingEntity user) {
        Items.CHORUS_FRUIT.finishUsing(stack, world, user);
        if (user instanceof PlayerEntity playerEntity) {
            playerEntity.getItemCooldownManager().set(Items.CHORUS_FRUIT, 0);
            playerEntity.getItemCooldownManager().set(this, 20);
        }
    }
}
