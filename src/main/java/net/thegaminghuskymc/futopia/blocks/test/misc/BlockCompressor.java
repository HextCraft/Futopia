package net.thegaminghuskymc.futopia.blocks.test.misc;

import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.registries.GameData;
import net.thegaminghuskymc.futopia.client.render.CompressorRenderer;
import net.thegaminghuskymc.futopia.init.FTCreativeTabs;
import net.thegaminghuskymc.futopia.tiles.TileCompressor;
import net.thegaminghuskymc.futopia.utils.BlockNames;

public class BlockCompressor extends net.minecraft.block.Block implements ITileEntityProvider {

    public BlockCompressor() {
        super(Material.IRON);
        setUnlocalizedName(BlockNames.compressor);
        setRegistryName(BlockNames.compressor);
        GameData.register_impl(this);
        GameData.register_impl(new ItemBlock(this).setRegistryName(getUnlocalizedName()));
        GameRegistry.registerTileEntity(TileCompressor.class, "compressor");
        setCreativeTab(FTCreativeTabs.machines);
    }

    private TileCompressor getTE(World world, BlockPos pos) {
        return (TileCompressor) world.getTileEntity(pos);
    }

    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player,
    		EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        if (!world.isRemote) {
            TileCompressor te = getTE(world, pos);
            if (te.getStack() == null) {
                //if (player.getHeldItem(hand) != null && player.getHeldItem(hand).getItem() instanceof ItemOreIngot || player.getHeldItem(hand).getItem() instanceof ItemAlloyIngot) {
                if (player.getHeldItem(hand).isEmpty()) {
                    // If block is empty and the player is holding an ingot. We move that item into the

                    //Inn
                    ItemStack stack = player.getHeldItem(hand).copy();
                    int stackSize  = stack.getMaxStackSize();

                    if (player.getHeldItem(hand).getMaxStackSize() > 9) {
                        stack.setCount(9);
                        te.setStack(stack);

                        ItemStack returnStack = player.getHeldItem(hand).copy();
                        returnStack.setCount(9);
                        player.inventory.setInventorySlotContents(player.inventory.currentItem, returnStack);
                    } else {
                        stack.setCount(stackSize);
                        te.setStack(stack);

                        ItemStack returnStack = player.getHeldItem(hand).copy();
                        returnStack.setCount(stackSize);
                        player.inventory.setInventorySlotContents(player.inventory.currentItem, returnStack);

                    }
                    // Make sure the client knows about the changes in the player inventory
                    player.openContainer.detectAndSendChanges();
                }
            } else {
                ItemStack stack = te.getStack();

                te.setStack(null);
                if (!player.inventory.addItemStackToInventory(stack)) {
                    // Not possible. Throw item in the world
                    EntityItem entityItem = new EntityItem(world, pos.getX(), pos.getY()+1, pos.getZ(), stack);
                    world.spawnEntity(entityItem);
                } else {
                    player.openContainer.detectAndSendChanges();
                }
            }
        }
        // Return true also on the client to make sure that MC knows we handled this and will not try to place
        // a block on the client
        return true;
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
    
    @Override
    public boolean isFullCube(IBlockState state) {
    	return false;
    }

    @SideOnly(Side.CLIENT)
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), 0, new ModelResourceLocation(getRegistryName(), "inventory"));
        ClientRegistry.bindTileEntitySpecialRenderer(TileCompressor.class, new CompressorRenderer());
    }

    @Override
    public TileEntity createNewTileEntity(World world, int meta) {
        return new TileCompressor();
    }
    
}