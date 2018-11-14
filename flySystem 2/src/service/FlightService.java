package service;

import entity.Flight;

import java.util.List;

public interface FlightService {
    Flight flightAdd(Flight flight);
    void flightModify(Flight flight);
    void flightDelete(Flight flight);
    List<Flight>  queryAll();
    List<Flight>  queryAll(Flight flight);
    void flightTikectsChange(String flightId, int det);

}
