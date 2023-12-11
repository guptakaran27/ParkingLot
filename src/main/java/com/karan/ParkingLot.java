package com.karan;/*
 * @project ParkingLot
 * @author karan.k.gupta
 *
 */

import com.karan.exception.ParkingFullException;
import com.karan.interfaces.Parking;
import com.karan.interfaces.ParkingChargeTypes;
import com.karan.pojos.Slot;
import com.karan.pojos.Ticket;
import com.karan.pojos.Vehicle;

import java.util.*;

public class ParkingLot implements Parking {

    private static ParkingLot parkingLot;
    public static Map<VehicleType, Stack<Slot>> slotsAvailabilityMap = new HashMap<>();

    private static int smallCars = 0;
    private static int suv = 0;
    private static int bikes = 0;

    private static  List<Slot> smallCarSlotsList = new ArrayList<>(smallCars);
    private static  List<Slot> suvSlotsList =  new ArrayList<>(suv);
    private static List<Slot> bikeSlotsList = new ArrayList<>(bikes);



    public static ParkingLot getParkingLot(){
        if(parkingLot == null){
            parkingLot = new ParkingLot();

            Stack<Slot> smallCarStack = new Stack<>();
            smallCarStack.addAll(smallCarSlotsList);
            Stack<Slot> suvStack = new Stack<>();
            suvStack.addAll(suvSlotsList);
            Stack<Slot> bikeStack = new Stack<>();
            bikeStack.addAll(bikeSlotsList);

            slotsAvailabilityMap.put(VehicleType.SMALL_CAR, smallCarStack);
            slotsAvailabilityMap.put(VehicleType.SUV, suvStack);
            slotsAvailabilityMap.put(VehicleType.BIKE, bikeStack);
        }
        return parkingLot;
    }

    /**
     *
     * @param vehicle
     * @return
     *
     * While parking a vehicle, check for -
     *   1. Availability based on vehicle type
     *   2. Book the Slot -> isAvailable to FALSE, Assign Vehicle Details
     *   3. Assign Ticket
     */
    @Override
    public Ticket park(Vehicle vehicle) throws ParkingFullException {
        VehicleType vehicleType = vehicle.getVehicleType();

        if (isSlotAvailable(vehicleType)){
            Slot s = slotsAvailabilityMap.get(vehicleType).pop();
            s.bookTheSlot(vehicle);
            Ticket ticket = new Ticket(s.getSlotId(), vehicle.getVehicleNumber(), new Date(), vehicleType);
            return ticket;
        }
        else{
            throw new ParkingFullException("No Slot Available, PARKING FULL !!");
        }
    }

    @Override
    public int unPark(Ticket ticket) {
        return 0;
    }

    public boolean isSlotAvailable(VehicleType vehicleType) {
        return (!slotsAvailabilityMap.get(vehicleType).isEmpty());
    }
}
