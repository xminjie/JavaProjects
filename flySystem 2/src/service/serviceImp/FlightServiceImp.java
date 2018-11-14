package service.serviceImp;

import dao.FlightDaoImp;
import entity.Flight;
import factory.ObjectFactory;
import service.FlightService;

import java.util.List;

public class FlightServiceImp implements FlightService {
    @Override
    public Flight flightAdd(Flight flight) {
        FlightDaoImp addFlightDaoImp = (FlightDaoImp) ObjectFactory.getObject("FlightDaoImp");
        return addFlightDaoImp.flightAdd(flight);
    }

    @Override
    public void flightModify(Flight flight) {
        FlightDaoImp flightDaoImp = (FlightDaoImp) ObjectFactory.getObject("FlightDaoImp");
        flightDaoImp.flightModify(flight);
    }

    @Override
    public void flightDelete(Flight flight) {
        FlightDaoImp flightDaoImp = (FlightDaoImp) ObjectFactory.getObject("FlightDaoImp");
        flightDaoImp.flightDelete(flight);
    }

    @Override
    public List<Flight> queryAll() {
        FlightDaoImp flightDaoImp = (FlightDaoImp) ObjectFactory.getObject("FlightDaoImp");
        return (List<Flight>) flightDaoImp.queryAll();
    }

    @Override
    public List<Flight> queryAll(Flight flight) {
        FlightDaoImp flightDaoImp = (FlightDaoImp) ObjectFactory.getObject("FlightDaoImp");
        return (List<Flight>) flightDaoImp.queryAll(flight);
    }

    @Override
    public void flightTikectsChange(String flightId, int det) {
        FlightDaoImp flightDaoImp = (FlightDaoImp) ObjectFactory.getObject("FlightDaoImp");
        flightDaoImp.flightTikectsChange(flightId, det);
    }
}
