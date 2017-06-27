package net.thegaminghuskymc.futopia.blocks.machine;

import java.util.List;

import cofh.lib.util.helpers.StringHelper;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.thegaminghuskymc.futopia.blocks.BlockMachineBase;
import net.thegaminghuskymc.futopia.utils.BlockNames;
import net.thegaminghuskymc.futopia.utils.Names;

public class BlockFoodFactory extends BlockMachineBase {

    @SideOnly(Side.CLIENT)
    private TextureAtlasSprite[] texture;

    public BlockFoodFactory() {
        super(BlockNames.FOOD_FACTORY);
    }

    @Override
    public void addInformation(ItemStack stack, World player, List<String> tooltip, ITooltipFlag advanced) {
        if (!StringHelper.isShiftKeyDown()) {
            tooltip.add("Hold" + StringHelper.getDeactivationText(" Shift ") + StringHelper.getFlavorText("for information."));
        } else {
            tooltip.add(Names.CraftingToolTips.FOOD_FACTORY);
        }
    }

}
