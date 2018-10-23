package com.decipherzone;

import com.decipherzone.config.DBconfig;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.InputMismatchException;

import static java.lang.System.out;

/**
 * main class
 */
public class Main {


    private static final String DB_URL = "jdbc:mysql://localhost/getConnection";

    /**
     * In this we call all the method
     */

    public static void main(String[] args) {
        int id = 0;
        int x = 0;
        Main thisobj=new Main();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        DbOperation dbOperation = new DbOperation();
        DBconfig dBconfig = new DBconfig();
        try {
            do {
                out.println("Enter 1:Insert getConnection\n" + "Enter 2:Show getConnection\n" + "Enter 3:Delete getConnection\n" + "Enter:4 Display by id\n" + "Enter:5 Update getConnection\n" + "Enter:6 exit");
                out.println("Enter your choice:");
                try {
                    int ch = 0;
                    try {
                        ch = Integer.parseInt(bufferedReader.readLine());
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    x = ch;
                } catch (InputMismatchException e) {
                    e.printStackTrace();
                }

                if (x == 1) {
                    dbOperation.insertdata();
                    dBconfig.hashCode();
                } else if (x == 2) {
                    dbOperation.showdata();

                } else if (x == 3) {
                    dbOperation.deletedata();
                } else if (x == 4) {
                    dbOperation.displaybyid();
                } else if (x == 5) {
                    dbOperation.updatedata();
                } else if (x == 6) {
                    System.exit(0);

                } else {
                    System.out.println("wrong input");
                }
            }

            while (x != 7);

        } catch (Exception e) {
            e.printStackTrace();
        }
        Main thisObj = new Main();

    }




}





