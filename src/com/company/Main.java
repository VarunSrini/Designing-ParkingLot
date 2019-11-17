package com.company;

import com.company.car.Car;
import com.company.parkingLot.ParkingLot;
import com.company.parkingLot.ParkingLotImpl;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ParkingLot parkingLot = new ParkingLotImpl();

        System.out.println("THE NEW CHANGE");

        Scanner sc = new Scanner(System.in).useDelimiter("\n");

        System.out.print("$ ");
        String cmd = sc.nextLine();


        String[] commands = cmd.trim().split(" ");

        while(!commands[0].equals("exit"))
        {
            switch(commands[0])
            {
                case "create_parking_lot":
                    parkingLot.setTotalNumOfSlots(Integer.parseInt(commands[1]));

                    parkingLot.createLot();

                    break;
                case "park":
                    Car car = new Car();
                    car.setRegistrationNumber(commands[1]);
                    car.setColor(commands[2]);

                    int slotNum = parkingLot.assignSpace(car);

                    if(slotNum > 0)
                    {
                        System.out.println("Allocated slot number: " + slotNum);
                    }
                    else {

                        System.out.println("Sorry, parking lot is full");

                    }

                    break;
                case "leave":
                    parkingLot.freeSpace(Integer.parseInt(commands[1]));

                    break;
                case "status":
                    parkingLot.showAllCars();

                    break;

                case "registration_numbers_for_cars_with_colour":
                    parkingLot.showAllCarsWithColour(commands[1]);

                    break;
                case "slot_numbers_for_cars_with_colour":
                    parkingLot.showAllSlotsWithColour(commands[1]);

                    break;
                case"slot_number_for_registration_number":
                    parkingLot.showSlotForCar(commands[1]);

                    break;
            }

            System.out.print("$ ");
            cmd = sc.nextLine();
            commands = cmd.trim().split(" ");
        }
    }
}
