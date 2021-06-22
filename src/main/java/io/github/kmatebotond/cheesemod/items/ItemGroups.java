package io.github.kmatebotond.cheesemod.items;

import io.github.kmatebotond.cheesemod.CheeseMod;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class ItemGroups {
    public static final ItemGroup CHEESE_MOD = FabricItemGroupBuilder.build(new Identifier(CheeseMod.MOD_ID, "cheese_mod"), () -> new ItemStack(Items.CHEESE));
}
