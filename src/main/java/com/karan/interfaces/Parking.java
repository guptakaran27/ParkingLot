package com.karan.interfaces;/*
 * @project ParkingLot
 * @author karan.k.gupta
 *
 */

import com.karan.exception.ParkingFullException;
import com.karan.exception.VehicleNotParkedException;
import com.karan.pojos.Ticket;
import com.karan.pojos.Vehicle;

/**
 * Parking will be an interface
 *
 * It will have 2 features -> PARK and UNPARK vehicles
 *
 * PARK -> Once vehicle is parked, a ticket should be returned
 *
 * UNPARK ->  A vehicle should be unparked, only if he has a ticket
 *        -> After this, the price should be returned
 */

public interface Parking {

    public Ticket park(Vehicle vehicle) throws ParkingFullException;
    public int unPark(Ticket ticket) throws VehicleNotParkedException;

}
