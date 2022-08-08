package com.gridnine.testing.Flight;
import com.gridnine.testing.Flight.fabric.FlightBuilder;
import com.gridnine.testing.Flight.filter.FlightsFilter;

public class Main {
    public static void main(String[] args) {
        FlightBuilder flightBuilder = new FlightBuilder();
        FlightsFilter flightsFilter = new FlightsFilter();
        flightsFilter.findAfterCurrentTime(flightBuilder.createFlights());
        flightsFilter.excludeArrivalAfterDeparture(flightBuilder.createFlights());
        flightsFilter.findMoreTwoHoursGroundDuration(flightBuilder.createFlights());
    }
}
