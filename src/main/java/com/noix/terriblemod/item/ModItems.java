package com.noix.terriblemod.item;

import com.noix.terriblemod.TerribleMod;
import com.noix.terriblemod.block.ModBlocks;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;


public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, TerribleMod.MOD_ID);

    public static final RegistryObject<Item> SLIPPERS = ITEMS.register("slippers",
            () -> new Item(new Item.Properties().durability(256)));

    public static final RegistryObject<Item> STRANGE_STONE = ITEMS.register("strange_stone",
            () -> new BlockItem(ModBlocks.STRANGE_STONE.get(), new Item.Properties()));

    public static final RegistryObject<Item> WIERD_MEAT = ITEMS.register("wierd_meat",
            () -> new Item(new Item.Properties()
                    .food(new FoodProperties.Builder()
                            .alwaysEat()
                            .nutrition(4)
                            .saturationMod(1.2f)
                            .alwaysEat()
                            .effect(() -> new MobEffectInstance(MobEffects.CONFUSION, 200, 1), 1f)
                            .effect(() -> new MobEffectInstance(MobEffects.POISON, 200, 1), 0.25f)
                            .effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 400, 1), 0.5f)
                            .build())));


    public static List<RegistryObject<Item>> getAllItems() {
        return ITEMS.getEntries().stream().toList();
    }

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
