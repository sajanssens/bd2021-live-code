package nl.belastingdienst.fundamentals.extra.objects;

import lombok.Value;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SaveObjects {

    public static void main(String[] args) throws IOException {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("out.obj"))) {
            out.writeObject(new Author("Bram", 42));
        }
    }

}

@Value
class Author implements Serializable {
    String name;
    int age;
}
