package nl.belastingdienst.tdd.mocking;

public class Dependency {

    int x() {throw new RuntimeException("Database is offline");}

    void y() {}
}
