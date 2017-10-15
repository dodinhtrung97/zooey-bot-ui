package constant;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Trung on 10/14/2017.
 */
public class Constant {

    public static String ZOOEY_BOT_INI = "ZooeyBot.ini";

    public static final String[] NAVIGATION_ITEMS = new String[]{"Mode Select", "General", "Inputs", "Party Selection", "Summons",
                                                        "Combat", "Event Mode", "Slave Mode", "Treasure Event Mode",
                                                        "Solo Coop Mode", "Customized Scheduling", "Dimensional Halo", "Alerting"};

    public static final Map<String, String> TREASURE_RAIDS = new LinkedHashMap<String, String>(){{
        put("Very Hard", "vh");
        put("Extreme", "ex");
        put("Guild War", "gw");
        put("Guild War Day 2 NM 90", "gw-day-2-nm-90");
        put("Guild War Day 2 NM 95", "gw-day-2-nm-95");
        put("Guild War Day 4 NM 90", "gw-day-4-nm-90");
        put("Guild War Day 4 NM 95", "gw-day-4-nm-95");
        put("Guild War Day 4 NM 100", "gw-day-4-nm-100");
    }};

    public static final Map<String, String> LANGUAGE = new LinkedHashMap<String, String>(){{
        put("English", "en");
        put("Japanese", "jp");
    }};
}
