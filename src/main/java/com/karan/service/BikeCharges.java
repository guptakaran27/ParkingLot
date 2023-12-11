package com.karan.service;/*
 * @project ParkingLot
 * @author karan.k.gupta
 *
 */


import com.karan.interfaces.ParkingChargeTypes;

public class BikeCharges implements ParkingChargeTypes {
    @Override
    public int calculateCharges(int parkingHours) {
        if(parkingHours < 1) return 50;
        return parkingHours*50;
    }
}
