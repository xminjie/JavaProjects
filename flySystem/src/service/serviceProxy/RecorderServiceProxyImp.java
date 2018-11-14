package service.serviceProxy;

import entity.RecorderMore;
import factory.ObjectFactory;
import service.RecorderService;
import service.serviceImp.RecorderServiceImp;

import java.util.List;

public class RecorderServiceProxyImp implements RecorderService {
    @Override
    public void book(String flightID) {
        RecorderServiceImp recorderServiceImp = (RecorderServiceImp) ObjectFactory.getObject("RecorderServiceImp");
        recorderServiceImp.book(flightID);
    }

    @Override
    public void change(String recorderId, String flightNewId) {
        RecorderServiceImp recorderServiceImp = (RecorderServiceImp) ObjectFactory.getObject("RecorderServiceImp");
        recorderServiceImp.change(recorderId, flightNewId);
    }

    @Override
    public void back(String recorderId) {
        RecorderServiceImp recorderServiceImp = (RecorderServiceImp) ObjectFactory.getObject("RecorderServiceImp");
        recorderServiceImp.back(recorderId);
    }

    @Override
    public List<RecorderMore> query() {
        RecorderServiceImp recorderServiceImp = (RecorderServiceImp) ObjectFactory.getObject("RecorderServiceImp");
        return recorderServiceImp.query();
    }
}
