package com.fluentWait.service;

import com.fluentWait.beans.Train;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service("trainService")
public class TrainServiceImpl implements TrainService {
    private static List<Train> trainList = new ArrayList<Train>();
    private static Long id = 0L;

    @Override
    public List<Train> getAllTrains() {
        return trainList;
    }

    @Override
    public Train getTrainById(Long id) {
        return findTrainById(id);
    }

    @Override
    public void addTrain(Train train) {
        train.setId(++id);
        trainList.add(train);
    }

    @Override
    public void deleteTrainById(Long id) {
        Train foundTrain = findTrainById(id);
        if (foundTrain != null) {
            trainList.remove(foundTrain);
            id--;
        }
    }

    @Override
    public void deleteAll() {
        trainList.clear();
        id = 0L;
    }

    @Override
    public void updateTrain(Train train) {
        Train foundTrain = findTrainById(train.getId());
        if (foundTrain != null) {
            trainList.remove(foundTrain);
            trainList.add(train);
        }
    }

    private Train findTrainById(Long id) {
        for (Train train : trainList) {
            if (train.getId() == id) {
                return train;
            }
        }

        return null;
    }
}
