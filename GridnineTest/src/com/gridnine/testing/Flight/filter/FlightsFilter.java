package com.gridnine.testing.Flight.filter;

import com.gridnine.testing.Flight.fabric.Flight;
import com.gridnine.testing.Flight.fabric.Segment;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class FlightsFilter implements Checkable {

    @Override
    public List<Flight> findAfterCurrentTime(List<Flight> createFlights) {
        List<Flight> NotTooEarlyFlights = new ArrayList<>();
        for (Flight flight : createFlights) {
            ArrayList<Segment> segments = getFlightsSegments(flight);
            boolean flightIsAfterCurrentTime = checkCurrentTime(segments);
            if (flightIsAfterCurrentTime == true) {
                NotTooEarlyFlights.add(flight);
            }
        }
        return NotTooEarlyFlights;
    }
    public ArrayList<Segment> getFlightsSegments(Flight flight) {
        ArrayList<Segment> segments = new ArrayList<>();
        for (int i = 0; i < flight.getSegments().size(); i++) {
            segments.add(flight.getSegment(i));
        }
        return segments;
    }

    public boolean checkCurrentTime(ArrayList<Segment> segments) {
        boolean flightIsAfterCurrentTime = false;
        for (Segment segment : segments) {
            if (segment.getDepartureDate().isAfter(LocalDateTime.now())) {
                flightIsAfterCurrentTime = true;
            }
        }
        return flightIsAfterCurrentTime;
    }

    @Override
    public List<Flight> excludeArrivalAfterDeparture(List<Flight> createFlights) {
        List<Flight> NotInThePastFlights = new ArrayList<>();
        for (Flight flight : createFlights) {
            ArrayList<Segment> segments = getFlightsSegments(flight);
            boolean ArrivalBeforeDeparture = getDeparturesCompared(segments);
            if (ArrivalBeforeDeparture == true) {
                NotInThePastFlights.add(flight);
            }
        }
        return NotInThePastFlights;
    }

    public boolean getDeparturesCompared(ArrayList<Segment> segments) {
        boolean departureTimeChecked = false;
        for (int i = 0; i < segments.size()-1; i++) {
            Segment segment1 = segments.get(i);
            Segment segment2 = segments.get(i + 1);
            LocalDateTime date = segment1.getArrivalDate();
            LocalDateTime date2 = segment2.getDepartureDate();
            if (date.isBefore(date2)) {
                departureTimeChecked = true;
            }
        }
        return departureTimeChecked;
    }

    @Override
    public List<Flight> findMoreTwoHoursDuration(List<Flight> createFlights) {
        List<Flight> MoreTwoHoursDurationFlights = new ArrayList<>();
        for (Flight flight : createFlights) {
            ArrayList<Segment> segments = getFlightsSegments(flight);
            boolean flightIsMoreTwoHours = getTwoHoursFlightCheck(segments);
            if (flightIsMoreTwoHours == true) {
                MoreTwoHoursDurationFlights.add(flight);
            }
        }
        return MoreTwoHoursDurationFlights;
    }

    public boolean getTwoHoursFlightCheck(ArrayList<Segment> segments) {
        boolean flightIsMoreTwoHours = false;
        for (int i = 0; i < segments.size(); i++) {
            Segment segment1 = segments.get(i);
            if ((segment1.FlightIsMoreTwoHours(segment1.getDepartureDate(), segment1.getArrivalDate()) == true)) {
                flightIsMoreTwoHours = true;
            }
        }
        return flightIsMoreTwoHours;
    }
}



