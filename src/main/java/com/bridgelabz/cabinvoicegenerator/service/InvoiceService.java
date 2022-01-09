
package com.bridgelabz.cabinvoicegenerator.service;

import com.bridgelabz.cabinvoicegenerator.model.InvoiceSummary;
import com.bridgelabz.cabinvoicegenerator.model.Ride;

import java.util.List;

public class InvoiceService {

    //Declaring instance variables for normal ride.
    private final double COST_PER_KM = 10.0;
    private final int COST_PER_MIN = 1;
    private final double MIN_FARE = 5.0;

    //Declaring instance variables for premium class
    private static final double PREMIUM_COST_PER_KM = 15;
    private static final int PREMIUM_COST_PER_MIN = 2;
    private static final double PREMIUM_MIN_FARE = 20;


    //method for calculating fare for normal ones
    public double calculateFare(double distance, int time) {
        double totalFare = distance * COST_PER_KM + time * COST_PER_MIN;
        return Math.max(totalFare, MIN_FARE);

    }

    //method for calculating fare for premium ones
    public double calculateFarePremium(double distance, int time) {
        double totalFare = distance * PREMIUM_COST_PER_KM + time * PREMIUM_COST_PER_MIN;
        return Math.max(totalFare, PREMIUM_MIN_FARE);
    }

    public double calculateFare(Ride[] rides) {
        double totalFare = 0.0;
        for (Ride ride : rides) {
            totalFare += calculateFare(ride.getDistance(), ride.getTime());
        }
        return totalFare;
    }

    public InvoiceSummary calculateFares(Ride[] rides) {
        double totalFare = 0.0;
        for (Ride ride : rides) {
            totalFare += calculateFare(ride.getDistance(), ride.getTime());
        }
        System.out.println("rides : " + rides.length + " Fare : " + totalFare);
        return new InvoiceSummary(rides.length, totalFare);
    }

    public InvoiceSummary InvoiceSummary(String userName) {
        List<Ride> list = userAccount.userMap.get(userName);
        double totalFare = 0.0;
        int rideCount = 0;
        for (Ride ride : list) {
            totalFare += calculateFare(ride.getDistance(), ride.getTime());
            rideCount++;
        }
        return new InvoiceSummary(rideCount, (int) totalFare);
    }
}