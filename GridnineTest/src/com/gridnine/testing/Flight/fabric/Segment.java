package com.gridnine.testing.Flight.fabric;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

  public class Segment {
    private LocalDateTime departureDate;

    private LocalDateTime arrivalDate;

    Segment(LocalDateTime dep, LocalDateTime arr) {
        departureDate = Objects.requireNonNull(dep);
        arrivalDate = Objects.requireNonNull(arr);
    }

    public LocalDateTime getDepartureDate() {
        return departureDate;
    }

    public LocalDateTime getArrivalDate() {
        return arrivalDate;
    }

    public boolean FlightIsMoreTwoHours (LocalDateTime departureDate, LocalDateTime arrivalDate) {
        boolean flightDuration = false;
        if (arrivalDate.minusHours(2).isBefore(departureDate)) {
            flightDuration = true;
        }
          return flightDuration;
      }

    @Override
    public String toString() {
        DateTimeFormatter fmt =
                DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
        return '[' + departureDate.format(fmt) + '|' + arrivalDate.format(fmt)
                + ']';
    }
}