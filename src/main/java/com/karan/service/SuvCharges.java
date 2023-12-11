package com.karan.service;/*
 * @project ParkingLot
 * @author karan.k.gupta
 *
 */

import com.karan.interfaces.ParkingChargeTypes;

public class SuvCharges implements ParkingChargeTypes {

    @Override
    public int calculateCharges(int parkingHours) {
        if(parkingHours < 1) return 100;
        else return parkingHours * 100;
    }
}
