package net.thegaminghuskymc.futopia.blocks;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;
import net.thegaminghuskymc.futopia.tiles.TileMultiBlock;

public class BlockMultiBlock extends BlockContainer {
	
    public BlockMultiBlock(Material material) {
        super(material);
    }

    @Override
    public void onNeighborChange(IBlockAccess world, BlockPos pos, BlockPos neighbor) {
    	World mcWorld = Minecraft.getMinecraft().world;
        TileEntity tile = world.getTileEntity(pos);
        if (tile != null && tile instanceof TileMultiBlock) {
            TileMultiBlock multiBlock = (TileMultiBlock) tile;
            if (multiBlock.hasMaster()) {
                if (multiBlock.isMaster()) {
                    if (!multiBlock.checkMultiBlockForm())
                        multiBlock.resetStructure();
                } else {
                    if (!multiBlock.checkForMaster()) {
                        multiBlock.reset();
                        mcWorld.markAndNotifyBlock(pos, new Chunk(mcWorld, pos.getX(), pos.getZ()), this.getDefaultState(), this.getDefaultState(), 1);
                    }
                }
            }
        }
        super.onNeighborChange(world, pos, neighbor);;
    }

    @Override
    public TileEntity createNewTileEntity(World world, int meta) {
        return new TileMultiBlock();
    }
}