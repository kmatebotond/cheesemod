package io.github.kmatebotond.cheesemod.items.cheeses;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class SmokedGhastCheeseItem extends AbstractCheeseItem {
    public SmokedGhastCheeseItem() {
        super(SMOKED_SETTINGS);
    }

    @Override
    public void effect(ItemStack stack, World world, LivingEntity user) {
        user.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, SMOKED_EFFECT_DURATION, EFFECT_AMPLIFIER));
    }
}
