package net.thegaminghuskymc.futopia.utils;

public class RandomThings {

	// Blocks
	public enum ModBlocks {

		BASALT("basalt"), 
		BASALT_COBBLE("basalt_cobble"), 
		BASALT_PAVER("basalt_paver"), 
		BASALT_BRICK("basalt_brick"), 
		BASALT_FANCY("basalt_fancy"), 
		BASALT_CRACKED_LAVA("basalt_cracked_lava"), 
		BASALT_BRICK_CRACKED("basalt_brick_cracked"), 
		BASALT_BRICK_SMALL("basalt_brick_small"), 
		BASALT_TILE("basalt_tile"),

		METEOR("meteor"), 
		METEOR_BRICK("meteor_brick"), 
		METEOR_PILLAR("meteor_pillar"),

		MARBLE("marble"), 
		MARBLE_PAVER("marble_paver"), 
		MARBLE_BRICK("marble_brick"), 
		MARBLE_FANCY("marble_fancy"), 
		MARBLE_BRICK_SMALL("marble_brick_small"), 
		MARBLE_TILE("marble_tile"), 
		MARBLE_PILLAR("marble_pillar"),

		LIMESTONE("limestone"), 
		LIMESTONE_PAVER("limestone_paver"), 
		LIMESTONE_BRICK("limestone_brick"), 
		LIMESTONE_FANCY("limestone_fancy"), 
		LIMESTONE_BRICK_SMALL("limestone_brick_small"), 
		LIMESTONE_PILLAR("limestone_pillar"),

		CONCRETE("concrete"), 
		CONCRETE_ARRANGED_BRICKS("concrete_arranged_bricks"), 
		CONCRETE_BRICKS("concrete_bricks"), 
		CONCRETE_BRICKS_DARK("concrete_bricks_dark"), 
		CONCRETE_FANCY_BLOCKS("concrete_fancy_blocks"), 
		CONCRETE_OLD_SQUARES("concrete_old_squares"), 
		CONCRETE_ROCKS("concrete_rocks"),
		CONCRETE_SMALL_BRICKS("concrete_small_bricks");

		private String unlocalizedName;

		ModBlocks(String unlocalizedName) {
			this.unlocalizedName = unlocalizedName;
		}

		public String getUnlocalizedName() {
			return unlocalizedName;
		}

	}

}
