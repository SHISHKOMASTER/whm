package net.shishkomaster.whm.item;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.item.ArmorStandEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.Item;
import net.shishkomaster.whm.registry.ModRegistry;
import net.shishkomaster.whm.utils.ModItemGroups;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;
import software.bernie.geckolib3.item.GeoArmorItem;

public class PowerArmorItem extends GeoArmorItem implements IAnimatable {
    private AnimationFactory factory = new AnimationFactory(this);

    public PowerArmorItem(IArmorMaterial materialIn, EquipmentSlotType slot, Properties builder) {
        super(materialIn, slot, builder.tab(ModItemGroups.WHM_TAB));
    }

    private <P extends IAnimatable> PlayState predicate(AnimationEvent<P> event) {

        LivingEntity livingEntity = event.getExtraDataOfType(LivingEntity.class).get(0);

        event.getController().setAnimation(new AnimationBuilder().addAnimation("none", true));
        if (livingEntity instanceof ArmorStandEntity) {
            return PlayState.CONTINUE;
        }

        else if (livingEntity instanceof PlayerEntity) {
            PlayerEntity player = (PlayerEntity) livingEntity;

            List<Item> equipmentList = new ArrayList<>();
            player.getAllSlots().forEach((x) -> equipmentList.add(x.getItem()));

            List<Item> armorList = equipmentList.subList(2, 6);

            boolean isWearingAll = armorList
                    .containsAll(Arrays.asList(ModRegistry.POWERARMOR_BOOTS.get(), ModRegistry.POWERARMOR_LEGGINGS.get(),
                            ModRegistry.POWERARMOR_CHESTPLATE.get(), ModRegistry.POWERARMOR_HELMET.get()));
            return isWearingAll ? PlayState.CONTINUE : PlayState.STOP;
        }
        return PlayState.STOP;
    }

    @Override
    public void registerControllers(AnimationData data) {
        data.addAnimationController(new AnimationController<PowerArmorItem>(this, "controller", 20, this::predicate));
    }

    @Override
    public AnimationFactory getFactory() {
        return this.factory;
    }
}