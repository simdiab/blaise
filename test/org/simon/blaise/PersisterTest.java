package org.simon.blaise;

import org.junit.Test;

import static org.junit.Assert.*;

public class PersisterTest {

    @Test
    public void testSave() throws Exception {
        Person p = new Person();

        Persister persister = new Persister();
        persister.save();

    }
}