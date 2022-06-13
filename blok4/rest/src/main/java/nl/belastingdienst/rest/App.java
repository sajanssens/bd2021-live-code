package nl.belastingdienst.rest;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application; // javax.ws.rs == JAX-RS == REST
                                     // javax.ws    == SOAP

// Run:
// - as dev with `mvn liberty:dev`
// - as user with docker (see README.md)
@ApplicationPath("/api")
public class App extends Application {

    // dit is een soort main voor je rest app.
    // onze app draait nu op http(s)://host:port/context-root/application-path/een-resource-path
    // bijv.: http://localhost:9080/rest/api/contacts

}
