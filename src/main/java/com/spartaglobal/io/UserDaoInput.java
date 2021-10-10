package com.spartaglobal.io;

import com.spartaglobal.control.DataSetValidator;
import org.apache.log4j.Logger;
import java.util.Scanner;

public class UserDaoInput implements DaoInputInterface{

    private static final Logger log = Logger.getLogger("User Dao Input logger.");

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
        System.out.print("""
                What would you like to do?\s
                 1. Get all employee records.\s
                 2. Get employee record via ID.\s
                 3. Insert employee record into table.\s
                 4. Update employee record via ID.\s
                 5. Delete employee record via ID.\s
                 6. Exit the program.\s
                 :\s""");
        String input = scanner.nextLine();
        switch (input) {
            case "1" -> this.task = "GetAll";
            case "2" -> {
                this.task = "Get";
                getWhereQ();
            }
            case "3" -> {
                this.task = "Insert";
                getWhatQ();
            }
            case "4" -> {
                this.task = "Update";
                getWhatQ();
                getWhereQ();
            }
            case "5" -> {
                this.task = "Delete";
                getWhereQ();
            }
            case "6" -> {
                System.out.println(" \n Bye...");
                System.exit(0);
            }
            default -> {
                System.out.println("\n Enter a valid input! \n ");
                log.warn("User did not enter a valid input.");
                getTaskQ();
            }
        }
    }

    public void getWhatQ(){
        Scanner scanner = new Scanner(System.in);
        switch (this.task) {
            case ("Insert") -> {
                System.out.print("Input employee record in the order: Employee_ID, Title, First_Name, Middle_Initial, Last_Name, Gender, Email, Birth_Date, Join_Date, Salary. \n : ");
                String data = scanner.nextLine();
                if (DataSetValidator.isDataValid(data)) {
                    System.err.println("Data is not valid! Please try again...");
                    log.error("The data the user entered is not valid.");
                    getWhatQ();
                }
                this.what = data;
            }
            case ("Update") -> {
                System.out.print("Input columns to be updated and with what values separated with a comma(,). E.g. Last_Name = 'Lux', Gender = 'M'. \n : ");
                this.what = scanner.nextLine();
            }
        }
    }

    public void getWhereQ(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the ID number of the employee : ");
        String data = scanner.nextLine();
        if (!(Integer.parseInt(data) > 0)){
            System.err.println("Data is not valid! Please try again...");
            log.error("The data the user entered is not valid.");
            getWhatQ();
        }
        this.where = data;
        }

    }


