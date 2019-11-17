package com.company.parkingLot;

import com.company.car.Car;
import com.company.parkingSpace.ParkingSpace;
import com.company.ticket.Ticket;

import java.util.ArrayList;
import java.util.HashMap;

public class ParkingLotImpl implements ParkingLot{

    private ParkingSpace[] parkingSpace;
    private int totalNumOfSlots;

    private HashMap<String, ArrayList<String>> colorToCars;
    private HashMap<String,Integer> carToSlot;
    private HashMap<String,ArrayList<Integer>> colorToSlots;

    public ParkingLotImpl(){
        colorToCars = new HashMap<>();
        carToSlot = new HashMap<>();
        colorToSlots = new HashMap<>();
    }

    @Override
    public void setTotalNumOfSlots(int totalNumOfSlots) {
        this.totalNumOfSlots = totalNumOfSlots;
    }

    @Override
    public void createLot()
    {
        parkingSpace = new ParkingSpace[this.totalNumOfSlots];

        for(int i = 0; i < this.totalNumOfSlots; i++)
        {
            this.parkingSpace[i] = null;
        }

        System.out.println("Created a parking lot with " + this.totalNumOfSlots + " slots");

    }

    @Override
    public int assignSpace(Car car)//assignSpace
    {
        //Finds the first empty parking space and adds the car there
        for(int i = 0; i < this.totalNumOfSlots; i++)
        {

            if(this.parkingSpace[i] == null)
            {
                Ticket ticket = new Ticket();
                ticket.setSlotNum(i+1);

                ticket.setSlotNum(i + 1);


                ParkingSpace parkingSpace = new ParkingSpace();

                parkingSpace.setCar(car);
                parkingSpace.setSlotNum(i+1);
                parkingSpace.setTicket(ticket);

                this.parkingSpace[i] = parkingSpace;



                if(!colorToCars.containsKey(car.getColor()))
                {
                    colorToCars.put(car.getColor(), new ArrayList<>());
                }

                colorToCars.get(car.getColor()).add(car.getRegistrationNumber());
                carToSlot.put(car.getRegistrationNumber(), ticket.getSlotNum());

                if(!colorToSlots.containsKey(car.getColor()))
                {
                    colorToSlots.put(car.getColor(), new ArrayList<>());
                }

                colorToSlots.get(car.getColor()).add(ticket.getSlotNum());

                return i+1;
            }
        }

        return -1;
    }

    @Override
    public void freeSpace(int n)
    {
        ParkingSpace parkingSpaceToRemove = this.parkingSpace[n-1];
        this.parkingSpace[n-1] = null;

        carToSlot.remove(parkingSpaceToRemove.getCar().getRegistrationNumber());

        if(colorToCars.get(parkingSpaceToRemove.getCar().getColor()).size() > 1)
        {
            for(int i = 0; i < colorToCars.get(parkingSpaceToRemove.getCar().getColor()).size(); i++)
            {
                if(parkingSpaceToRemove.getCar().getRegistrationNumber().equals(colorToCars.get(parkingSpaceToRemove.getCar().getColor()).get(i)))
                {
                    colorToCars.get(parkingSpaceToRemove.getCar().getColor()).remove(i);
                    break;
                }
            }
        }

        else
        {
            colorToCars.remove(parkingSpaceToRemove.getCar().getColor());
        }

        if(colorToSlots.get(parkingSpaceToRemove.getCar().getColor()).size() > 1)
        {
            for(int i = 0; i < colorToSlots.get(parkingSpaceToRemove.getCar().getColor()).size(); i++)
            {
                if(parkingSpaceToRemove.getSlotNum() == colorToSlots.get(parkingSpaceToRemove.getCar().getColor()).get(i))
                {
                    colorToSlots.get(parkingSpaceToRemove.getCar().getColor()).remove(i);
                    break;
                }
            }
        }

        else
        {
            colorToSlots.remove(parkingSpaceToRemove.getCar().getColor());
        }

        System.out.println("Slot number " + n + " is free");
    }

    public void showAllCars()
    {
        System.out.println("Slot No");
        for(int i = 0; i < this.totalNumOfSlots; i++)
        {

            if(parkingSpace[i] != null)
            {
                System.out.println(parkingSpace[i].getSlotNum());
            }
        }

        System.out.println("Registration No");
        for(int i = 0; i < this.totalNumOfSlots; i++)
        {
            if(parkingSpace[i] != null)
            {
                System.out.println(parkingSpace[i].getCar().getRegistrationNumber());
            }
        }

        System.out.println("Colour");
        for(int i = 0; i < this.totalNumOfSlots; i++)
        {
            if(parkingSpace[i] != null)
            {
                System.out.println(parkingSpace[i].getCar().getColor());
            }
        }
    }

    public void showAllCarsWithColour(String colour)
    {
        StringBuilder allCars = new StringBuilder();
        int flag = 0;

        for(String car : colorToCars.get(colour))
        {
            if(flag == 0)
            {
                flag = 1;
                allCars.append(car);
                continue;
            }

            allCars.append(", " + car);
        }


        System.out.println(allCars);
    }

    public void showAllSlotsWithColour(String colour)
    {
        StringBuilder allSlots = new StringBuilder();
        int flag = 0;

        for(int slot : colorToSlots.get(colour))
        {
            if(flag == 0)
            {
                flag = 1;
                allSlots.append(slot);
                continue;
            }

            allSlots.append(", " + slot);
        }


        System.out.println(allSlots);
    }

    public void showSlotForCar(String carReg)//show
    {
        if(carToSlot.containsKey(carReg))
        {
            System.out.println(carToSlot.get(carReg));
        }
        else
        {
            System.out.println("Not found");
        }
    }
}
