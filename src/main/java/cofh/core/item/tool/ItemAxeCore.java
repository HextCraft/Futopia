package cofh.core.item.tool;

import java.util.Set;

import com.google.common.collect.Sets;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;

public class ItemAxeCore extends ItemToolCore {
	
	private static final Set<Block> EFFECTIVE_ON = Sets.newHashSet(Blocks.PLANKS, Blocks.BOOKSHELF, Blocks.LOG, Blocks.LOG2, Blocks.CHEST, Blocks.PUMPKIN, Blocks.LIT_PUMPKIN, Blocks.MELON_BLOCK, Blocks.LADDER, Blocks.WOODEN_BUTTON, Blocks.WOODEN_PRESSURE_PLATE);

	public ItemAxeCore(ToolMaterial toolMaterial) {

		this(-3.2F, toolMaterial);
	}

	public ItemAxeCore(float attackSpeed, ToolMaterial toolMaterial) {

		super(3.0F, attackSpeed, toolMaterial);
		addToolClass("axe");

		effectiveBlocks.addAll(EFFECTIVE_ON);

		effectiveMaterials.add(Material.WOOD);
		effectiveMaterials.add(Material.PLANTS);
		effectiveMaterials.add(Material.VINE);
		effectiveMaterials.add(Material.CACTUS);
		effectiveMaterials.add(Material.GOURD);

		damageVsEntity = damageVsEntity + 1;
	}

}
