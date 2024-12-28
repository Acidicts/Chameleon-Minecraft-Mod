package io.github.acidicts.block.entity.client;

import io.github.acidicts.WorkshopMod;
import io.github.acidicts.block.entity.custom.ChameleonEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class ChameleonRenderer extends MobEntityRenderer<ChameleonEntity, ChameleonModel<ChameleonEntity>> {

    public ChameleonRenderer(EntityRendererFactory.Context context) {
        super(context, new ChameleonModel<>(context.getPart(ChameleonModel.CHAMELEON)), 0.5f);
    }

    @Override
    public Identifier getTexture(ChameleonEntity entity) {
        return Identifier.of(WorkshopMod.MOD_ID, "textures/entity/chameleon/chameleon.png");
    }

    @Override
    public void render(ChameleonEntity livingEntity, float f, float g, MatrixStack matrixStack,
                       VertexConsumerProvider vertexConsumerProvider, int i) {

        if (livingEntity.isBaby()) {
            matrixStack.scale(0.5F, 0.5F, 0.5F);
        } else {
            matrixStack.scale(1.0F, 1.0F, 1.0F);
        }

        super.render(livingEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}