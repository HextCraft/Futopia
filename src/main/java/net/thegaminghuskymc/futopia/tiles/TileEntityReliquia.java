package net.thegaminghuskymc.futopia.tiles;

import codechicken.lib.packet.PacketCustom;
import keri.ninetaillib.lib.tile.TileEntityBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.math.BlockPos;
import net.thegaminghuskymc.futopia.Futopia;

public class TileEntityReliquia extends TileEntityBase {

	public void sendUpdatePacket(BlockPos pos, boolean renderUpdate) {
		PacketCustom packet = new PacketCustom(Futopia.INSTANCE, 1);
		packet.writePos(this.pos);
		packet.writeNBTTagCompound(this.writeToNBT(new NBTTagCompound()));
		packet.writeBoolean(renderUpdate);
		packet.sendToClients();
	}

}