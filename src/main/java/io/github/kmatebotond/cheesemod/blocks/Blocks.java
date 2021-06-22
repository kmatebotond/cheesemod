package io.github.kmatebotond.cheesemod.blocks;

import io.github.kmatebotond.cheesemod.blocks.milkchurn.MilkChurnBlock;
import io.github.kmatebotond.cheesemod.blocks.plants.AbstractPlantBlock;
import io.github.kmatebotond.cheesemod.blocks.plants.BlackPepperPlantBlock;
import io.github.kmatebotond.cheesemod.blocks.plants.ChilliPlantBlock;
import io.github.kmatebotond.cheesemod.blocks.plants.HazelnutPlantBlock;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;

public class Blocks {
    public static final Block MILK_CHURN = new MilkChurnBlock(FabricBlockSettings.of(Material.WOOD).breakByTool(FabricToolTags.AXES).strength(2.5f).sounds(BlockSoundGroup.WOOD));

    public static final AbstractPlantBlock HAZELNUT_PLANT = new HazelnutPlantBlock();
    public static final AbstractPlantBlock CHILLI_PLANT = new ChilliPlantBlock();
    public static final AbstractPlantBlock BLACK_PEPPER_PLANT = new BlackPepperPlantBlock();
}
