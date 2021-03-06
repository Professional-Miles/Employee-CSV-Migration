package com.spartaglobal.model;

import java.sql.Date;
import java.util.Objects;

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

    public Employees(Integer employeeID){
        this.employeeID = employeeID;
    }

    public Integer getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(Integer employeeID) {
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

    public Character getMiddleInitial() {
        return middleInitial;
    }

    public void setMiddleInitial(Character middleInitial) {
        this.middleInitial = middleInitial;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Character getGender() {
        return gender;
    }

    public void setGender(Character gender) {
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

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeID);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o == null || o.getClass() != this.getClass()) {
            return false;
        }
        return Objects.equals(employeeID, ((Employees) o).employeeID);
    }

    @Override
    public String toString() {
        return "EmployeeID = " + employeeID +
                ", namePrefix = '" + namePrefix + '\'' +
                ", firstName = '" + firstName + '\'' +
                ", middleInitial = " + middleInitial +
                ", lastName = '" + lastName + '\'' +
                ", gender = " + gender +
                ", email = '" + email + '\'' +
                ", dateOfBirth = " + dateOfBirth +
                ", dateOfJoining = " + dateOfJoining +
                ", salary = " + salary + "\n";
    }
}
