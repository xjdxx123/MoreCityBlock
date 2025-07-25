package com.clinton.cityblocks.event;

import com.clinton.cityblocks.CityBlocks;
import com.clinton.cityblocks.ModSpecialBlocks;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.client.event.ModelEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.client.event.RegisterClientReloadListenersEvent;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import com.clinton.cityblocks.ModBlocks;

@Mod.EventBusSubscriber(modid = CityBlocks.MODID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ClientModEvents {

    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {
        // 注册所有 cutout 类型的方块
        event.enqueueWork(() -> {

            // 调整渲染层级
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.BLOCK_MAP.get("city_orange_tulip").get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.BLOCK_MAP.get("city_acacia_leaves").get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.BLOCK_MAP.get("city_allium").get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.BLOCK_MAP.get("city_azalea_leaves").get(), RenderType.cutout());



            ItemBlockRenderTypes.setRenderLayer(ModSpecialBlocks.CITY_ACACIA_DOOR.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(ModSpecialBlocks.CITY_ACACIA_SAPLING.get(), RenderType.cutout());


            // 可以添加更多需要 cutout 的方块
        });
    }
}
