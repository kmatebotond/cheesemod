package io.github.kmatebotond.cheesemod.items.cheeses;

import io.github.kmatebotond.cheesemod.items.ItemGroups;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public abstract class AbstractCheeseItem extends Item {
    public static final Item.Settings SETTINGS = new Item.Settings().maxCount(8).food(new FoodComponent.Builder().hunger(5).saturationModifier(0.6f).alwaysEdible().build()).group(ItemGroups.CHEESE_MOD);
    public static final Item.Settings SMOKED_SETTINGS = new Item.Settings().maxCount(8).food(new FoodComponent.Builder().hunger(7).saturationModifier(0.6f).alwaysEdible().build()).group(ItemGroups.CHEESE_MOD);

    public static final int EFFECT_DURATION = 1200;
    public static final int SMOKED_EFFECT_DURATION = 3600;
    public static final int EFFECT_AMPLIFIER = 1;

    public AbstractCheeseItem(Settings settings) {
        super(settings);
    }

    @Override
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        effect(stack, world, user);

        return user.eatFood(world, stack);
    }

    public abstract void effect(ItemStack stack, World world, LivingEntity user);
}
