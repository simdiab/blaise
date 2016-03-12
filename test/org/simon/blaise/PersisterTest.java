package org.simon.blaise;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.Assert.*;

public class PersisterTest {

    @After
    public void cleanUp()
    {
        System.out.println("Cleaning up");
        try {
            Files.deleteIfExists(Paths.get("object.store"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testSave() throws Exception {
        System.out.println("Test Save");
        Person p = new Person();

        Persister persister = new Persister();
        persister.save(p);
        assertEquals(true, Files.exists(Paths.get("object.store")));

    }

    @Test
    public void testSaveAndGet() throws Exception {
        System.out.println("Test Save and Get");
        Person p = new Person();

        Persister persister = new Persister();
        persister.save(p);

        assertEquals(1, persister.getSavedObjects().size());

    }
}