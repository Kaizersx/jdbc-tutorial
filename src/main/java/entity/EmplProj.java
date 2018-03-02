package entity;

import java.util.Objects;

public class EmplProj {


    private Long employeeID;
    private Long projectID;


    public Long getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(Long employeeID) {
        this.employeeID = employeeID;
    }

    public Long getProjectID() {
        return projectID;
    }

    public void setProjectID(Long projectID) {
        this.projectID = projectID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmplProj emplProj = (EmplProj) o;
        return Objects.equals(employeeID, emplProj.employeeID) &&
                Objects.equals(projectID, emplProj.projectID);
    }

    @Override
    public int hashCode() {

        return Objects.hash(employeeID, projectID);
    }

    @Override
    public String toString() {
        return "EmplProj{" +
                "employeeID=" + employeeID +
                ", projectID=" + projectID +
                '}';
    }
}
