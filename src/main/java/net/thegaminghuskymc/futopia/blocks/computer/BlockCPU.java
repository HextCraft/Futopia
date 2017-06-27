package net.thegaminghuskymc.futopia.blocks.computer;

import java.util.Random;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.thegaminghuskymc.futopia.blocks.BlockContainerBase;
import net.thegaminghuskymc.futopia.tiles.TileCPU;
import net.thegaminghuskymc.futopia.utils.BlockNames;

public class BlockCPU extends BlockContainerBase {

    @SideOnly(Side.CLIENT)
    private TextureAtlasSprite[] texture;

    public BlockCPU() {
        super(Material.IRON, BlockNames.BLOCKCPU_NAME);
    }

    @Override
    public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {

        TileEntity tileEntity = worldIn.getTileEntity(pos);
        if (tileEntity instanceof TileCPU) {
        	
        }
    }

    @Override
    public int tickRate(World world) {
        return 1;
    }

    @Override
    public TileCPU createNewTileEntity(World world, int meta) {
        return new TileCPU();
    }

}
