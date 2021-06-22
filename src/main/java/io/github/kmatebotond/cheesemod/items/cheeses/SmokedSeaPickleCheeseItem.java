package io.github.kmatebotond.cheesemod.items.cheeses;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class SmokedSeaPickleCheeseItem extends AbstractCheeseItem {
    public SmokedSeaPickleCheeseItem() {
        super(SMOKED_SETTINGS);
    }

    @Override
    public void effect(ItemStack stack, World world, LivingEntity user) {
        user.addStatusEffect(new StatusEffectInstance(StatusEffects.WATER_BREATHING, SMOKED_EFFECT_DURATION));
    }
}
