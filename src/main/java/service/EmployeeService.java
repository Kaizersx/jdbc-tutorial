package service;

import BuissnesLogic.Util;
import Dao.EmployeeDAO;
import entity.Address;
import entity.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeService extends Util implements EmployeeDAO {

    Connection connection=getConnection();

    @Override
    public void add(Employee employee) throws SQLException {
        PreparedStatement preparedStatement=null;

        String sql="INSERT INTO ADDRESS (ID,firstname,lastname,birthday,addressID) VALUES (?,?,?,?,?)";

        try{
            preparedStatement=connection.prepareStatement(sql);

            preparedStatement.setLong(1,employee.getId());
            preparedStatement.setString(2,employee.getFirstname());
            preparedStatement.setString(3,employee.getLastname());
            preparedStatement.setDate(4,employee.getBirthday());
            preparedStatement.setLong(5,employee.getAddressID());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            if (preparedStatement !=null)
            {
                preparedStatement.close();
            }
            if (connection!=null){
                connection.close();
            }
        }
    }

    @Override
    public List<Employee> getAll() throws SQLException {
        List<Employee> employeeList=new ArrayList<>();

        String sql="SELECT ID,firstname,lastname,birthday,addressID FROM EMPLOYEE";

        Statement statement=null;
        try{
            ResultSet resultSet=statement.executeQuery(sql);

            while (resultSet.next()) {
                Employee employee = new Employee();

                employee.setId(resultSet.getLong("ID"));
                employee.setFirstname(resultSet.getString("firstname"));
                employee.setLastname(resultSet.getString("lastname"));
                employee.setBirthday(resultSet.getDate("birthday"));
                employee.setAddressID(resultSet.getLong("addressIDE"));

                employeeList.add(employee);
            }
        }
        catch (SQLException e){e.printStackTrace();}
        finally {
            if (statement != null) {
                statement.close();
            }
            if(connection!=null){
                connection.close();
            }
        }
        return employeeList;
    }

    @Override
    public Employee getById(Long id) throws SQLException {

        PreparedStatement preparedStatement=null;

        String sql="SELECT ID,firstname,lastname,birthday,addressID FROM EMPLOYEE WHERE ID=?";

        Employee employee= new Employee();

        try{
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setLong(1,id);

            ResultSet resultSet =preparedStatement.executeQuery();

            employee.setId(resultSet.getLong("ID"));
            employee.setFirstname(resultSet.getString("firstname"));
            employee.setLastname(resultSet.getString("lastname"));
            employee.setBirthday(resultSet.getDate("birthday"));
            employee.setAddressID(resultSet.getLong("addressID"));

            preparedStatement.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            if(preparedStatement!=null){preparedStatement.close(); }
            if(connection!=null){connection.close();}
        }
        return employee;
    }

    @Override
    public void update(Employee employee) throws SQLException {

        PreparedStatement preparedStatement=null;

        String sql="UPDATE  EMPLOYEE SET firstname=?, lastname=?, birthday=?, addressID=? WHERE ID=? ";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1,employee.getFirstname());
            preparedStatement.setString(2,employee.getLastname());
            preparedStatement.setDate(3,employee.getBirthday());
            preparedStatement.setLong(4,employee.getAddressID());
            preparedStatement.setLong(5,employee.getId());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        finally {
            if (preparedStatement!=null){preparedStatement.close();}

            if (connection!=null){connection.close();}
        }
    }

    @Override
    public void remove(Employee employee) throws SQLException {

        PreparedStatement preparedStatement=null;

        String sql="DELETE FROM EMPLOYEE  WHERE ID=? ";

        try{

            preparedStatement=connection.prepareStatement(sql);

            preparedStatement.setLong(1,employee.getId());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally{
            if (preparedStatement!=null){preparedStatement.close();}
            if (connection!=null){ connection.close();}
        }
    }
}
