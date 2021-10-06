package com.spartaglobal.model;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Employees {

    private Integer employeeID;
    private String namePrefix;
    private String firstName;
    private Character middleInitial;
    private String lastName;
    private Character gender;
    private String email;
    private Date dateOfBirth;
    private Date dateOfJoining;
    private Integer salary;

    public Employees() {
    }

    public Employees(Integer employeeID, String namePrefix, String firstName, Character middleInitial, String lastName, Character gender,
                     String email, Date dateOfBirth, Date dateOfJoining, Integer salary) {
        this.employeeID = employeeID;
        this.namePrefix = namePrefix;
        this.firstName = firstName;
        this.middleInitial = middleInitial;
        this.lastName = lastName;
        this.gender = gender;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.dateOfJoining = dateOfJoining;
        this.salary = salary;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public String getNamePrefix() {
        return namePrefix;
    }

    public void setNamePrefix(String namePrefix) {
        this.namePrefix = namePrefix;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public char getMiddleInitial() {
        return middleInitial;
    }

    public void setMiddleInitial(char middleInitial) {
        this.middleInitial = middleInitial;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Date getDateOfJoining() {
        return dateOfJoining;
    }

    public void setDateOfJoining(Date dateOfJoining) {
        this.dateOfJoining = dateOfJoining;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employees { '\n'" +
                "employeeID = " + employeeID +
                ", namePrefix = '" + namePrefix + '\'' +
                ", firstName = '" + firstName + '\'' +
                ", middleInitial = " + middleInitial +
                ", lastName = '" + lastName + '\'' +
                ", gender = " + gender +
                ", email = '" + email + '\'' +
                ", dateOfBirth = " + dateOfBirth +
                ", dateOfJoining = " + dateOfJoining +
                ", salary = " + salary +
                '}';
    }
}
