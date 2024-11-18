package io.github.acidicts.block.entity;

import io.github.acidicts.WorkshopMod;
import io.github.acidicts.init.BlockEntityTypeInit;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtElement;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;

public class ExampleBlockEntity extends BlockEntity {
    private int counter;

    public ExampleBlockEntity(BlockPos pos, BlockState state) {
        super(BlockEntityTypeInit.EXAMPLE_BLOCK_ENTITY, pos, state);
    }

    public int getCounter() {
        return this.counter;
    }

    public void incrementCounter() {
        this.counter++;
        this.markDirty();

        if(this.counter % 10 == 0 && this.world instanceof ServerWorld serverWorld) {
            EntityType.PIG.spawn(serverWorld, this.pos.up(), SpawnReason.TRIGGERED);
        }
    }

    @Override
    protected void writeNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
        var modIdData = new NbtCompound();
        modIdData.putInt("counter", this.counter);
        nbt.put(WorkshopMod.MOD_ID, modIdData);
    }

    @Override
    protected void readNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
        if(nbt.contains(WorkshopMod.MOD_ID, NbtElement.COMPOUND_TYPE)) {
            var modIdData = nbt.getCompound(WorkshopMod.MOD_ID);
            this.counter = modIdData.contains("counter", NbtElement.INT_TYPE) ? modIdData.getInt("counter") : 0;
        }
    }
}
