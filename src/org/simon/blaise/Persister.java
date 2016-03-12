package org.simon.blaise;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

public class Persister {

    private String objectStore;

    public Persister() {
        this.setObjectStore("object.store");
    }

    public Persister(String objectStore) {
        if (objectStore == null)
        {
            this.setObjectStore("object.store");
        }
    }

    public void save(Object o) {
        //Serialise the object and write to file system.
        ObjectOutputStream outStream = null;
        try {
            outStream = new ObjectOutputStream(new FileOutputStream(this.getObjectStore()));
            outStream.writeObject(o);

        } catch (IOException ioException) {
            System.err.println("Error opening file.");
        } catch (NoSuchElementException noSuchElementException) {
            System.err.println("Invalid input.");
        } finally {
            try {
                if (outStream != null)
                    outStream.close();
            } catch (IOException ioException) {
                System.err.println("Error closing file.");
            }
        }

    }

    public List<Object> getSavedObjects() {
        //Retrieve all the objects that have been persisted.
        List<Object> objectList = new LinkedList<>();
        try {
            ObjectInputStream inStream = new ObjectInputStream(new FileInputStream(this.getObjectStore()));
            while (true) {
                objectList.add(inStream.readObject());
            }
        } catch (EOFException e) {
            return objectList;
        }
        catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return objectList;
    }

    public String getObjectStore() {
        return objectStore;
    }

    public void setObjectStore(String objectStore) {
        this.objectStore = objectStore;
    }
}
