package util;

import entity.RecorderMore;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RecorderMoreRowMap implements  RowMap {
    @Override
    public Object getRowmap(ResultSet res) {
        RecorderMore recorderMore = new RecorderMore();
        try {
            recorderMore.setRecorderId(Integer.parseInt(res.getString("recorderId").toString()));
            recorderMore.setFlightId(res.getString("flightId").toString());
            recorderMore.setAccount(res.getString("account").toString());

            recorderMore.setBeginAddress(res.getString("beginAddress").toString());
            recorderMore.setEndAddress(res.getString("endAddress").toString());
            recorderMore.setBeginTime(res.getString("beginTime").toString());
            recorderMore.setTime(Integer.parseInt(res.getString("time").toString()));
            recorderMore.setPrice(Float.parseFloat(res.getString("price").toString()));

            recorderMore.setStatus1(res.getString("status1"));
            recorderMore.setStatus2(res.getString("status2"));
            recorderMore.setStatus3(res.getString("status3"));

            return recorderMore;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
