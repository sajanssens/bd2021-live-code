package nl.belastingdienst.rest.util;

import javax.ws.rs.BadRequestException;

import static java.lang.String.format;

public final class Responses {
    private Responses() {
    }

    public static Runnable throwBadRequest(Long id) {
        return () -> {throw badRequest(id);};
    }

    public static BadRequestException badRequest(Long id) {
        return new BadRequestException(format("Object with id %s not found.", id));
    }
}
