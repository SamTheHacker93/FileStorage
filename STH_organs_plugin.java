import com.fs.starfarer.api.BaseModPlugin;
import com.fs.starfarer.api.Global;
import com.fs.starfarer.api.campaign.CustomCampaignEntityAPI;
import com.fs.starfarer.api.campaign.PlanetAPI;
import com.fs.starfarer.api.campaign.SectorAPI;
import com.fs.starfarer.api.campaign.StarSystemAPI;
import com.fs.starfarer.api.campaign.econ.MarketAPI;

public class STH_organs_plugin extends BaseModPlugin {
    @Override
    public void onNewGame() {
        SectorAPI sector = Global.getSector();
        StarSystemAPI system = sector.createStarSystem("Elvera");
        PlanetAPI star = system.initStar(
                "Elvera",
                "star_green",
                1000,
                7500,
                17500,
                500);

        CustomCampaignEntityAPI customCampaignEntityAPI1 = system.addCustomEntity("Elvera_buoy",
                "Elvera Buoy",
                "nav_buoy",
                "neutral");
        customCampaignEntityAPI1.setCircularOrbitPointingDown(star, 40, 7000, 400);
        CustomCampaignEntityAPI customCampaignEntityAPI2 = system.addCustomEntity("Elvera_relay",
                "Elvera Relay",
                "comm_relay",
                "neutral");
        customCampaignEntityAPI2.setCircularOrbitPointingDown(star, 190, 7000, 400);
        CustomCampaignEntityAPI customCampaignEntityAPI3 = system.addCustomEntity("Elvera_array",
                "Elvera Array",
                "sensor_array",
                "neutral");
        customCampaignEntityAPI3.setCircularOrbitPointingDown(star, 280, 7000, 400);
        CustomCampaignEntityAPI customCampaignEntityAPI4 = system.addCustomEntity("Elvera_gate",
                "Elvera Gate",
                "inactive_gate",
                null);
        customCampaignEntityAPI4.setCircularOrbit(star, 120, 7000, 400);

        PlanetAPI Beshine = system.addPlanet("Beshine", star, "Beshine", "desert", 90, 90, 2500, 100);
        Beshine.getSpec().setTexture(Global.getSettings().getSpriteName("planets", "desert"));
        Beshine.applySpecChanges();
        PlanetAPI Henrshu = system.addPlanet("Henrshu", star, "Henrshu", "burnt", 30, 60, 1800, 75);

        PlanetAPI Calama = system.addPlanet("Calama", star, "Calama", "terran", 15, 130, 4000, 360);
        Calama.getSpec().setTexture(Global.getSettings().getSpriteName("planets", "terra"));
        Calama.applySpecChanges();
        system.autogenerateHyperspaceJumpPoints(true, true);


        MarketAPI Beshine_market = Global.getFactory().createMarket("Beshine_market", Beshine.getName(), 0);
        Beshine_market.setPlanetConditionMarketOnly(true);
        Beshine_market.addCondition("hot");
        Beshine_market.addCondition("habitable");
        Beshine_market.addCondition("low_gravity");
        Beshine_market.addCondition("ore_rich");
        Beshine_market.addCondition("rare_ore_rich");
        Beshine_market.setPrimaryEntity(Beshine);
        Beshine.setMarket(Beshine_market);
        MarketAPI Henrshu_market = Global.getFactory().createMarket("Henrshu_market", Henrshu.getName(), 0);
        Henrshu_market.setPlanetConditionMarketOnly(true);
        Henrshu_market.addCondition("hot");
        Henrshu_market.addCondition("habitable");
        Henrshu_market.addCondition("low_gravity");
        Henrshu_market.addCondition("ore_rich");
        Henrshu_market.addCondition("rare_ore_rich");
        Henrshu_market.setPrimaryEntity(Henrshu);
        Henrshu.setMarket(Henrshu_market);
        MarketAPI Calama_market = Global.getFactory().createMarket("Calama_market", Calama.getName(), 0);
        Calama_market.setPlanetConditionMarketOnly(true);
        Calama_market.addCondition("inimical_biosphere");
        Calama_market.addCondition("habitable");
        Calama_market.addCondition("ore_moderate");
        Calama_market.addCondition("farmland_rich");
        Calama_market.addCondition("rare_ore_abundant");
        Calama_market.setPrimaryEntity(Calama);
        Calama.setMarket(Calama_market);


    }
}
