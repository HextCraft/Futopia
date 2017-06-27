package net.thegaminghuskymc.futopia.utils;

public class RandomThings {

    //Blocks
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
        LIMESTONE_DIRTY("limestone_dirty"),
        LIMESTONE_PILLAR("limestone_pillar"),

        CONCRETE("concrete"),
        CONCRETE_ARRANGED_BRICKS("concrete_arranged_bricks"),
        CONCRETE_BRICKS("concrete_bricks"),
        CONCRETE_BRICKS_DARK("concrete_bricks_dark"),
        CONCRETE_FANCY_BLOCKS("concrete_fancy_blocks"),
        CONCRETE_OLD_SQUARES("concrete_old_squares"),
        CONCRETE_ROCKS("concrete_rocks"),
        CONCRETE_SMALL_BRICKS("concrete_small_bricks"),
        CONCRETE_SMALL_TEXTURED_SQUARES("concrete_small_textured_squares"),
        CONCRETE_SQUARES("concrete_squares"),
        CONCRETE_TEXTURED_BLOCKS("concrete_textured_blocks"),

        STONE_ARRANGED_BRICKS("stone_arranged_bricks"),
        STONE_BLOCKS("stone_blocks"),
        STONE_BLOCKS_DARK("stone_blocks_dark"),
        STONE_CRACKED("stone_cracked"),

        CLEAR_GLASS_NORMAL("clear_glass_normal"),
        CLEAR_GLASS_BLACK("clear_glass_black"),
        CLEAR_GLASS_BLUE("clear_glass_blue"),
        CLEAR_GLASS_BROWN("clear_glass_brown"),
        CLEAR_GLASS_CYAN("clear_glass_cyan"),
        CLEAR_GLASS_GRAY("clear_glass_gray"),
        CLEAR_GLASS_GREEN("clear_glass_green"),
        CLEAR_GLASS_LIGHT_BLUE("clear_glass_light_blue"),
        CLEAR_GLASS_LIME("clear_glass_lime"),
        CLEAR_GLASS_MAGENTA("clear_glass_magenta"),
        CLEAR_GLASS_ORANGE("clear_glass_orange"),
        CLEAR_GLASS_PINK("clear_glass_pink"),
        CLEAR_GLASS_PURPLE("clear_glass_purple"),
        CLEAR_GLASS_RED("clear_glass_red"),
        CLEAR_GLASS_SILVER("clear_glass_silver"),
        CLEAR_GLASS_YELLOW("clear_glass_yellow"),

        DIRTY_GLASS_NORMAL("dirty_glass_normal"),
        DIRTY_GLASS_BLACK("dirty_glass_black"),
        DIRTY_GLASS_BLUE("dirty_glass_blue"),
        DIRTY_GLASS_BROWN("dirty_glass_brown"),
        DIRTY_GLASS_CYAN("dirty_glass_cyan"),
        DIRTY_GLASS_GRAY("dirty_glass_gray"),
        DIRTY_GLASS_GREEN("dirty_glass_green"),
        DIRTY_GLASS_LIGHT_BLUE("dirty_glass_light_blue"),
        DIRTY_GLASS_LIME("dirty_glass_lime"),
        DIRTY_GLASS_MAGENTA("dirty_glass_magenta"),
        DIRTY_GLASS_ORANGE("dirty_glass_orange"),
        DIRTY_GLASS_PINK("dirty_glass_pink"),
        DIRTY_GLASS_PURPLE("dirty_glass_purple"),
        DIRTY_GLASS_RED("dirty_glass_red"),
        DIRTY_GLASS_SILVER("dirty_glass_silver"),
        DIRTY_GLASS_YELLOW("dirty_glass_yellow"),

        CRACKED_GLASS_NORMAL("cracked_glass_normal"),
        CRACKED_GLASS_BLACK("cracked_glass_black"),
        CRACKED_GLASS_BLUE("cracked_glass_blue"),
        CRACKED_GLASS_BROWN("cracked_glass_brown"),
        CRACKED_GLASS_CYAN("cracked_glass_cyan"),
        CRACKED_GLASS_GRAY("cracked_glass_gray"),
        CRACKED_GLASS_GREEN("cracked_glass_green"),
        CRACKED_GLASS_LIGHT_BLUE("cracked_glass_light_blue"),
        CRACKED_GLASS_LIME("cracked_glass_lime"),
        CRACKED_GLASS_MAGENTA("cracked_glass_magenta"),
        CRACKED_GLASS_ORANGE("cracked_glass_orange"),
        CRACKED_GLASS_PINK("cracked_glass_pink"),
        CRACKED_GLASS_PURPLE("cracked_glass_purple"),
        CRACKED_GLASS_RED("cracked_glass_red"),
        CRACKED_GLASS_SILVER("cracked_glass_silver"),
        CRACKED_GLASS_YELLOW("cracked_glass_yellow"),

        LAMP("lamp"),
        GLOWSTONE_LAMP("glowstone_lamp"),
        TINY_GLOWSTONE_LAMP("tiny_glowstone_lamp"),
        HANGING_GLOWSTONE_LAMP("hanging_glowstone_lamp"),
        REINFORCED_GLOWSTONE("reinforced_glowstone"),
        OBSIDIAN_REINFORCED_LAMP("obsidian_reinforced_lamp");


        private String unlocalizedName;

        ModBlocks(String unlocalizedName) {
            this.unlocalizedName = unlocalizedName;
        }

        public String getUnlocalizedName() {
            return unlocalizedName;
        }

    }

}
