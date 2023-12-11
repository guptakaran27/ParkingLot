package com.karan.service;/*
 * @project ParkingLot
 * @author karan.k.gupta
 *
 */

import com.karan.exception.VehicleNotParkedException;
import com.karan.interfaces.Parking;
import com.karan.ParkingLot;
import com.karan.VehicleType;
import com.karan.exception.ParkingFullException;
import com.karan.pojos.Slot;
import com.karan.pojos.Ticket;
import com.karan.pojos.Vehicle;

import java.util.*;

public class ParkingLot2 implements Parking {

    private static ParkingLot parkingLot;
    private final List<Slot> smallCarSlots;
    private final List<Slot> suvSlots;
    private final List<Slot> bikeSlots;

    private  Stack<Slot> freeSmallCarSlots;
    private  Stack<Slot> freeSuvSlots;
    private  Stack<Slot> freeBikeSlots;

    private Map<VehicleType, Stack<Slot>>  slotsAvailabilityMap;
    private Map<VehicleType, List<Slot>> bookedSlotsMap;

    public ParkingLot2() {
        this.smallCarSlots = new ArrayList<>();
        this.suvSlots = new ArrayList<>();
        this.bikeSlots = new ArrayList<>();
        this.freeBikeSlots = new Stack<>();
        this.freeSmallCarSlots = new Stack<>();
        this.freeSuvSlots = new Stack<>();
        this.slotsAvailabilityMap = new HashMap<>();
        this.bookedSlotsMap = new HashMap<>();
    }

    public static ParkingLot getParkingLot() {
        if (parkingLot == null)
            parkingLot = new ParkingLot();
        return parkingLot;
    }

    public boolean initializeParkingSlots(int small, int suv, int bike){
        for(int i=1; i<=small; i++) {
            smallCarSlots.add(new Slot(i));
            freeSmallCarSlots.push(new Slot(i));
        }
        for(int i=1; i<=suv; i++) {
            suvSlots.add(new Slot(i));
            freeSuvSlots.push(new Slot(i));
        }
        for(int i=1; i<=bike; i++) {
            bikeSlots.add(new Slot(i));
            freeBikeSlots.push(new Slot(i));
        }
        slotsAvailabilityMap.put(VehicleType.SMALL_CAR, freeSmallCarSlots);
        bookedSlotsMap.put(VehicleType.SMALL_CAR, new ArrayList<>());
        slotsAvailabilityMap.put(VehicleType.SUV, freeSuvSlots);
        bookedSlotsMap.put((VehicleType.SUV), new ArrayList<>());
        slotsAvailabilityMap.put(VehicleType.BIKE, freeBikeSlots);
        bookedSlotsMap.put(VehicleType.BIKE, new ArrayList<>());
        return true;
    }

    /**
     *
     * @param vehicle
     * @return
     *
     *  1. Availability based on vehicle type
     *  2. Book the Slot -> isAvailable to FALSE, Assign Vehicle Details
     *  3. Add in Booked Slot Map
     *  4. Assign Ticket
     */
    @Override
    public Ticket park(Vehicle vehicle) throws ParkingFullException {
        VehicleType vehicleType = vehicle.getVehicleType();

        if(isSlotAvailable(vehicleType)){
            Slot slot= slotsAvailabilityMap.get(vehicleType).pop();
            slot.bookTheSlot(vehicle);
            bookedSlotsMap.get(vehicleType).add(slot);
            Ticket ticket = new Ticket(slot.getSlotId(), vehicle.getVehicleNumber(), new Date(), vehicleType);
            return ticket;
        }
        else{
            throw new ParkingFullException("Slot not available, PARKING FULL ");
        }
    }

    /**
     *
     * @param ticket
     * @return
     *
     *  1. Check if the car has a Ticket No Valid
     *  2. Calculate charges on hourly basis
     *  3. Vacate the Slot
     *
     */
    @Override
    public int unPark(Ticket ticket) throws VehicleNotParkedException {

        String vehicleNumber = ticket.getVehicleNumber();
        VehicleType vehicleType = ticket.getVehicleType();
        Slot s = isCarParked(vehicleNumber,vehicleType);
        if(s == null){
            throw new VehicleNotParkedException("This Vehicle is not parked !!! ");
        }
        else{
            //s.freeTheSlot();
            int hoursParked = calculateHoursParked(ticket.getDate(), new Date());
            int cost = getCostofParking(hoursParked, vehicleType);
        }

        return 0;
    }

    public int calculateHoursParked(Date start, Date end){
        long seconds = (end.getTime() - start.getTime()) / 1000;
        return (int)(seconds/3600);
    }

    public int getCostofParking(int hoursParked, VehicleType vehicleType){

    }

    public Slot isCarParked(String vehicleNumber, VehicleType vehicleType){
        for(Slot s : bookedSlotsMap.get(vehicleType)){
            if(s!=null && s.getParkedVehicle().getVehicleNumber().equals(vehicleNumber)) return s;
        }
        return null;
    }

    public boolean isSlotAvailable(VehicleType vehicleType){
        if (slotsAvailabilityMap.get(vehicleType) == null) return false;
        else return !(slotsAvailabilityMap.get(vehicleType).isEmpty());
    }


}
