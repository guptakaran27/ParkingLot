package com.karan.exception;/*
 * @project ParkingLot
 * @author karan.k.gupta
 *
 */

public class VehicleNotParkedException extends Exception{
    public VehicleNotParkedException(String message){
        super(message);
    }
}
