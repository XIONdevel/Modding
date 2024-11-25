package com.noix.terriblemod.tab;

import com.noix.terriblemod.TerribleMod;
import com.noix.terriblemod.item.ModItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeTab {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, TerribleMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> TERRIBLE_TAB = CREATIVE_MODE_TABS.register("terrible-tab",
            () -> CreativeModeTab.builder().withTabsBefore(CreativeModeTabs.COMBAT)
//            .icon(() -> ModItems.SLIPPERS.get().getDefaultInstance())
            .displayItems((parameters, output) -> {
                ModItems.getAllItems().forEach(item -> output.accept(item.get()));
//                output.accept(ModItems.STRANGE_STONE.get());
            }).build());

    public static void register(IEventBus modEventBus) {
        CREATIVE_MODE_TABS.register(modEventBus);
    }
}
