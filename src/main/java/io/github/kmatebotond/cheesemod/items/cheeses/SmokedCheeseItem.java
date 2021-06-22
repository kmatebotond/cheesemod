package io.github.kmatebotond.cheesemod.items.cheeses;

import io.github.kmatebotond.cheesemod.items.Items;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class SmokedCheeseItem extends AbstractCheeseItem {
    public SmokedCheeseItem() {
        super(SMOKED_SETTINGS);
    }

    @Override
    public void effect(ItemStack stack, World world, LivingEntity user) {
        Items.CHEESE.effect(stack, world, user);
    }
}
