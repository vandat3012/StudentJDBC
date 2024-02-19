package com.example.student.model.service;

import com.example.student.model.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentServiceJDBC implements IStudentService{

    protected  Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student",
                    "root",
                    "123456");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }
    @Override
    public List<Student> findAll() {
        List<Student> studentList = new ArrayList<>();
        Connection connection = getConnection();
        try {
            PreparedStatement getAllQuery = connection.prepareStatement("select * from student;");
            ResultSet resultSet = getAllQuery.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email= resultSet.getString("email");
                String address = resultSet.getString("address");
                Student student = new Student(id,name,email,address);
                studentList.add(student);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return studentList;
    }

    @Override
    public void save(Student student) {
        Connection connection = getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into student (name,email,address) values  (?,?,?)");
            preparedStatement.setString(1,student.getName());
            preparedStatement.setString(2,student.getEmail());
            preparedStatement.setString(3,student.getAddress());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
