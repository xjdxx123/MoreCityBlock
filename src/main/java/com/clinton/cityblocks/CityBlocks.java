package com.clinton.cityblocks;

import com.mojang.logging.LogUtils;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import org.slf4j.Logger;

import static net.minecraft.world.item.crafting.CookingBookCategory.BLOCKS;


@Mod(CityBlocks.MODID)
public class CityBlocks {
    public static final String MODID = "cityblocks";
    private static final Logger LOGGER = LogUtils.getLogger();

    private static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MODID);
    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);

    public static final RegistryObject<Block> myBlock = BLOCKS.register("city_end_stone", () -> new Block(BlockBehaviour.Properties.of().strength(3.0f).sound(SoundType.CROP)));
    public static final RegistryObject<Item> myBlockItem = ITEMS.register("city_end_stone", () -> new BlockItem(myBlock.get(), new Item.Properties()));


    public CityBlocks() {
        var bus = FMLJavaModLoadingContext.get().getModEventBus();
        BLOCKS.register(bus);
        ITEMS.register(bus);
    }
}
