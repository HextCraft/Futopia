package net.thegaminghuskymc.huskylib.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.thegaminghuskymc.futopia.Refs;
import net.thegaminghuskymc.huskylib.items.blocks.ItemBlockBase;
import net.thegaminghuskymc.huskylib.utils.BlockAccessUtils;

public class BlockSubBase extends Block {
	
	public static final PropertyInteger META_DATA = PropertyInteger.create("meta", 0, 15);
	private String blockName;
    private String[] subNames = null;

	public BlockSubBase(String name, Material material, CreativeTabs creativetab) {
		super(material);
		this.blockName = name;
		this.subNames = null;
		this.setDefaultState(this.blockState.getBaseState().withProperty(META_DATA, 0));
		this.setRegistryName(Refs.MODID, this.getBlockName());
        this.setUnlocalizedName(Refs.MODID + "." + this.getBlockName());
	}
	
	public BlockSubBase(String name, Material material, CreativeTabs creativeTab, String... subNames) {
		super(material);
		this.blockName = name;
		this.subNames = subNames;
		setCreativeTab(creativeTab);
		setSoundType(getSoundType(material));
		this.setDefaultState(this.blockState.getBaseState().withProperty(META_DATA, 0));
		this.setRegistryName(Refs.MODID, this.getBlockName());
        this.setUnlocalizedName(Refs.MODID + "." + this.getBlockName());
	}
	
	@Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, new IProperty[]{META_DATA});
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        return state.getValue(META_DATA);
    }

    @Override
    public IBlockState getStateFromMeta(int meta) {
        return this.getDefaultState().withProperty(META_DATA, meta);
    }
    
    @Override
    public int damageDropped(IBlockState state) {
        return this.subNames != null ? BlockAccessUtils.getBlockMetadata(state) : super.damageDropped(state);
    }

    @Override
    public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World world, BlockPos pos, EntityPlayer player) {
        if(this.subNames != null){
            return new ItemStack(this, 1, BlockAccessUtils.getBlockMetadata(world, pos));
        }
        else{
            return new ItemStack(this, 1, 0);
        }
    }
	
	@Override
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(CreativeTabs tab, NonNullList<ItemStack> list) {
        if(this.subNames != null){
            for(int i = 0; i < this.subNames.length; i++){
                list.add(new ItemStack(this, 1, i));
            }
        }
        else{
            list.add(new ItemStack(this, 1, 0));
        }
    }
	
	private SoundType getSoundType(Material material){
        if(material == Material.ANVIL){
            return SoundType.ANVIL;
        }
        else if(material == Material.CARPET || material == Material.CLOTH || material == Material.CAKE) {
            return SoundType.CLOTH;
        }
        else if(material == Material.GLASS || material == Material.ICE) {
            return SoundType.GLASS;
        }
        else if(material == Material.GRASS || material == Material.TNT || material == Material.PLANTS || material == Material.VINE) {
            return SoundType.PLANT;
        }
        else if(material == Material.GROUND) {
            return SoundType.GROUND;
        }
        else if(material == Material.IRON) {
            return SoundType.METAL;
        }
        else if(material == Material.SAND) {
            return SoundType.SAND;
        }
        else if(material == Material.SNOW) {
            return SoundType.SNOW;
        }
        else if(material == Material.ROCK) {
            return SoundType.STONE;
        }
        else if(material == Material.WOOD || material == Material.CACTUS) {
            return SoundType.WOOD;
        }
        else{
            return SoundType.STONE;
        }
    }
	
	@SideOnly(Side.CLIENT)
	public void registerItemModels(Item item)
	{
		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(this.getRegistryName(), "inventory"));
	}

	public Item createItemBlock()
	{
		return new ItemBlock(this).setRegistryName(this.getRegistryName());
	}
	
	public String getBlockName(){
        return this.blockName;
    }

    public String[] getSubNames(){
        return this.subNames;
    }
    
    public ItemBlock getItemBlock(){
    	return new ItemBlockBase(this);
    }

}
