package net.thegaminghuskymc.futopia.blocks;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;
import net.thegaminghuskymc.futopia.Futopia;
import net.thegaminghuskymc.futopia.client.gui.GuiHandler;
import net.thegaminghuskymc.futopia.init.FTBlocks;
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
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
    		EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
    	
    	if(worldIn.isRemote & !playerIn.isSneaking() & this == FTBlocks.multiBlockController){
    		playerIn.openGui(Futopia.INSTANCE, GuiHandler.PROJECT_TABLE, worldIn, pos.getX(), pos.getY(), pos.getZ());
    		return true;
    	}
    	
    	return false;
    }
    
    @Override
    public EnumBlockRenderType getRenderType(IBlockState state) {
    	return EnumBlockRenderType.MODEL;
    }

    @Override
    public TileEntity createNewTileEntity(World world, int meta) {
        return new TileMultiBlock();
    }
}