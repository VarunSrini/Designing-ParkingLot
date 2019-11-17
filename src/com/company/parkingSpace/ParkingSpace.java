package com.company.parkingSpace;

import com.company.car.Car;
import com.company.ticket.Ticket;

public class ParkingSpace {

    private int slotNum;
    private Car car;
    private Ticket ticket;

    public ParkingSpace(){}

    public ParkingSpace(int slotNum, Car car, Ticket ticket) {
        this.slotNum = slotNum;
        this.car = car;
        this.ticket = ticket;
    }

    public int getSlotNum() {
        return slotNum;
    }

    public void setSlotNum(int slotNum) {
        this.slotNum = slotNum;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }


}
