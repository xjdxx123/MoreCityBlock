package com.clinton.cityblocks.event;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import static com.clinton.cityblocks.CityBlocks.MODID;
import static com.clinton.cityblocks.CityBlocks.city_end_stone;



/*
把mod物品注册进原版物品栏
 */
//@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, modid = MODID)
//public class EventListener {
//    @SubscribeEvent
//    public static void addCreativeTab(BuildCreativeModeTabContentsEvent event) {
//        if (event.getTabKey() == CreativeModeTabs.FUNCTIONAL_BLOCKS){
//            event.accept(city_end_stone);
//        }
//
//    }
//}


