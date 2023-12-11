package com.karan.pojos;/*
 * @project ParkingLot
 * @author karan.k.gupta
 *
 */

public class Slot {

    private int slotId;
    private Boolean isAvailable;
    private Vehicle parkedVehicle;

    public Slot(int slotId) {
        this.slotId = slotId;
        this.isAvailable = true;
    }

    public int getSlotId() {
        return slotId;
    }

    public void setSlotId(int slotId) {
        this.slotId = slotId;
    }

    public boolean isAvailable(){
        return isAvailable;
    }

    public Vehicle getParkedVehicle(){
        return parkedVehicle;
    }

    public void setParkedVehicle( Vehicle parkVehicle){
        this.parkedVehicle = parkVehicle;
    }

    public void bookTheSlot(Vehicle parkVehicle){
        this.parkedVehicle = parkVehicle;
        this.isAvailable = false;
    }

    public void freeTheSlot(){
        this.parkedVehicle =  null;
        this.isAvailable = true;
    }
}
