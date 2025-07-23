package com.clinton.cityblocks;

import com.clinton.cityblocks.blockLogic.HorizontalFacingBlock;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, CityBlocks.MODID);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, CityBlocks.MODID);

    // 储存所有方块和对应名字
    public static final Map<String, RegistryObject<Block>> BLOCK_MAP = new HashMap<>();

    static {
        registerBlock("city_end_stone", () -> new Block(BlockBehaviour.Properties.of().strength(3.0f).sound(SoundType.STONE)));
        registerBlock(
                "city_bee_nest",
                () -> new HorizontalFacingBlock(BlockBehaviour.Properties.of().strength(1.5f).sound(SoundType.WOOD))
        );
    }

    private static void registerBlock(String name, Supplier<Block> blockSupplier) {
        RegistryObject<Block> block = BLOCKS.register(name, blockSupplier);
        BLOCK_MAP.put(name, block);

        // 自动注册对应的 BlockItem
        ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }
}
