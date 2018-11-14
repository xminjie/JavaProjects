package dao;

import action.Who;
import entity.RecorderMore;
import entity.User;
import util.JDBCTemp;
import util.RecorderMoreRowMap;

import java.util.List;

public class RecorderDaoImp implements RecorderDao {
    JDBCTemp jt = new JDBCTemp();

    @Override
    public void book(String flightID) {
        String sql = "insert into Recorder (flightId,account,status1,status2,status3) " +
                "values(?,?,?,?,?) ";
        jt.update(sql, flightID, Who.user.getAccount(), flightID, "", "");
    }

    @Override
    public void change(String recorderId, String flightNewId) {
        String sql = "update recorder set" +
                " flightID = ?," +
                " status2 = ? " +
                " where recorderId = ?";
        jt.update(sql, flightNewId, flightNewId, recorderId);
    }

    @Override
    public void back(String recorderId) {
        String sql = "update recorder set" +
                " status3 = ? " +
                " where recorderId = ?";
        jt.update(sql, "已退票", recorderId);
    }

    @Override
    public List<RecorderMore> query() {
        String sql = "select recorderId, recorder.flightId as flightId, account ,beginAddress,endAddress," +
                "beginTime,time,price, status1,status2,status3 " +
                "from recorder,flight " +
                "where account = ? and recorder.flightId = flight.flightId";

        List<RecorderMore> list;
        list = jt.Query(sql,new RecorderMoreRowMap(),Who.user.getAccount());

        return list;
    }


    public static void main(String[] args) {
        Who.user = new User();
        Who.user.setAccount("aaa");
//        new RecorderDaoImp().book("BH1818");
//        new RecorderDaoImp().change("1","BH1819");
//        new RecorderDaoImp().back("1");
        new RecorderDaoImp().query();
    }
}
