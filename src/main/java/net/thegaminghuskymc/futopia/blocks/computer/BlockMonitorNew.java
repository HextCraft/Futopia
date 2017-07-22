package net.thegaminghuskymc.futopia.blocks.computer;

import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.NonNullList;
import net.thegaminghuskymc.futopia.Refs;
import net.thegaminghuskymc.futopia.init.FTCreativeTabs;
import net.thegaminghuskymc.huskylib.blocks.BlockBase;
import net.thegaminghuskymc.huskylib.blocks.EnumBlock.IEnumMeta;

public class BlockMonitorNew extends BlockBase {
	
	public static final PropertyEnum<MonitorColors> COLORS = PropertyEnum.create("color", MonitorColors.class);
	
	public BlockMonitorNew() {
		super(Refs.MODID, "monitor", FTCreativeTabs.computer_parts, MonitorColors.toStringArray());
		setDefaultState(this.getDefaultState().withProperty(COLORS, MonitorColors.BLACK));
	}
	
	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, COLORS);
	}
	
	@Override
	public int getMetaFromState(IBlockState state) {
		return state.getValue(COLORS).getMeta();
	}
	
	@Override
	public IBlockState getStateFromMeta(int meta) {
		return this.getDefaultState().withProperty(COLORS, MonitorColors.byMetadata(meta));
	}
	
	@Override
	public void getSubBlocks(CreativeTabs tab, NonNullList<ItemStack> list) {

		for (int i = 0; i < MonitorColors.METADATA_LOOKUP.length; i++) {
			list.add(new ItemStack(this, 1, i));
		}
	}
	
	public enum MonitorColors implements IStringSerializable, IEnumMeta {
		
		BLACK(0, "black"), 
		WHITE(1, "white");
		
		private int ID;
		private String name;
		
		private static final MonitorColors[] METADATA_LOOKUP = new MonitorColors[values().length];
		
		private static final MonitorColors[] VALUES = new MonitorColors[]{
			
				BLACK,
				WHITE
				
		};

		static {
			for (MonitorColors type : values()) {
				METADATA_LOOKUP[type.getMeta()] = type;
			}
		}
		
		MonitorColors(int ID, String name) {
			this.ID = ID;
			this.name = name;
		}
		
		public static String[] toStringArray() {
			String[] array = new String[VALUES.length];

			for (int i = 0; i < array.length; i++) {
				array[i] = VALUES[i].name;
			}

			return array;
		}
		
		public static MonitorColors byMetadata(int metadata) {

			if (metadata < 0 || metadata >= METADATA_LOOKUP.length) {
				metadata = 0;
			}
			return METADATA_LOOKUP[metadata];
		}

		@Override
		public int getMeta() {
			return this.ID;
		}

		@Override
		public String getName() {
			return this.name;
		}
		
	}

}
