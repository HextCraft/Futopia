package net.thegaminghuskymc.futopia.client.gui.machines;

import net.thegaminghuskymc.futopia.client.container.machines.ContainerParticleEmitter;
import net.thegaminghuskymc.huskylib.client.gui.GuiContainerBase;

public class GuiParticleEmitter extends GuiContainerBase {

	public GuiParticleEmitter() {
		super(new ContainerParticleEmitter());
	}

	@Override
	public void updateScreen() {
		super.updateScreen();
	}

	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		this.drawDefaultBackground();
		this.renderHoveredToolTip(mouseX, mouseY);
		super.drawScreen(mouseX, mouseY, partialTicks);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {

	}

	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {

	}

}
