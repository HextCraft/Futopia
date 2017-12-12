/*******************************************************************************
 * HellFirePvP / Astral Sorcery 2017
 *
 * This project is licensed under GNU GENERAL PUBLIC LICENSE Version 3.
 * The source code is available on github: https://github.com/HellFirePvP/AstralSorcery
 * For further details, see the License file there.
 ******************************************************************************/

package net.thegaminghuskymc.futopia.blocks.private_blocks;

import net.minecraft.block.BlockStairs;
import net.thegaminghuskymc.futopia.blocks.worldgen.BlockMarble;
import net.thegaminghuskymc.futopia.init.FTCreativeTabs;

/**
 * This class is part of the Astral Sorcery Mod
 * The complete source code for this mod can be found on github.
 * Class: BlockMarbleStairs
 * Created by HellFirePvP
 * Date: 26.04.2017 / 10:03
 */
public class BlockMarbleStairs extends BlockStairs {

    public BlockMarbleStairs() {
        super(BlockMarble.Type.BRICKS.asBlock());
        setHardness(1.0F);
        setHarvestLevel("pickaxe", 1);
        setResistance(3.0F);
        setCreativeTab(FTCreativeTabs.main);
    }
}
