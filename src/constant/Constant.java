package constant;

import java.io.File;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Trung on 10/14/2017.
 */
public class Constant {

    public static final String MODE_ALERTING = "Alerting";

    public static final String MODE_COMBAT = "Combat";

    public static final String MODE_GENERAL = "General";

    public static final String MODE_SLAVE = "SlaveMode";

    public static final String MODE_INPUT = "Inputs";

    public static final String MODE_PARTY_SELECTION = "PartySelection";

    public static final String MODE_SUMMON = "Summons";

    public static final String MODE_EVENT = "EventMode";

    public static final String MODE_TREASURE_EVENT = "TreasureEventMode";

    public static final String MODE_SOLO_COOP = "SoloCoOpMode";

    public static final String MODE_CUSTOMIZED_SCHEDULING = "CustomizedScheduling";

    public static final String MODE_DIMENSIONAL_HALO = "DimensionalHalo";

    public static final String LANGUAGE = "Language";

    public static final String ACTIVE = "Active";

    public static final String ENABLE = "Enabled";

    public static final String CHROME_DEV_TOOL = "ChromeDevToolsWindowDockedOnTheRight";

    public static final String MAX_PAGE_LOAD_BEFORE_RETRY = "MaxPageLoadDelayInMsBeforeRetry";

    public static final String MAX_TRIGGER_DELAY = "MaxTriggerDelayInMsBeforeFallback";

    public static final String MAX_RESPONSE_DELAY = "MaxResponseDelayInMs";

    public static final String MAX_NUM_ACTION_RETRIES = "MaxNumActionRetries";

    public static final String MIN_WAIT_TIME_AFTER_REFRESH = "MinWaitTimeInMsAfterRefresh";

    public static final String TIME_LIMIT = "TimeLimitInSeconds";

    public static final String USE_VIRAMATE = "UseViramate";

    public static final String MAX_NUM_POTION_TO_USE = "MaxNumPotionsToUse";

    public static final String USE_FULL_EX = "UseFullElixirsWhenNoRemainingHalfAPPotions";

    public static final String USE_FULL_EX_FIRST = "UseFullElixirsFirst";

    public static final String COUNTDOWN_HORIZONTAL = "CountdownTimerHorizontalPosition";

    public static final String COUNTDOWN_VERTICAL = "CountdownTimerVerticalPosition";

    public static final String MAIN_LUA_SCRIPT = "MainAccountLuaScript";

    public static final String SLAVE_LUA_SCRIPT = "SlaveLuaScript";

    public static final String MAIN_ACCOUNT_FIRST = "ProcessMainAccountTurnFirst";

    public static final String DELAY_MOUSE_UP_DOWN = "DelayInMsBetweenMouseDownAndUp";

    public static final String RANDOM_DELAY_MOUSE_UP_DOWN = "RandomDelayInMsBetweenMouseDownAndUp";

    public static final String MOUSE_SPEED = "MouseSpeed";

    public static final String MOUSE_SCROLL_SPEED = "MouseScrollSpeed";

    public static final String EXIT_KEY_CODE = "ExitKeyCode";

    public static final String WAIT_TIME_BEFORE_CLICK_INPUT = "WaitTimeInMsBeforeClickInput";

    public static final String PREFERRED_PARTY_GROUP = "PreferredPartyGroup";

    public static final String PREFERRED_PARTY_DECK = "PreferredPartyDeck";

    public static final String PREFERRED_NM_PARTY_GROUP = "PreferredNightmareModePartyGroup";

    public static final String PREFERRED_NM_PARTY_DECK = "PreferredNightmareModePartyDeck";

    public static final String PREFERRED_SUMMONS = "PreferredSummons";

    public static final String DEFAULT_SUMMON_TAB = "DefaultSummonAttributeTab";

    public static final String REROLL_FOR_SUMMON = "RerollSummonWhenNoPreferredSummonWasFound";

    public static final String MIN_WAIT_AFTER_ATTACK = "MinWaitTimeInMsAfterAttack";

    public static final String MIN_WAIT_AFTER_SUMMON = "MinWaitTimeInMsAfterSummon";

    public static final String MIN_WAIT_AFTER_ABILITY = "MinWaitTimeInMsAfterAbility";

    public static final String LUA_SCRIPT = "LuaScript";

    public static final String RELOAD_ON_LAST_BATTLE = "ReloadPageOnLastBattle";

    public static final String NOT_WAIT_FOR_SERVER_RESPONSE = "DoNotWaitForServerResponse";

    public static final String MAX_WAIT_TIME_TO_LOAD_SELECTION = "MaxWaitTimeToLoadCharacterSelectionMenuInMs";

    public static final String RETRIEVE_STATUS_EFFECT = "RetrieveStatusEffects";

    public static final String EVENT_RAID_URL = "EventRaidUrl";

    public static final String EVENT_LUA_SCRIPT = "EventRaidScript";

    public static final String NM_URL = "NightmareModeUrl";

    public static final String NM_LUA_SCRIPT = "NightmareModeScript";

    public static final String EVENT_PAGE_URL = "EventPageUrl";

    public static final String NM_PREFERRED_SUMMON = "NightmareModePreferredSummons";

    public static final String REROLL_FOR_SUMMON_NM = "RerollSummonWhenNoPreferredSummonWasFoundForNightmareMode";

    public static final String NM_AVAILABLE_AT_START = "NightmareModeAvailableAtStart";

    public static final String WAIT_TIME_AFTER_EVENT_IS_LOADED = "WaitTimeInMsAfterEventPageIsLoaded";

    public static final String TREASURE_EVENT_URL = "TreasureEventUrl";

    public static final String DIFFICULTY = "Difficulty";

    public static final String AP_COST = "ActionPointCost";

    public static final String TREASURE_EVENT_LUA_SCRIPT = "TreasureEventModeScript";

    public static final String SCHEDULING_LUA_SCRIPT = "SchedulingLuaScript";

    public static final String CAPTCHA_SOUND_PATH = "CaptchaNotificationSoundPath";

    public static final String NUM_NOTIFICATION = "NumNotifications";

    public static final String MAX_NUM_SUMMON_BEFORE_PLAYING_SOUND = "MaxNumSummonSelectionFailuresBeforePlayingSoundNotification";

    public static final String RETREAT_WHEN_NO_DIMENSIONAL_HALO_TRANSFORM = "RetreatWhenNoDimensionalHaloTransformation";

    public static final String[] GENERAL_PARAMS = new String[]{LANGUAGE, CHROME_DEV_TOOL, MAX_PAGE_LOAD_BEFORE_RETRY,
                                                        MAX_TRIGGER_DELAY, MAX_RESPONSE_DELAY, MAX_NUM_ACTION_RETRIES,
                                                        MIN_WAIT_TIME_AFTER_REFRESH, TIME_LIMIT, USE_VIRAMATE,
                                                        MAX_NUM_POTION_TO_USE, USE_FULL_EX, USE_FULL_EX_FIRST,
                                                        COUNTDOWN_HORIZONTAL, COUNTDOWN_VERTICAL};

    public static final String[] SLAVE_MODE_PARAMS = new String[]{ACTIVE, MAIN_LUA_SCRIPT, SLAVE_LUA_SCRIPT, MAIN_ACCOUNT_FIRST};

    public static final String[] INPUT_PARAMS = new String[]{DELAY_MOUSE_UP_DOWN, RANDOM_DELAY_MOUSE_UP_DOWN,
                                                            MOUSE_SPEED, MOUSE_SCROLL_SPEED, EXIT_KEY_CODE, WAIT_TIME_BEFORE_CLICK_INPUT};

    public static final String[] PARTY_SELECTION_PARAMS = new String[]{PREFERRED_PARTY_GROUP, PREFERRED_PARTY_DECK,
                                                                        PREFERRED_NM_PARTY_GROUP, PREFERRED_NM_PARTY_DECK};

    public static final String[] SUMMON_PARAMS =  new String[]{PREFERRED_SUMMONS, DEFAULT_SUMMON_TAB, REROLL_FOR_SUMMON};

    public static final String[] COMBAT_PARAMS = new String[]{MIN_WAIT_AFTER_ATTACK, MIN_WAIT_AFTER_SUMMON, MIN_WAIT_AFTER_ABILITY,
                                                            LUA_SCRIPT, RELOAD_ON_LAST_BATTLE, NOT_WAIT_FOR_SERVER_RESPONSE,
                                                            MAX_WAIT_TIME_TO_LOAD_SELECTION, RETRIEVE_STATUS_EFFECT};

    public static final String[] EVENT_PARAMS =  new String[]{ENABLE, EVENT_RAID_URL, EVENT_LUA_SCRIPT, NM_URL,
                                                            NM_LUA_SCRIPT, EVENT_PAGE_URL, NM_PREFERRED_SUMMON,
                                                            REROLL_FOR_SUMMON_NM, NM_AVAILABLE_AT_START, WAIT_TIME_AFTER_EVENT_IS_LOADED};

    public static final String[] TREASURE_EVENT_PARAMS =  new String[]{ENABLE, TREASURE_EVENT_URL, DIFFICULTY,
                                                                    AP_COST, TREASURE_EVENT_LUA_SCRIPT, NM_URL,
                                                                    NM_LUA_SCRIPT, NM_PREFERRED_SUMMON, REROLL_FOR_SUMMON_NM,
                                                                    NM_AVAILABLE_AT_START};

    public static final String[] SOLO_COOP_PARAMS = new String[]{ENABLE, LUA_SCRIPT};

    public static final String[] CUSTOMIZED_SCHEDULING_PARAMS = new String[]{ENABLE, SCHEDULING_LUA_SCRIPT};

    public static final String[] ALERTING_PARAMS = new String[]{CAPTCHA_SOUND_PATH, NUM_NOTIFICATION, MAX_NUM_SUMMON_BEFORE_PLAYING_SOUND};

    public static final String[] DIMENSIONAL_HALO_PARAMS = new String[]{RETREAT_WHEN_NO_DIMENSIONAL_HALO_TRANSFORM};

    public static final String ZOOEY_BOT_INI = "ZooeyBot.ini";

    public static final String ZOOEY_BOT_INI_ABSOLUTE = new File(ZOOEY_BOT_INI).getAbsolutePath();

    public static final String[] NAVIGATION_ITEMS = new String[]{"Mode Select", "General", "Inputs", "Party Selection", "Summons",
                                                        "Combat", "Event Mode", "Slave Mode", "Treasure Event Mode",
                                                        "Solo Coop Mode", "Customized Scheduling", "Dimensional Halo", "Alerting"};

    public static final Map<String, String> TREASURE_RAIDS = new LinkedHashMap<String, String>(){{
        put("Very Hard", "vh");
        put("Extreme", "ex");
        put("Impossible", "impossible");
        put("Guild War", "gw");
        put("Guild War Day 2 NM 90", "gw-day-2-nm-90");
        put("Guild War Day 2 NM 95", "gw-day-2-nm-95");
        put("Guild War Day 4 NM 90", "gw-day-4-nm-90");
        put("Guild War Day 4 NM 95", "gw-day-4-nm-95");
        put("Guild War Day 4 NM 100", "gw-day-4-nm-100");
    }};

    public static final Map<String, String> LANGUAGES = new LinkedHashMap<String, String>(){{
        put("English", "en");
        put("Japanese", "jp");
    }};
}
