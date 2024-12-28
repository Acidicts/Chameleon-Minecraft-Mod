package io.github.acidicts.block.entity.client;

import io.github.acidicts.WorkshopMod;
import io.github.acidicts.block.entity.custom.ChameleonEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;

public class ChameleonModel<T extends ChameleonEntity> extends SinglePartEntityModel<T> {
    public static final EntityModelLayer CHAMELEON = new EntityModelLayer(Identifier.of(WorkshopMod.MOD_ID, "chameleon"), "main");

    private final ModelPart chameleon;
    private final ModelPart head;

    public ChameleonModel(ModelPart root) {
        this.chameleon = root.getChild("Chameleon");
        this.head = this.chameleon.getChild("Body").getChild("Head");
        }
    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData Chameleon = modelPartData.addChild("Chameleon", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

        ModelPartData Body = Chameleon.addChild("Body", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData BackRightLeg = Body.addChild("BackRightLeg", ModelPartBuilder.create().uv(11, 11).cuboid(-1.5F, 1.0F, -2.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
                .uv(6, 20).cuboid(-1.0F, 0.0F, -1.0F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(-1.0F, -2.0F, 6.0F));

        ModelPartData RightFrontLeg = Body.addChild("RightFrontLeg", ModelPartBuilder.create().uv(10, 20).cuboid(-2.0F, 0.0F, -0.5F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F))
                .uv(20, 15).cuboid(-1.0F, 0.0F, -0.5F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
                .uv(14, 20).cuboid(-2.5F, 1.0F, -1.5F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(-1.0F, -2.0F, -2.5F));

        ModelPartData Eye = Body.addChild("Eye", ModelPartBuilder.create().uv(20, 3).cuboid(-1.0F, -1.0F, -2.0F, 2.0F, 1.0F, 1.0F, new Dilation(0.0F))
                .uv(19, 0).cuboid(-1.0F, -1.0F, -1.0F, 2.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -3.0F, -3.0F));

        ModelPartData Head = Body.addChild("Head", ModelPartBuilder.create().uv(14, 11).cuboid(-1.0F, -1.0F, -4.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(9, 0).cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(11, 7).cuboid(-1.0F, -2.0F, -3.0F, 2.0F, 1.0F, 3.0F, new Dilation(0.0F))
                .uv(6, 17).cuboid(-1.0F, -3.0F, -2.0F, 2.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -3.0F, -3.0F));

        ModelPartData Neck = Body.addChild("Neck", ModelPartBuilder.create().uv(0, 17).cuboid(-1.0F, -5.0F, -3.0F, 2.0F, 4.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData Back = Body.addChild("Back", ModelPartBuilder.create().uv(0, 0).cuboid(-1.0F, -6.0F, -2.0F, 2.0F, 5.0F, 5.0F, new Dilation(0.0F))
                .uv(0, 10).cuboid(-2.0F, -5.0F, -1.0F, 4.0F, 4.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData Tail = Body.addChild("Tail", ModelPartBuilder.create().uv(14, 15).cuboid(-1.0F, -1.0F, 1.0F, 2.0F, 4.0F, 1.0F, new Dilation(0.0F))
                .uv(19, 19).cuboid(-1.0F, 0.0F, 2.0F, 2.0F, 3.0F, 1.0F, new Dilation(0.0F))
                .uv(18, 7).cuboid(-1.0F, 1.0F, 3.0F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F))
                .uv(14, 4).cuboid(-1.0F, 2.0F, 4.0F, 2.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -4.0F, 2.0F));

        ModelPartData LeftFrontLeg = Body.addChild("LeftFrontLeg", ModelPartBuilder.create().uv(20, 10).cuboid(1.0F, 0.0F, 0.0F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F))
                .uv(0, 22).cuboid(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
                .uv(20, 17).cuboid(1.5F, 1.0F, -1.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(1.0F, -2.0F, -3.0F));

        ModelPartData LeftBackLeg = Body.addChild("LeftBackLeg", ModelPartBuilder.create().uv(0, 3).cuboid(0.5F, 1.0F, -2.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
                .uv(0, 0).cuboid(0.0F, 0.0F, -1.0F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(1.0F, -2.0F, 6.0F));
        return TexturedModelData.of(modelData, 32, 32);
    }
    @Override
    public void setAngles(ChameleonEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.getPart().traverse().forEach(ModelPart::resetTransform);
        this.setHeadAngles(netHeadYaw, headPitch);

        this.animateMovement(ChameleonAnimations.WALK, limbSwing, limbSwingAmount, 2f, 2.5f);
        this.updateAnimation(entity.idleanimationState, ChameleonAnimations.IDLE, ageInTicks, 1f);
    }

    private void setHeadAngles(float headYaw, float headPitch) {
        headYaw = MathHelper.clamp(headYaw, -30.0F, 30.0F);
        headPitch = MathHelper.clamp(headPitch, -25.0f, 45.0F);

        this.head.yaw = headYaw * 0.017453292F;
        this.head.pitch = headPitch * 0.017453292F;
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, int colour) {
        chameleon.render(matrices, vertexConsumer, light, overlay, colour);
    }

    @Override
    public ModelPart getPart() {
        return chameleon;
    }
}
