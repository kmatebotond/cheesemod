package io.github.kmatebotond.cheesemod.items;

import io.github.kmatebotond.cheesemod.blocks.Blocks;
import io.github.kmatebotond.cheesemod.items.cheeses.*;
import io.github.kmatebotond.cheesemod.items.milkchurn.MilkChurnBlockItem;
import io.github.kmatebotond.cheesemod.items.milkchurn.MilkChurnerItem;
import io.github.kmatebotond.cheesemod.items.plants.BlackPepperBlockItem;
import io.github.kmatebotond.cheesemod.items.plants.ChilliBlockItem;
import io.github.kmatebotond.cheesemod.items.plants.HazelnutBlockItem;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;

public class Items {
    public static final Item MILK_CHURN = new MilkChurnBlockItem(Blocks.MILK_CHURN, new Item.Settings().group(ItemGroups.CHEESE_MOD));
    public static final Item MILK_CHURNER = new MilkChurnerItem(new Item.Settings().group(ItemGroups.CHEESE_MOD));

    public static final Item HAZELNUT = new HazelnutBlockItem(Blocks.HAZELNUT_PLANT, new Item.Settings().food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build()).group(ItemGroups.CHEESE_MOD));
    public static final Item CHILLI = new ChilliBlockItem(Blocks.CHILLI_PLANT, new Item.Settings().food(new FoodComponent.Builder().hunger(2).saturationModifier(0.2f).build()).group(ItemGroups.CHEESE_MOD));
    public static final Item BLACK_PEPPER = new BlackPepperBlockItem(Blocks.BLACK_PEPPER_PLANT, new Item.Settings().group(ItemGroups.CHEESE_MOD));

    public static final AbstractCheeseItem CHEESE = new CheeseItem();
    public static final AbstractCheeseItem SMOKED_CHEESE = new SmokedCheeseItem();
    public static final AbstractCheeseItem HAZELNUT_CHEESE = new HazelnutCheeseItem();
    public static final AbstractCheeseItem SMOKED_HAZELNUT_CHEESE = new SmokedHazelnutCheeseItem();
    public static final AbstractCheeseItem GHAST_CHEESE = new GhastCheeseItem();
    public static final AbstractCheeseItem SMOKED_GHAST_CHEESE = new SmokedGhastCheeseItem();
    public static final AbstractCheeseItem CHILLI_CHEESE = new ChilliCheeseItem();
    public static final AbstractCheeseItem SMOKED_CHILLI_CHEESE = new SmokedChilliCheeseItem();
    public static final AbstractCheeseItem BLACK_PEPPER_CHEESE = new BlackPepperCheeseItem();
    public static final AbstractCheeseItem SMOKED_BLACK_PEPPER_CHEESE = new SmokedBlackPepperCheeseItem();
    public static final AbstractCheeseItem SLIMY_CHEESE = new SlimyCheeseItem();
    public static final AbstractCheeseItem SMOKED_SLIMY_CHEESE = new SmokedSlimyCheeseItem();
    public static final AbstractCheeseItem SEA_PICKLE_CHEESE = new SeaPickleCheeseItem();
    public static final AbstractCheeseItem SMOKED_SEA_PICKLE_CHEESE = new SmokedSeaPickleCheeseItem();
    public static final AbstractCheeseItem END_CHEESE = new EndCheeseItem();
    public static final AbstractCheeseItem SMOKED_END_CHEESE = new SmokedEndCheeseItem();
}
