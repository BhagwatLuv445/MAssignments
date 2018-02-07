package com.fluentWait.service;

import com.fluentWait.beans.Train;

import java.util.List;


public interface TrainService {
    public List<Train> getAllTrains();

    public Train getTrainById(Long id);

    public void addTrain(Train train);

    public void deleteTrainById(Long id);

    public void deleteAll();

    public void updateTrain(Train train);
}
