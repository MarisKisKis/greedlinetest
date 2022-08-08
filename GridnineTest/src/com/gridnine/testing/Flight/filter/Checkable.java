package com.gridnine.testing.Flight.filter;
import com.gridnine.testing.Flight.fabric.Flight;

import java.util.List;

public interface Checkable {
    public List<Flight> findAfterCurrentTime(List<Flight> createFlights);
    public List<Flight> excludeArrivalAfterDeparture(List<Flight> createFlights);
    public List<Flight> findMoreTwoHoursGroundDuration(List<Flight> createFlights);
}
