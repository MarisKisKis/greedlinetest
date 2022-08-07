package com.gridnine.testing.Flight.filter;

import com.gridnine.testing.Flight.fabric.Flight;
import com.gridnine.testing.Flight.fabric.Segment;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class FilterUtil {
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

    public boolean getDeparturesCompared(ArrayList<Segment> segments) {
        boolean departureTimeChecked = false;
        for (int i = 0; i < segments.size() - 1; i++) {
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
    public boolean getTwoHoursGroundCheck(ArrayList<Segment> segments) {
        boolean groundTimeIsLessTwoHours = true;
        int allGroundTime = 0;
        if (segments.size() > 1) {
            for (int i = 0; i < segments.size() - 1; i++) {
                Segment segment1 = segments.get(i);
                Segment segment2 = segments.get(i + 1);
                String date1 = String.valueOf(segment1.getArrivalDate().getHour());
                String date2 = String.valueOf(segment2.getDepartureDate().getHour());
                int groundTime = Integer.parseInt(date2) - Integer.parseInt(date1);
                allGroundTime = allGroundTime + groundTime;
            }
            if (allGroundTime > 2) {
                groundTimeIsLessTwoHours = false;
            }
        } else {
            groundTimeIsLessTwoHours = true;
        }
        return groundTimeIsLessTwoHours;
    }
}
