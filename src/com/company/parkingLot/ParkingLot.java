package com.company.parkingLot;

import com.company.car.Car;

public interface ParkingLot {
    public void setTotalNumOfSlots(int totalNumOfSlots);

    public void createLot();

    public int assignSpace(Car car);

    public void freeSpace(int n);

    public void showAllCars();

    public void showAllCarsWithColour(String colour);

    public void showAllSlotsWithColour(String colour);

    public void showSlotForCar(String carReg);
}
