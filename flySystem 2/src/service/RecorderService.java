package service;

import entity.RecorderMore;

import java.util.List;

public interface RecorderService {
    void book(String flightID);
    void change(String recorderId, String flightNewId);
    void back(String recorderId);
    List<RecorderMore> query();
}
