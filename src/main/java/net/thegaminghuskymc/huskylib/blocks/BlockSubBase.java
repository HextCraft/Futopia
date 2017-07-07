package net.thegaminghuskymc.huskylib.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.thegaminghuskymc.futopia.Refs;
import net.thegaminghuskymc.futopia.network.EnumMaterialType;
import net.thegaminghuskymc.huskylib.items.blocks.ItemBlockBase;

public class BlockSubBase extends Block {
	
	public static final PropertyEnum<EnumMaterialType> META_DATA = PropertyEnum.create("type", EnumMaterialType.class);
    private String blockName;
    private String[] subNames = null;

	public BlockSubBase(String name, Material material, CreativeTabs creativetab) {
		super(material);
		this.blockName = name;
		this.subNames = null;
		setCreativeTab(creativetab);
		setRegistryName(Refs.MODID, name);
        setUnlocalizedName(Refs.MODID + "." + name);
        setDefaultState(getBlockState().getBaseState().withProperty(META_DATA, EnumMaterialType.RED));
	}
	
	public BlockSubBase(String name, Material material, CreativeTabs creativeTab, String... subNames) {
		super(material);
		this.blockName = name;
		this.subNames = subNames;
		setCreativeTab(creativeTab);
		setRegistryName(Refs.MODID, name);
        setUnlocalizedName(Refs.MODID + "." + name);
        setDefaultState(getBlockState().getBaseState().withProperty(META_DATA, EnumMaterialType.RED));
	}

	@Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, META_DATA);
    }
	
	@Override
    public IBlockState getStateFromMeta(int meta) {

        return this.getDefaultState().withProperty(META_DATA, EnumMaterialType.byMetadata(meta));
    }

    @Override
    public int getMetaFromState(IBlockState state) {

        return state.getValue(META_DATA).getMeta();
    }

    @Override
    public int damageDropped(IBlockState state) {

        return state.getValue(META_DATA).getMeta();
    }

    @Override
    public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World world, BlockPos pos, EntityPlayer player) {
        return new ItemStack(this, 1, 0);
    }
	
	@Override
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(CreativeTabs tab, NonNullList<ItemStack> list) {
		for(int i = 0; i < EnumMaterialType.toStringArray().length; i++){
            list.add(new ItemStack(this, 1, i));
        }
    }

	public Item createItemBlock() {
		return new ItemBlockBase(this).setRegistryName(this.getRegistryName());
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
