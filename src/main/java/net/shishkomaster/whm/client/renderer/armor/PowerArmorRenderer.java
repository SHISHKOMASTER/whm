package net.shishkomaster.whm.client.renderer.armor;

import net.shishkomaster.whm.client.model.armor.PowerArmorModel;
import net.shishkomaster.whm.item.PowerArmorItem;
import software.bernie.geckolib3.renderers.geo.GeoArmorRenderer;

    public class PowerArmorRenderer extends GeoArmorRenderer<PowerArmorItem> {
        public PowerArmorRenderer() {
            super(new PowerArmorModel());
            this.headBone = "helmet";
            this.bodyBone = "chestplate";
            this.rightArmBone = "rightArm";
            this.leftArmBone = "leftArm";
            this.rightLegBone = "rightLeg";
            this.leftLegBone = "leftLeg";
            this.rightBootBone = "rightBoot";
            this.leftBootBone = "leftBoot";
        }

}
