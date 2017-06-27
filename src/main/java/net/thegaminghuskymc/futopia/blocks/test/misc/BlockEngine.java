package net.thegaminghuskymc.futopia.blocks.test.misc;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.registries.GameData;
import net.thegaminghuskymc.futopia.init.FTCreativeTabs;
import net.thegaminghuskymc.futopia.utils.BlockNames;

public class BlockEngine extends Block implements ITileEntityProvider {

    public BlockEngine() {
        super(Material.IRON);
        setUnlocalizedName(BlockNames.engine);
        setRegistryName(BlockNames.engine);
        GameData.register_impl(this);
        GameData.register_impl(new ItemBlock(this).setRegistryName(getUnlocalizedName()));
        setCreativeTab(FTCreativeTabs.main);
    }

    @Override
    public boolean isFlammable(IBlockAccess world, BlockPos pos, EnumFacing face) {
        return true;
    }

    @Override
    public void randomDisplayTick(IBlockState state, World world, BlockPos pos, Random rand) {
        if(world.isBlockPowered(pos)) {
            world.setBlockState(pos.down(), Blocks.FIRE.getDefaultState());
//            Minecraft.getMinecraft().effectRenderer.addEffect(new RocketParticle(world, pos.getX() - 0.5, pos.getY() - 1, pos.getZ() - 0.5, 0.0, 0.0, 0.0));
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public boolean shouldSideBeRendered(IBlockState blockState, IBlockAccess blockAccess, BlockPos pos, EnumFacing side) {
        return false;
    }

    @Override
    public boolean isBlockNormalCube(IBlockState blockState) {
        return false;
    }

    @Override
    public boolean isOpaqueCube(IBlockState blockState) {
        return false;
    }

    @SideOnly(Side.CLIENT)
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }

    @Override
    public TileEntity createNewTileEntity(World world, int meta) {
        return null;
    }
}
