package com.clinton.cityblocks;

import com.clinton.cityblocks.blockLogic.ModDoorBlock;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModSpecialBlocks {
    public static RegistryObject<Block> CITY_ACACIA_DOOR;

    public static void registerAll() {
        // 注册门
        CITY_ACACIA_DOOR = ModBlocks.BLOCKS.register("city_acacia_door",
                () -> new ModDoorBlock(BlockBehaviour.Properties.copy(Blocks.ACACIA_DOOR).noOcclusion(), BlockSetType.ACACIA));
        // 门的物品（不可堆叠）
        ModBlocks.ITEMS.register("city_acacia_door",
                () -> new BlockItem(CITY_ACACIA_DOOR.get(), new Item.Properties().stacksTo(1)));



        // 把特殊方块放到 BLOCK_MAP
        ModBlocks.BLOCK_MAP.put("city_acacia_door", CITY_ACACIA_DOOR);
    }
}
