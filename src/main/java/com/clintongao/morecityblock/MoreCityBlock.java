package com.clintongao.morecityblock;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;


@Mod(MoreCityBlock.MODID)
public class MoreCityBlock {

    public static final String MODID = "morecityblock";

    public MoreCityBlock(IEventBus modEventBus) {
        ModBlocks.register(modEventBus);
        System.out.println("Hello from MoreCityBlock mod!");
    }
}
