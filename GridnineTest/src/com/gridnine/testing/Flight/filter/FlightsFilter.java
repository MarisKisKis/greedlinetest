package com.gridnine.testing.Flight.filter;

import com.gridnine.testing.Flight.fabric.Flight;
import com.gridnine.testing.Flight.fabric.Segment;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class FlightsFilter implements Checkable {
    FilterUtil filterUtil = new FilterUtil();

    @Override
    public List<Flight> findAfterCurrentTime(List<Flight> createFlights) {
        List<Flight> NotTooEarlyFlights = new ArrayList<>();
        for (Flight flight : createFlights) {
            ArrayList<Segment> segments = filterUtil.getFlightsSegments(flight);
            boolean flightIsAfterCurrentTime = filterUtil.checkCurrentTime(segments);
            if (flightIsAfterCurrentTime == true) {
                NotTooEarlyFlights.add(flight);
            }
        }
        return NotTooEarlyFlights;
    }

    @Override
    public List<Flight> excludeArrivalAfterDeparture(List<Flight> createFlights) {
        List<Flight> NotInThePastFlights = new ArrayList<>();
        for (Flight flight : createFlights) {
            ArrayList<Segment> segments = filterUtil.getFlightsSegments(flight);
            boolean ArrivalBeforeDeparture = filterUtil.getDeparturesCompared(segments);
            if (ArrivalBeforeDeparture == true) {
                NotInThePastFlights.add(flight);
            }
        }
        return NotInThePastFlights;
    }

    @Override
    public List<Flight> findMoreTwoHoursGroundDuration(List<Flight> createFlights) {
        List<Flight> lessTwoHoursGroundDuration = new ArrayList<>();
        for (Flight flight : createFlights) {
            ArrayList<Segment> segments = filterUtil.getFlightsSegments(flight);
            boolean groundTimeIsLessTwoHours = filterUtil.getTwoHoursGroundCheck(segments);
            if (groundTimeIsLessTwoHours == true) {
                lessTwoHoursGroundDuration.add(flight);
            }
        }
        return lessTwoHoursGroundDuration;
    }
}



