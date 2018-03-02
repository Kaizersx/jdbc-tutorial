package Dao;

import java.util.List;

public interface EmplProj {
    //create
    void add(EmplProj emplProj);

    //read
    List<EmplProj> getAll();

    EmplProj getByEmployeeAndProjecID(Long employeeID, Long projectID);

    //read
    void update(EmplProj emplProj);

    //delete
    void remove (EmplProj emplProj);
}
