package io.github.kmatebotond.cheesemod.items.cheeses;

import io.github.kmatebotond.cheesemod.items.Items;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class SmokedEndCheeseItem extends AbstractCheeseItem {
    public SmokedEndCheeseItem() {
        super(SMOKED_SETTINGS);
    }

    @Override
    public void effect(ItemStack stack, World world, LivingEntity user) {
        Items.END_CHEESE.effect(stack, world, user);
        if (user instanceof PlayerEntity playerEntity) {
            playerEntity.getItemCooldownManager().set(Items.END_CHEESE, 0);
            playerEntity.getItemCooldownManager().set(this, 10);
        }
    }
}
