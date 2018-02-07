package com.fluentWait.controller;

import com.fluentWait.beans.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Fluent Wait on 11/20/2016.
 */
@Controller
@RequestMapping("/employee")
public class EmployeeController {

    static List<Employee> employees = new ArrayList<>();

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    @ResponseBody
    public List<Employee> getAllEmployee() {
        // return employeeService.getAllEmployee();
        return employees;
    }

    @ResponseBody
    @RequestMapping(value = "/getEmployee", method = RequestMethod.GET)
    public Employee getEmployee() {
        return new Employee(100, "Alex", "Smith", "New York", "333-444-7272");
    }


    @ResponseBody
    @RequestMapping(value = "/getEmployee/{employeeId}", method = RequestMethod.GET)
    public Employee getEmployee(@PathVariable("employeeId") int employeeId) {
        switch (employeeId) {
            case 100:
                return new Employee(100, "Alex", "Smith", "New York", "333-444-7272");
            default:
                return new Employee(000, "Fluent", "Wait", "New York", "223-444-7272");
        }
    }

    @ResponseBody
    @RequestMapping(value = "/getEmployeeQuery", method = RequestMethod.GET)
    public Employee getEmployeeQuery(@RequestParam("employeeId") int employeeId) {
        switch (employeeId) {
            case 100:
                return new Employee(100, "Alex", "Smith", "New York", "333-444-7272");
            default:
                return new Employee(000, "Fluent", "Wait", "New York", "223-444-7272");
        }
    }


    @RequestMapping(value = "/addEmployee", method = RequestMethod.POST)
    public void addEmployee(@RequestBody Employee employee) {
        employees.add(employee);
    }

    @RequestMapping(value = "/addName", method = RequestMethod.POST, params = "name")
    public void addEmployeeName(@RequestBody String name) {
        employees.add(new Employee(100, name, "fasas", "1wqw", "asa"));
    }
}
