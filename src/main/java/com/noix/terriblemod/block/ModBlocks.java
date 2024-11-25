package com.noix.terriblemod.block;

import com.noix.terriblemod.TerribleMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModBlocks {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(Registries.BLOCK, TerribleMod.MOD_ID);

    public static final RegistryObject<Block> STRANGE_STONE = BLOCKS.register("strange-stone",
            () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.STONE)));



    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }

}
