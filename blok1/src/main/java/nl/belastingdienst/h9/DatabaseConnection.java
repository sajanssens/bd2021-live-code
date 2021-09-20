package nl.belastingdienst.h9;

public class DatabaseConnection {

    // private static boolean alAangeroepen = false;
    // public static DatabaseConnection eagerConnection = new DatabaseConnection();
    public static DatabaseConnection lazyConnection = null;

    private final String databaseServer = "localhost:3306";

    // public DatabaseConnection(){
    //    // omdat ik zelf een constructor heb gedeclareerd is deze weg.
    // }

    private DatabaseConnection() { }

    public static DatabaseConnection create() {
        if (lazyConnection != null) { // niet thread safe!
            lazyConnection = new DatabaseConnection();
            return lazyConnection;
        } else {
            return lazyConnection;
        }
    }

    // ....

}
