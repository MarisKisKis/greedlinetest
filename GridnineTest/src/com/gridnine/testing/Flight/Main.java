package com.gridnine.testing.Flight;

import com.gridnine.testing.Flight.fabric.Flight;
import com.gridnine.testing.Flight.fabric.FlightBuilder;
import com.gridnine.testing.Flight.filter.FlightsFilter;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        FlightBuilder flightBuilder = new FlightBuilder();
        FlightsFilter flightsFilter = new FlightsFilter();
        System.out.println(flightBuilder.createFlights());
        System.out.println(flightsFilter.findAfterCurrentTime(flightBuilder.createFlights()));
        System.out.println(flightsFilter.excludeArrivalAfterDeparture(flightBuilder.createFlights()));
        System.out.println(flightsFilter.findMoreTwoHoursGroundDuration(flightBuilder.createFlights()));
    }
}
