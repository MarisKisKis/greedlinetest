package com.gridnine.testing.Flight.fabric;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Flight {
    public List<Segment> segments;

    public Flight(final List<Segment> segs) {
        segments = segs;
    }

    public List<Segment> getSegments() {
        return segments;
    }

    public Segment getSegment (int id) {
        return segments.get(id);
    }

    @Override
    public String toString() {
        return segments.stream().map(Object::toString)
                .collect(Collectors.joining(" "));
    }
}
