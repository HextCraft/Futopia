package net.thegaminghuskymc.futopia.init;

import codechicken.lib.packet.ICustomPacketHandler;
import codechicken.lib.packet.PacketCustom;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.play.INetHandlerPlayClient;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.thegaminghuskymc.futopia.tiles.TileEntityReliquia;

public class ReliquiaCPH implements ICustomPacketHandler.IClientPacketHandler {

	@Override
	public void handlePacket(PacketCustom packet, Minecraft minecraft, INetHandlerPlayClient handler) {
		switch (packet.getType()) {
		case 1:
			this.handleTilePacket(packet, minecraft.world);
			break;
		}
	}

	private void handleTilePacket(PacketCustom packet, WorldClient world) {
		final BlockPos pos = packet.readPos();
		final NBTTagCompound tag = packet.readNBTTagCompound();
		final boolean renderUpdate = packet.readBoolean();
		TileEntity tile = world.getTileEntity(pos);

		if (tile != null && tile instanceof TileEntityReliquia) {
			TileEntityReliquia tileReliquia = (TileEntityReliquia) tile;
			tileReliquia.readFromNBT(tag);
			tileReliquia.markDirty();

			if (renderUpdate) {
				world.markBlockRangeForRenderUpdate(pos, pos);
			}
		}
	}

}