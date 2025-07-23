package com.clinton.cityblocks;

import com.mojang.logging.LogUtils;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import org.slf4j.Logger;
import org.w3c.dom.DOMError;

import static net.minecraft.world.item.crafting.CookingBookCategory.BLOCKS;


@Mod(CityBlocks.MODID)
public class CityBlocks {
    public static final String MODID = "cityblocks";
    private static final Logger LOGGER = LogUtils.getLogger();

    private static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MODID);
    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);

    private static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);

    public static final RegistryObject<Block> city_end_stone = BLOCKS.register("city_end_stone", () -> new Block(BlockBehaviour.Properties.of().strength(3.0f).sound(SoundType.CROP)));
    public static final RegistryObject<Item> city_end_stone_item= ITEMS.register("city_end_stone", () -> new BlockItem(city_end_stone.get(), new Item.Properties()));

    /
    public static final RegistryObject<CreativeModeTab> city_blocks_tab = CREATIVE_MODE_TABS.register("city_blocks_tab", () -> CreativeModeTab.builder()
            .title(Component.translatable("城市建筑"))
            .icon(() -> new ItemStack(city_end_stone_item.get()))
            .displayItems((parm, output) -> {
                output.accept(city_end_stone.get());
                output.accept(city_end_stone_item.get());
            })
            .build());

    public CityBlocks() {
        var bus = FMLJavaModLoadingContext.get().getModEventBus();
        BLOCKS.register(bus);
        ITEMS.register(bus);
//        bus.register(CityBlocks.class);
        CREATIVE_MODE_TABS.register(bus);
    }
}
