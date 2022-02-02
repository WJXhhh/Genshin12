package com.deeplake.genshin12.init;

import com.deeplake.genshin12.util.Reference;
import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import static com.deeplake.genshin12.util.CommonDef.TICK_PER_SECOND;


@Config(modid = Reference.MOD_ID, category = "")
public class ModConfig {
    @Mod.EventBusSubscriber(modid = Reference.MOD_ID)
    private static class EventHandler {

        private EventHandler() {
        }

        @SubscribeEvent
        public static void onConfigChanged(final ConfigChangedEvent.OnConfigChangedEvent event) {
            if (event.getModID().equals(Reference.MOD_ID)) {
                ConfigManager.sync(Reference.MOD_ID, Config.Type.INSTANCE);
            }
        }
    }

    @Config.LangKey("configgui.genshin12.category.Menu0.GeneralConf")
    @Config.Comment("IdlFramework general config.")
    public static final GeneralConf GeneralConf = new GeneralConf();

    public static class GeneralConf {
        @Config.LangKey("genshin12.conf.general.movie_mode")
        @Config.Comment("Movie Mode, greatly increases all kinds of effects to record videos.")
        public boolean MOVIE_MODE = false;
    }

    @Config.LangKey("configgui.genshin12.category.Menu0.GachaConf")
    @Config.Comment("IdlFramework general config.")
    public static final GachaConf GACHA_CONF = new GachaConf();

    public static class GachaConf {
        @Config.LangKey("genshin12.conf.general.allow_treasure_enchant")
        @Config.Comment("Twisted fate can produce treasure enchantments.")
        public boolean ALLOW_TREASUE_ENCHANT = false;

        @Config.LangKey("genshin12.conf.general.chara_chance")
        @Config.Comment("The chance of getting a character for interwined fate")
        @Config.RangeDouble(min = 0, max = 1)
        public double CHARA_CHANCE = 0.1;

        public int PRIMO_PER_CHEST = 1;

        public int PRIMO_PER_ADVANCEMENT = 1;
        public int PRIMO_PER_CHALLENGE = 5;
    }

    @Config.LangKey("configgui.genshin12.category.Menu0.DebugConf")
    @Config.Comment("Config for developers")
    public static final DebugConf DEBUG_CONF = new DebugConf();

    public static class DebugConf {

        public boolean TEST_1 = false;

        public int PARTICLE_COUNT = 40;
        public float PARTICLE_SPEED = 1f/TICK_PER_SECOND;
        public float PILLAR_LIFE = 30f;

        public boolean DEBUG_MODE = false;

        public float DMG_GENSHIN_TO_MC = 1f;
        public float DMG_ATK_PERCENT_GENSHIN_TO_MC = 2f; //100% dmg

//        public float PERTIFY_R = 0.313f;
//        public float PERTIFY_G = 0.313f;
//        public float PERTIFY_B = 0.2f;

        public float METEOR_LIFE = 2f;
        public float METEOR_SIZE = 9f;
        public float METEOR_HEIGHT = 9f;
        public float METEOR_OMEGA = 5f;

    }

    @Config.LangKey("configgui.genshin12.category.Menu0.SpawnConf")
    @Config.Comment("Spawning")
    public static final SpawnConf SPAWN_CONF = new SpawnConf();

    public static class SpawnConf {
        @Config.LangKey("conf.spawn.enabled")
        @Config.Comment("Spawn mod creatures")
        @Config.RequiresMcRestart
        public boolean SPAWN = true;

//        @Config.LangKey("entity.moroon_tainter.name")
//        @Config.Comment("Spawn Moroon Tainter")
//        @Config.RequiresMcRestart
//        public int SPAWN_TAINTER = 100;
    }
}
