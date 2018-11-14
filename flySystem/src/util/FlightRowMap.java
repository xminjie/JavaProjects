package util;

import entity.Flight;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FlightRowMap implements RowMap {

    @Override
    public Object getRowmap(ResultSet res) {
        Flight flight = new Flight();
        try {
            flight.setFlightId(res.getString("flightId"));
            flight.setBeginAddress(res.getString("beginAddress"));
            flight.setEndAddress(res.getString("endAddress"));
            flight.setBeginTime(res.getString("beginTime"));
            flight.setPrice(Float.parseFloat(res.getString("price")));
            flight.setAvailableTickets(Integer.parseInt(res.getString("avaliableTikects")));
            flight.setTime(res.getInt("time"));
            return flight;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
