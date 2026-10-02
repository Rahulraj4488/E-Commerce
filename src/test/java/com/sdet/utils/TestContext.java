package com.sdet.utils;

public class TestContext {
    public static String userName;
    public static String password;

    public static void setUsername(String userName) {
        TestContext.userName = userName;
    }

    public static String getuserName() {
        return userName;
    }

    public static void setpassword(String password) {
        TestContext.password = password;
    }

    public static String getPassword() {
        return password;
    }
}
