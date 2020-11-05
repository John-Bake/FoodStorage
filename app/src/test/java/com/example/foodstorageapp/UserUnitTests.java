package com.example.foodstorageapp;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;

public class UserUnitTests {
    @Test
    public void testIsUserCreated() {
        String testUserName = "BillyJoeBob";
        User user = new User();
        user.setUserName(testUserName);
        assertSame(user.getUserName(), testUserName);
    }
}
