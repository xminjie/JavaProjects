package dao;

import entity.Flight;
import util.FlightRowMap;
import util.JDBCTemp;

import java.util.ArrayList;
import java.util.List;

public class FlightDaoImp implements FlightDao {
    private JDBCTemp jt;

    {
        jt = new JDBCTemp();
    }


    @Override
    public Flight flightAdd(Flight flight) {
        if (flightAddCheck(flight) == null) {
            String sql = "insert into flight values "
                    + "(?, ? ,? ,? ,? ,?, ?)";
            jt.update(sql,
                    flight.getFlightId(),
                    flight.getBeginAddress(),
                    flight.getEndAddress(),
                    flight.getBeginTime(),
                    flight.getTime(),
                    flight.getAvailableTickets(),
                    flight.getPrice());
            return flight;
        } else {
            return null;
        }
    }

    @Override
    public Flight flightAddCheck(Flight flight) {
        String sql = "select * from flight where flightId=?";
        List list = jt.Query(sql, new FlightRowMap(), flight.getFlightId());
        if (list.size() == 0) {
            return null;
        } else {
            return (Flight) list.get(0);
        }
    }

    @Override
    public void flightModify(Flight flight) {
        String sql = "update flight set beginAddress=? " +
                ",endAddress=? , beginTime=? ,time= ?, " +
                "avaliableTikects=?, price= ? where flightId=?";
        jt.update(sql
                , flight.getBeginAddress()
                , flight.getEndAddress()
                , flight.getBeginTime()
                , flight.getTime()
                , flight.getAvailableTickets()
                , flight.getPrice()
                , flight.getFlightId());
    }

    @Override
    public void flightDelete(Flight flight) {
        String sql = "delete from flight where flightId=? ";
        jt.update(sql, flight.getFlightId());
    }

    @Override
    public void flightTikectsChange(String flightId, int det) {
        String sql = "update flight set avaliableTikects = avaliableTikects + ? " +
                " where flightId = ?";
        jt.update(sql,det,flightId);
    }

    @Override
    public List<Flight> queryAll() {
        String sql = "select * from flight";
        return (List<Flight>) jt.Query(sql, new FlightRowMap());
    }

    @Override
    public List<Flight> queryAll(Flight flight) {
        String sql = "select * from flight where 1 = 1 ";
        List<String> params = new ArrayList<>();
        if (!"".equals(flight.getFlightId())) {
            sql = sql + " and flightId like ? ";
            params.add("%" + flight.getFlightId() + "%");
        }
        if (!"".equals(flight.getBeginAddress())) {
            sql = sql + " and beginAddress like ?  ";
            params.add("%" + flight.getBeginAddress() + "%");
        }
        if (!"".equals(flight.getEndAddress())) {
            sql = sql + "and  endAddress like ?  ";
            params.add("%" + flight.getEndAddress() + "%");
        }

        return (List<Flight>) jt.Query(sql, new FlightRowMap(), params.toArray());
    }

    public static void main(String[] args) {
//        Flight f = new Flight("NjhH312ddfd3","徐州","北京",
//                "2018-10-01",50,100,(float)50.82);
//        if(new FlightDaoImp().flightAdd(f) == null) {
//            System.out.println("添加航班不能重复");
//        }else{
//            System.out.println("添加航班成功");
//        }
        Flight flight = new Flight();
        flight.setFlightId("MH567");
        flight.setBeginAddress("dfsd");
        flight.setEndAddress("");
//        List<Flight> list = new FlightDaoImp().queryAll(flight);
//        for (Flight f : list) {
//            System.out.println(f.toString());
//        }
        new FlightDaoImp().flightTikectsChange("BH111",1);

    }
}
