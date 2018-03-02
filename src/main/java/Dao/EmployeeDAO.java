package Dao;

import entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    void add(Employee employee);

    List<Employee> getAll();

    Employee getById(Long id);

    void update(Employee employee);

    void remove (Employee employee);
}
