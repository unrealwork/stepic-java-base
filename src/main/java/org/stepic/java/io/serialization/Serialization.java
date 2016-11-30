package org.stepic.java.io.serialization;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;


public class Serialization {
    public static Animal[] deserializeAnimalArray(byte[] data) {
        try {
            ObjectInputStream is = new ObjectInputStream(new ByteArrayInputStream(data));
            int size = is.readInt();
            Animal[] result = new Animal[size];
            for (int i = 0; i < size; i++) {
                result[i] = (Animal) is.readObject();
            }
            return result;
        } catch (IOException | ClassCastException | ClassNotFoundException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
