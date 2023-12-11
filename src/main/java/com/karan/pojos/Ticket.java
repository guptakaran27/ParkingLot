package com.karan.pojos;/*
 * @project ParkingLot
 * @author karan.k.gupta
 *
 */

import com.karan.VehicleType;

import java.util.Date;

public class Ticket {

    private int slotId;
    private String VehicleNumber;
    private Date date;
    private VehicleType vehicleType;

    public Ticket(int slotId, String vehicleNumber, Date date, VehicleType vehicleType) {
        this.slotId = slotId;
        VehicleNumber = vehicleNumber;
        this.date = date;
        this.vehicleType = vehicleType;
    }

    public int getSlotId() {
        return slotId;
    }

    public void setSlotId(int slotId) {
        this.slotId = slotId;
    }

    public String getVehicleNumber() {
        return VehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        VehicleNumber = vehicleNumber;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "slotId='" + slotId + '\'' +
                ", VehicleNumber='" + VehicleNumber + '\'' +
                ", date=" + date +
                ", vehicleType=" + vehicleType +
                '}';
    }
}
