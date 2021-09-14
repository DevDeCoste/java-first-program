package com.h2;

public class Utilities {
    public static long getLongValue(String in) {
        long out = Long.MIN_VALUE;
        try{
            Long.parseLong(in);
        } catch (NumberFormatException e) {
            throw IllegalArgumentException(in + " cannot be converted into a 'long' value. Exiting program."in + " cannot be converted into a 'long' value. Exiting program.");
        }
        return out;
    }

} // End utilities Class