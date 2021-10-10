package com.spartaglobal.io;

import com.spartaglobal.control.DataSetValidator;

import java.util.Scanner;

public class UserDaoInput {

    private String task;
    private String what;
    private String where;
    private static UserDaoInput getInstanceUser = null;

    public static UserDaoInput getInstance(){
        if (getInstanceUser == null){
            getInstanceUser = new UserDaoInput();
        }
        return getInstanceUser;
    }

    public String getTask(){
        return this.task;
    }


    public void getTaskQ(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("What would you like to do? \n " +
                "1. Get all employee records. \n " +
                "2. Get employee record via ID. \n " +
                "3. Insert employee record into table. \n " +
                "4. Update employee record via ID. \n " +
                "5. Delete employee record via ID. \n " +
                ": ");
        String input = scanner.nextLine();
        switch (input){
            case "1":
               this.task = "GetAll";
               break;
            case "2":
                this.task = "Get";

                break;
            case "3":
                this.task = "Insert";
                getWhatQ();
                break;
            case "4":
                this.task = "Update";
                getWhatQ();
                break;
            case "5":
                this.task = "Delete";

                break;
            default:
                System.err.println("Enter a valid input!");
                getTaskQ();
                break;
        }
    }

    public void getWhatQ(){
        Scanner scanner = new Scanner(System.in);
        switch (this.task){
            case ("Insert"):
                System.out.println("Input employee record in the order: Employee_ID, Title, First_Name, Middle_Initial, Last_Name, Gender, Email, Birth_Date, Join_Date, Salary .");
                String data = scanner.nextLine();
                if (!DataSetValidator.isDataValid(data)){
                    System.err.println("Data is not valid! Please try again...");
                    getWhatQ();
                }
                this.what = data;
                break;
            case ("Update"):

                break;
        }
    }

    public  void getWhereQ(){
        Scanner scanner = new Scanner(System.in);
        switch (this.task){
            case ("Insert"):

                break;
            case ("Update"):

                break;
        }
    }





}
