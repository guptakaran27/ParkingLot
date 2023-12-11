package com.karan.exception;/*
 * @project ParkingLot
 * @author karan.k.gupta
 *
 */

public class ParkingFullException extends Exception {
    public ParkingFullException(String message){
        super(message);
    }
}
