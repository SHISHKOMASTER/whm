package net.shishkomaster.whm.registry;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.shishkomaster.whm.Whm;
import net.shishkomaster.whm.item.ModArmorMaterial;
import net.shishkomaster.whm.utils.ModItemGroups;

public class ModRegistry {

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Whm.MOD_ID);

    public static final RegistryObject<Item> Whm_logo1 = ITEMS.register("whm_logo1",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> Bolter = ITEMS.register("bolter",
            () -> new Item(new Item.Properties().tab(ModItemGroups.WHM_TAB).stacksTo(1)));

    public static final RegistryObject<Item> Chainsword = ITEMS.register("chainsword",
            () -> new Item(new Item.Properties().tab(ModItemGroups.WHM_TAB).stacksTo(1)));
    
    
    public static final RegistryObject<Item> POWERARMOR_BOOTS = ITEMS.register("power_armor_boots",
            () -> new ArmorItem(ModArmorMaterial.POWERARMOR, EquipmentSlotType.FEET,
                    new Item.Properties().tab(ModItemGroups.WHM_TAB)));
    public static final RegistryObject<Item> POWERARMOR_CHESTPLATE = ITEMS.register("power_armor_chestplate",
                () -> new ArmorItem(ModArmorMaterial.POWERARMOR, EquipmentSlotType.CHEST,
                        new Item.Properties().tab(ModItemGroups.WHM_TAB)));
    public static final RegistryObject<Item> POWERARMOR_LEGGINGS = ITEMS.register("power_armor_leggings",
                () -> new ArmorItem(ModArmorMaterial.POWERARMOR, EquipmentSlotType.LEGS,
                        new Item.Properties().tab(ModItemGroups.WHM_TAB)));
    public static final RegistryObject<Item> POWERARMOR_HELMET = ITEMS.register("power_armor_helmet",
                () -> new ArmorItem(ModArmorMaterial.POWERARMOR, EquipmentSlotType.HEAD,
                        new Item.Properties().tab(ModItemGroups.WHM_TAB)));
    
    

    public  static void register(IEventBus eventBus){
        ITEMS.register(eventBus);

    }
}
