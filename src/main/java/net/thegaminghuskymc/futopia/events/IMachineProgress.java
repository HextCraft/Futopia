package net.thegaminghuskymc.futopia.events;

public interface IMachineProgress {
	/**
	 * Returns a value from [0..1) indicating how close to complete a machine operation is. 
	 */
	public float getMachineProgress();
}
