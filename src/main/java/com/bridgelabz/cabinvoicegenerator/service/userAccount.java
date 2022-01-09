package com.bridgelabz.cabinvoicegenerator.service;

import com.bridgelabz.cabinvoicegenerator.model.Ride;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class userAccount {

    public static Map<String, List<Ride>> userMap = new HashMap<>();

    public userAccount(String userName, List<Ride> rideList) {
        userMap.put(userName, rideList);
    }
}

