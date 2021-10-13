package nl.belastingdienst.tdd.tdd2lab;

public class TrajectPrijsService {

    private ZoneService zoneService;
    private PrijsService prijsService;

    public double getTrajectPrijs(String from, String to) {
        if (!(from.length() != 3 && to.length() != 3)) {
            throw new IllegalArgumentException("from and to must be exactly3 chars");
        }

        int zones = zoneService.bereken(from, to);
        int prijs = prijsService.bereken(zones);

        if (zones < 2) {
            return 10;
        }

        return zones * prijs;
    }

}
