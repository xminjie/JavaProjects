package dao;

import entity.Flight;

import java.util.List;

public interface FlightDao {
    Flight flightAdd(Flight flight);
    Flight flightAddCheck(Flight flight);

    void flightModify(Flight flight);
    void flightDelete(Flight flight);

    void flightTikectsChange(String flightId, int det);

    List<Flight> queryAll();
    List<Flight>  queryAll(Flight flight);
}
