package me.khazaddum.mordor.app.controller;

import org.junit.Test;

import static org.junit.Assert.*;

public class TestDrive {

    @Test
    public void nameIsValid() {
        String name = "John Wick";
        assertEquals( name, "John Wick" );
    }

    @Test
    public void userIsEnabled() {
        boolean userEnabled = true;
        assertTrue( userEnabled );
    }

    @Test
    public void userIsNotEnabled() {
        boolean userEnabled = false;
        assertFalse( userEnabled );
    }

    @Test
    public void userIsDefined() {
        String user = "John Wick";
        assertNotNull( user );
    }

}
