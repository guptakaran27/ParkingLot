package com.karan.service;/*
 * @project ParkingLot
 * @author karan.k.gupta
 *
 */


import com.karan.interfaces.ParkingChargeTypes;

public class SmallCarCharges implements ParkingChargeTypes {
    @Override
    public int calculateCharges(int parkingHours) {
        if( parkingHours < 1) return 80;
        return parkingHours * 80;
    }
}
