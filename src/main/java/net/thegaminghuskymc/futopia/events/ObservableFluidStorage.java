package net.thegaminghuskymc.futopia.events;

import java.util.ArrayList;

import javax.annotation.Nonnull;

import net.minecraftforge.fluids.FluidTank;

public class ObservableFluidStorage extends FluidTank {
	private ArrayList<Runnable> listeners = new ArrayList<>();

	public ObservableFluidStorage(int capacity) {
		super(capacity);
		this.setCanFill(true);
		this.setCanDrain(true);
	}
	
	private void markDirty() {
		for(Runnable r : listeners) {
			r.run();
		}
	}
	/*
	@Override
	public int fill(FluidStack resource, boolean doFill) {
		if (doFill) System.out.println("FILL "+resource);
		return super.fill(resource, doFill);
	}
	
	@Override
	@Nullable
	public FluidStack drain(FluidStack resource, boolean doDrain) {
		if (doDrain) System.out.println("DRAIN "+resource);
		return super.drain(resource, doDrain);
	}*/
	
	public void listen(@Nonnull Runnable r) {
		listeners.add(r);
	}
	
	protected void onContentsChanged() {
		markDirty();
	}
}
