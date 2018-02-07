package com.fluentWait.controller;

import com.fluentWait.beans.Train;
import com.fluentWait.service.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/trains")
public class TrainController {

    @Autowired
    private TrainService trainService;

    @RequestMapping("trainslist.json")
    public @ResponseBody List<Train> getTrainList() {
        return trainService.getAllTrains();
    }

    @RequestMapping(value = "/addTrain", method = RequestMethod.POST)
    public @ResponseBody void addTrain(@RequestBody Train train) {
        trainService.addTrain(train);
    }

    @RequestMapping(value = "/updateTrain", method = RequestMethod.PUT)
    public @ResponseBody void updateTrain(@RequestBody Train train) {
        trainService.updateTrain(train);
    }

    @RequestMapping(value = "/removeTrain/{id}", method = RequestMethod.DELETE)
    public @ResponseBody void removeTrain(@PathVariable("id") Long id) {
        trainService.deleteTrainById(id);
    }

    @RequestMapping(value = "/removeAllTrains", method = RequestMethod.DELETE)
    public @ResponseBody void removeAllTrains() {
        trainService.deleteAll();
    }

    @RequestMapping("/layout")
    public String getTrainPartialPage(ModelMap modelMap) {
        return "trains/layout";
    }
}
