package net.thegaminghuskymc.futopia.blocks.computer;

import net.minecraft.block.material.Material;
import net.minecraft.world.World;
import net.thegaminghuskymc.futopia.blocks.BlockContainerBase;
import net.thegaminghuskymc.futopia.tiles.TileCPU;
import net.thegaminghuskymc.futopia.utils.BlockNames;

public class BlockCPU extends BlockContainerBase {

    public BlockCPU() {
        super(Material.IRON, BlockNames.BLOCKCPU_NAME);
    }

    @Override
    public TileCPU createNewTileEntity(World world, int meta) {
        return new TileCPU();
    }

}
