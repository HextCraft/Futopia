package net.thegaminghuskymc.futopia.events;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.function.Supplier;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import org.apache.commons.lang3.Validate;

import net.minecraftforge.common.capabilities.Capability;

/**
 * Provides capabilities on behalf of a block.
 */

public class CapabilityProvider {
	private ArrayList<Entry<?>> entries = new ArrayList<>();
	
	public boolean canProvide (@Nullable RelativeDirection side, @Nonnull Capability<?> capability) {
		Validate.notNull(capability);
		
		for(Entry<?> entry : entries) {
			if (side!=null) {
				if (entry.directions.contains(side) && capability.equals(entry.capability)) return true;
			} else {
				if (capability.equals(entry.capability)) return true;
			}
		}
		
		return false;
	}
	
	@SuppressWarnings("unchecked")
	@Nullable
	public <T> T provide(@Nonnull RelativeDirection side, @Nonnull Capability<T> capability) {
		Validate.notNull(capability);
		
		for(Entry<?> entry : entries) {
			//if (side!=null) {
				if (entry.directions.contains(side) && capability.equals(entry.capability)) return (T)entry.provide();
			//} else {
			//	if (capability.equals(entry.capability)) return (T)entry.provide();
			//}
		}
		
		return null;
	}
	
	public <T> void registerForAllSides(Capability<T> cap, Supplier<T> provider) {
		entries.add(new Entry<T>(cap,provider));
	}
	
	public <T> void registerForAllSides(Capability<T> cap, Supplier<T> side, Supplier<T> within) {
		entries.add(new Entry<T>(cap, within, RelativeDirection.WITHIN));
		entries.add(new Entry<T>(cap, side,   RelativeDirection.ALL_SIDES));
	}
	
	public <T> void registerForSides(Capability<T> cap, Supplier<T> provider, RelativeDirection... sides) {
		entries.add(new Entry<T>(cap, provider, sides));
	}
	
	public static class Entry<T> {
		private Capability<T> capability;
		private Supplier<T> supplier;
		private T provided;
		private EnumSet<RelativeDirection> directions;
		
		public Entry(Capability<T> cap, Supplier<T> supplier, RelativeDirection... directions) {
			this.capability = cap;
			this.supplier = supplier;
			this.directions = EnumSet.noneOf(RelativeDirection.class);
			for(RelativeDirection d : directions) this.directions.add(d);
		}
		
		public Entry(Capability<T> cap, Supplier<T> supplier) {
			this.capability = cap;
			this.supplier = supplier;
			this.directions = EnumSet.allOf(RelativeDirection.class);
		}
		
		public T provide() {
			if (provided==null) {
				provided = supplier.get();
				
			}
			
			return provided;
		}
	}
}
