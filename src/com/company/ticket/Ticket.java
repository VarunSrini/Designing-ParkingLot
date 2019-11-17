package com.company.ticket;

public class Ticket {
    int slotNum;

    public Ticket(){}

    public Ticket(int slotNum) {
        this.slotNum = slotNum;
    }

    public int getSlotNum() {
        return slotNum;
    }

    public void setSlotNum(int slotNum) {
        this.slotNum = slotNum;
    }
}
