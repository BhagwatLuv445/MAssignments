package com.fluentWait.service;

import com.fluentWait.beans.Employee;

import java.util.List;

/**
 * Created by Fluent Wait on 11/20/2016.
 */
public interface EmployeeService {

    Employee getEmployee();

    List<Employee> getAllEmployee();


}
