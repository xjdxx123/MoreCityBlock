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

    // 注册创造物品栏
    private static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);
    public static final RegistryObject<CreativeModeTab> city_blocks_tab = CREATIVE_MODE_TABS.register("city_blocks_tab", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.city_blocks_tab")) // 改为标准 key
            .icon(() -> new ItemStack(ModBlocks.BLOCK_MAP.get("city_end_stone").get().asItem()))
            .displayItems((params, output) -> {
                for (RegistryObject<Block> block : ModBlocks.BLOCK_MAP.values()) {
                    output.accept(block.get().asItem());
                }
            })
            .build());

    public CityBlocks() {
        var bus = FMLJavaModLoadingContext.get().getModEventBus();
        ModBlocks.BLOCKS.register(bus);
        ModBlocks.ITEMS.register(bus);
        CREATIVE_MODE_TABS.register(bus);
    }
}
