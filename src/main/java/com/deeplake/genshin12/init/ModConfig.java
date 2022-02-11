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

        @Config.LangKey("genshin12.conf.general.burst_req_shift")
        @Config.Comment("Elemental burst can only be cast while sneaking(hold shift).")
        public boolean BURST_REQ_SHIFT = false;

        @Config.LangKey("genshin12.conf.general.can_plunge_client")
        @Config.Comment("(ClientSide) Mid air attacks will cause you to plunge down. ")
        public boolean ENABLE_PLUNGE_CLIENT = true;

        @Config.LangKey("genshin12.conf.general.can_plunge_server")
        @Config.Comment("(ServerSide) Falling long launches a plunge attack automatically. Xiao Req this to work, so best not turn off.")
        public boolean ENABLE_PLUNGE_ATTACK = true;

        @Config.LangKey("genshin12.conf.general.dmg_atk_percent_genshin_to_mc")
        @Config.Comment("100% skill damage = ? damage in Minecraft?")
        public float DMG_ATK_PERCENT_GENSHIN_TO_MC = 2f; //100% dmg
    }

    @Config.LangKey("configgui.genshin12.category.Menu0.GachaConf")
    @Config.Comment("IdlFramework general config.")
    public static final GachaConf GACHA_CONF = new GachaConf();

    public static class GachaConf {
        @Config.LangKey("genshin12.conf.gacha.allow_treasure_enchant")
        @Config.Comment("Weapon Pack can give treasure enchantments.")
        public boolean ALLOW_TREASUE_ENCHANT = false;

        @Config.LangKey("genshin12.conf.gacha.chara_chance")
        @Config.Comment("The chance of getting a character for interwined fate.")
        @Config.RangeDouble(min = 0, max = 1)
        public double CHARA_CHANCE = 0.1;

        @Config.LangKey("genshin12.conf.gacha.primo_per_chest")
        @Config.Comment("How many primo you get when you loot a chest.")
        @Config.RangeInt(min = 0)
        public int PRIMO_PER_CHEST = 1;

        @Config.LangKey("genshin12.conf.gacha.primo_per_advancement")
        @Config.Comment("How many primo you get when you get a lesser advancement.")
        @Config.RangeInt(min = 0)
        public int PRIMO_PER_ADVANCEMENT = 1;

        @Config.LangKey("genshin12.conf.gacha.primo_per_challenge")
        @Config.Comment("How many primo you get when you loot a challenge advancement.")
        @Config.RangeInt(min = 0)
        public int PRIMO_PER_CHALLENGE = 5;
    }

    @Config.LangKey("configgui.genshin12.category.Menu0.WorldGenConf")
    @Config.Comment("IdlFramework general config.")
    public static final WorldGenConf WorldGenConf = new WorldGenConf();

    public static class WorldGenConf {
        @Config.LangKey("genshin12.conf.worldgen.cor_lapis_count")
        @Config.Comment("Min count of Cor Lapis generation per chunk.")
        @Config.RangeInt(min = 0)
        @Config.RequiresMcRestart
        public int COR_LAPIS = 2;

        @Config.LangKey("genshin12.conf.worldgen.cor_lapis_count_delta")
        @Config.Comment("Max extra count of Cor Lapis generation per chunk.")
        @Config.RangeInt(min = 0)
        @Config.RequiresMcRestart
        public int COR_LAPIS_DELTA = 3;
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

        public float METEOR_LIFE = 2f;
        public float METEOR_SIZE = 9f;
        public float METEOR_HEIGHT = 9f;
        public float METEOR_OMEGA = 5f;

        public float KAEYA_OMEGA = 0.3f;//rad / tick

        public float XIAO_DASH_SPEED = 1f;// m/tick
        public int XIAO_DASH_DURA = 10;//tick
        public double XIAO_JUMP_FACTOR = Math.sqrt(6);//jump speed, meter per tick

        public float PLUNGE_MIN_HEIGHT = 1.5f;//m
        public float PLUNGE_MAX_HEIGHT = 2.4f;//m

        public float PLUNGE_MIN_DAMAGE_FACTOR = 1.3f;//100%atk
        public float PLUNGE_MAX_DAMAGE_FACTOR = 3.2f;//100%atk

        public float PLUNGE_SPEED = 3;

        @Config.LangKey("genshin12.conf.worldgen.enable_xiao_jump_boost")
        @Config.Comment("(Client side)Xiao's jump height alter may confict with other jump-adjusting modes. If you are not playing xiao and have compatibility issues, turn this off client side.")
        public boolean ENABLE_XIAO_JUMP_BOOST = true;
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

    @Config.LangKey("configgui.genshin12.category.Menu0.ElemConf")
    @Config.Comment("Elemental")
    public static final ElemConf ELEMCONF = new ElemConf();

    public static class ElemConf {
        public double R_STRONG_MELT = 2.5;
        public double R_STRONG_VAPORIZE = 2.5;
        public double R_WEAK_MELT = 0.625;
        public double R_WEAK_VAPORIZE = 0.625;
        public double R_OVERLOAD = 1.25;
        public double R_SUPERCONDUCT = 1.25;
        public double R_CRYTALLIZE = 0.625;
        public double R_SWIRL = 0.625;

        public double R_SHOCK = 0.625;

        public double GAUGE_PER_SHOCK = 0.4;

        public double AURA_TAX = 0.2;//20%will be removed

    }
}
