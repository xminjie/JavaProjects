package service.serviceImp;

import dao.RecorderDaoImp;
import entity.RecorderMore;
import factory.ObjectFactory;
import service.RecorderService;

import java.util.List;

public class RecorderServiceImp implements RecorderService {
    @Override
    public void book(String flightID) {
        RecorderDaoImp recorderDaoImp = (RecorderDaoImp) ObjectFactory.getObject("RecorderDaoImp");
        recorderDaoImp.book(flightID);
    }

    @Override
    public void change(String recorderId, String flightNewId) {
        RecorderDaoImp recorderDaoImp = (RecorderDaoImp) ObjectFactory.getObject("RecorderDaoImp");
        recorderDaoImp.change(recorderId, flightNewId);
    }

    @Override
    public void back(String recorderId) {
        RecorderDaoImp recorderDaoImp = (RecorderDaoImp) ObjectFactory.getObject("RecorderDaoImp");
        recorderDaoImp.back(recorderId);
    }

    @Override
    public List<RecorderMore> query() {
        RecorderDaoImp recorderDaoImp = (RecorderDaoImp) ObjectFactory.getObject("RecorderDaoImp");
        return recorderDaoImp.query();
    }
}
