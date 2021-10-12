package nl.belastingdienst.tdd.tdd2lab;

public class TrajectPrijsService {

    private ZoneService zoneBackend;
    private PrijsPerZoneService prijsPerZoneBackend;

    public double getTrajectPrijs(String from, String to) {
        int zones = zoneBackend.bereken(from, to);
        int prijs = prijsPerZoneBackend.bereken(zones);

        if (zones < 2) {
            prijs *= 2;
        }

        return zones * prijs;
    }

}
