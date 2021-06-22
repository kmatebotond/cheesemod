package io.github.kmatebotond.cheesemod.items.cheeses;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class SlimyCheeseItem extends AbstractCheeseItem {
    public SlimyCheeseItem() {
        super(SETTINGS);
    }

    @Override
    public void effect(ItemStack stack, World world, LivingEntity user) {
        user.addStatusEffect(new StatusEffectInstance(StatusEffects.JUMP_BOOST, EFFECT_DURATION, EFFECT_AMPLIFIER));
    }
}
