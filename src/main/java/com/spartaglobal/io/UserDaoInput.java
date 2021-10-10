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

    public String getWhat(){
        return this.what;
    }

    public String getWhere(){
        return this.where;
    }


    public void getTaskQ(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("What would you like to do? \n " +
                "1. Get all employee records. \n " +
                "2. Get employee record via ID. \n " +
                "3. Insert employee record into table. \n " +
                "4. Update employee record via ID. \n " +
                "5. Delete employee record via ID. \n " +
                "6. Exit the program. \n " +
                ": ");
        String input = scanner.nextLine();
        switch (input){
            case "1":
               this.task = "GetAll";
               break;
            case "2":
                this.task = "Get";
                getWhereQ();
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
            case "6":
                System.out.println(" \n Bye...");
                System.exit(0);
            default:
                System.out.println("\n Enter a valid input! \n ");

                getTaskQ();
                break;
        }
    }

    public void getWhatQ(){
        Scanner scanner = new Scanner(System.in);
        switch (this.task){
            case ("Insert"):
                System.out.print("Input employee record in the order: Employee_ID, Title, First_Name, Middle_Initial, Last_Name, Gender, Email, Birth_Date, Join_Date, Salary. \n : ");
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

    public void getWhereQ(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the ID number of the employee : ");
        String data = scanner.nextLine();
        if (!(Integer.valueOf(data) > 0)){
            System.err.println("Data is not valid! Please try again...");
            getWhatQ();
        }
        this.where = data;
        }




    }


