/*******************************************************************************
 * HellFirePvP / Astral Sorcery 2017
 *
 * This project is licensed under GNU GENERAL PUBLIC LICENSE Version 3.
 * The source code is available on github: https://github.com/HellFirePvP/AstralSorcery
 * For further details, see the License file there.
 ******************************************************************************/

package net.thegaminghuskymc.futopia.blocks.private_blocks;

import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

import javax.annotation.Nullable;

/**
 * This class is part of the Astral Sorcery Mod
 * The complete source code for this mod can be found on github.
 * Class: BlockDynamicColor
 * Created by HellFirePvP
 * Date: 05.12.2016 / 07:46
 */
public interface BlockDynamicColor {

    //Return -1 for no color multiplication
    int getColorMultiplier(IBlockState state, @Nullable IBlockAccess access, @Nullable BlockPos pos, int renderPass);

}
