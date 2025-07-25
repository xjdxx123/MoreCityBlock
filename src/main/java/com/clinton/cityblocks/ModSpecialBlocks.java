package com.clinton.cityblocks;

import com.clinton.cityblocks.blockLogic.ModDoorBlock;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SaplingBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.minecraft.world.level.block.grower.AcaciaTreeGrower;


public class ModSpecialBlocks {
    public static RegistryObject<Block> CITY_ACACIA_DOOR;
    public static RegistryObject<Block> CITY_ACACIA_SAPLING;

    public static void registerAll() {
        // 注册门
        CITY_ACACIA_DOOR = ModBlocks.BLOCKS.register("city_acacia_door",
                () -> new ModDoorBlock(BlockBehaviour.Properties.copy(Blocks.ACACIA_DOOR).noOcclusion(), BlockSetType.ACACIA));
        ModBlocks.ITEMS.register("city_acacia_door",
                () -> new BlockItem(CITY_ACACIA_DOOR.get(), new Item.Properties().stacksTo(1)));

        // 注册树苗
        CITY_ACACIA_SAPLING = ModBlocks.BLOCKS.register("city_acacia_sapling",
                () -> new SaplingBlock(new AcaciaTreeGrower(), BlockBehaviour.Properties.copy(Blocks.ACACIA_SAPLING)));
        ModBlocks.ITEMS.register("city_acacia_sapling",
                () -> new BlockItem(CITY_ACACIA_SAPLING.get(), new Item.Properties())
        );


        // 把特殊方块放到 BLOCK_MAP
        ModBlocks.BLOCK_MAP.put("city_acacia_door", CITY_ACACIA_DOOR);
        ModBlocks.BLOCK_MAP.put("city_acacia_sapling", CITY_ACACIA_SAPLING);

    }
}
