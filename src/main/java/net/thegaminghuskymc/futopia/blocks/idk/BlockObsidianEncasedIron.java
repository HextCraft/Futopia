package net.thegaminghuskymc.futopia.blocks.idk;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;
import net.thegaminghuskymc.futopia.init.FTCreativeTabs;

import java.util.List;

public class BlockObsidianEncasedIron extends Block {
    public BlockObsidianEncasedIron() {
        super(Material.ROCK);
        setUnlocalizedName("obsidian_encased_iron");
        setRegistryName("obsidian_encased_iron");
        this.setCreativeTab(FTCreativeTabs.main);
        this.setResistance(2000.0F);
        this.setHardness(50.0F);
        this.setSoundType(SoundType.STONE);
    }

    @Override
    public void addInformation(ItemStack stack, World player, List<String> tooltip, ITooltipFlag advanced) {
        tooltip.add("This block is explosion resistant.");
    }	

    @Override
    public boolean canDropFromExplosion(Explosion explosionIn) {
        return false;
    }
}
