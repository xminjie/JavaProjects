package service.serviceProxy;


import dao.FlightDaoImp;
import entity.Flight;
import factory.ObjectFactory;
import service.FlightService;
import service.serviceImp.FlightServiceImp;

import java.util.List;

public class FlightServiceProxyImp implements FlightService {

    @Override
    public Flight flightAdd(Flight flight) {
        FlightServiceImp flightServiceImp = (FlightServiceImp) ObjectFactory.getObject("FlightServiceImp");
        return flightServiceImp.flightAdd(flight);
    }

    @Override
    public void flightModify(Flight flight) {
        FlightServiceImp flightServiceImp = (FlightServiceImp) ObjectFactory.getObject("FlightServiceImp");
        flightServiceImp.flightModify(flight);
    }

    @Override
    public void flightDelete(Flight flight) {
        FlightServiceImp flightServiceImp = (FlightServiceImp) ObjectFactory.getObject("FlightServiceImp");
        flightServiceImp.flightDelete(flight);
    }

    @Override
    public List<Flight> queryAll() {

        FlightServiceImp flightServiceImp = (FlightServiceImp) ObjectFactory.getObject("FlightServiceImp");
        return (List<Flight>) flightServiceImp.queryAll();


    }

    @Override
    public List<Flight> queryAll(Flight flight) {
        FlightServiceImp flightServiceImp = (FlightServiceImp) ObjectFactory.getObject("FlightServiceImp");
        return (List<Flight>) flightServiceImp.queryAll(flight);

    }

    @Override
    public void flightTikectsChange(String flightId, int det) {
        FlightServiceImp flightServiceImp = (FlightServiceImp) ObjectFactory.getObject("FlightServiceImp");
        flightServiceImp.flightTikectsChange(flightId, det);
    }

    public static void main(String[] args) {
//        Flight f = new Flight("Bo看s df","杭州","北京",
//                "2018-10-01",50,100,(float)50.82);
//        FlightServiceProxyImp flightServiceProxyImp = (FlightServiceProxyImp) ObjectFactory.getObject("FlightServiceProxyImp");
//
//        if((flightServiceProxyImp.flightAdd(f)) == null) {
//            System.out.println("添加航班不能重复");
//        }else{
//            System.out.println("添加航班成功");
//        }
        Flight flight = new Flight();
        flight.setFlightId("");
        flight.setBeginAddress("南京");
        flight.setEndAddress("");
        List<Flight> list = new FlightDaoImp().queryAll(flight);
        for (Flight f : list) {
            System.out.println(f.toString());
        }


    }

}
