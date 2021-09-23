package nl.belastingdienst.fundamentals.h10;

public class InterimManager extends TemporaryEmployee {

    private boolean managementBSBingoCardIsFull;

    public InterimManager() {
        // super(); // roep de constructor uit de superclass aan; vergelijkbaar met this();
        // dit staat altijd op de eerste regel van de ctor van een subclass.
        super(200);
        this.managementBSBingoCardIsFull = false;
    }

}
