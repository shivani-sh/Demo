package com.decipherzone;

import com.decipherzone.config.DBconfig;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;


/**
 * create a connection
 */

public class DbOperation {
    private BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private PreparedStatement statement = null;

    /**
     * create table and  insert getConnection in table
     *
     * @throws SQLException
     */

    public void insertdata() {

        Scanner sc = new Scanner(System.in);

        try {
            DBconfig dBconfig = new DBconfig();
            Connection connection = dBconfig.getConnection();
            System.out.println(connection);
            Statement statement = connection.createStatement();
            //statement.connection.createStatement();
            //String n = null;
            System.out.println("Enter student  id");
            int stu_id = sc.nextInt();

            System.out.println("Enter name name");
            String stu_name = sc.next();
            System.out.println("Enter student age");
            String stu_age = sc.next();
            System.out.println("insert into student_data(id,name,age)" +
                    " values(" + stu_id + "," + "'" + stu_name + "'," + stu_age + ");");
            int count = statement.executeUpdate(String.format("insert into STUDENT_DATA(id,name,age)" +
                    " values(" + stu_id + "," + "'" + stu_name + "'," + stu_age + ");"));

            System.out.println(count + " row inserted");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * in this we show our student record
     */

    public void showdata() {
        Connection conn = null;
        Connection connection = DBconfig.getConnection();
        Scanner sc = new Scanner(System.in);
        try {
            PreparedStatement statement = null;

            DBconfig dBconfig = new DBconfig();
            //Connection  connection1=dBconfig.getConnection();
            // Statement statement = connection.createStatement();
            Statement st = connection.createStatement();
            String n = null;//tableName = null;


            ResultSet rs = st.executeQuery("select * from STUDENT_DATA");
            System.out.println("STUDENT DATA");
            while (rs.next()) {
                System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3));
            }
            n = sc.next();

        } catch (SQLException e) {

            e.printStackTrace();
        }

    }

    /**
     * In this method we delete our student getConnection
     */
    public void deletedata() {
        Connection conn = null;

        Scanner sc = new Scanner(System.in);
        try {

            DBconfig dBconfig = new DBconfig();
            Connection connection = dBconfig.getConnection();
            Statement statement = connection.createStatement();

            String n = null;
            int id = 0;


            System.out.println("Enter the id you want to delete");
            id = sc.nextInt();
            int count = statement.executeUpdate(String.format("DELETE FROM STUDENT_DATA where id=" + id + ";"));

            System.out.println(count + " record deleted");
            n = sc.next();

        } catch (SQLException e) {

            e.printStackTrace();
        }

    }

    /**
     * In this we display record by id
     */
    public void displaybyid() {
        //Connection conn = null;

        Scanner sc = new Scanner(System.in);
        try {

            DBconfig dBconfig = new DBconfig();
            Connection connection = dBconfig.getConnection();

            Statement st = connection.createStatement();


            int id = 0;


            System.out.println("Enter the id you want to show record");
            id = sc.nextInt();


            //System.out.println("heloo");
            ResultSet rs = st.executeQuery(String.format("SELECT * FROM STUDENT_DATA where id=" + id + ";"));
            while (rs.next()) {
                System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    /**
     * In this we update getConnection
     *
     * @return
     */
    public boolean updatedata() {

        String name = null;
        int age = 32;
        int count = 0;
        int id = 0;

        DBconfig dBconfig = new DBconfig();
        Connection connection = dBconfig.getConnection();
        System.out.println("enter the name ");
        try {
            name = bufferedReader.readLine();

            System.out.println("enter the age");
            age = Integer.parseInt(bufferedReader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {

            statement = connection.prepareStatement("update  student set name=? ,age=? where id =?");
            System.out.println("stt");
            statement.setString(1, name);
            statement.setInt(2, age);
            statement.setInt(3, id);
            count = statement.executeUpdate();
            System.out.println("stt");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (count > 0) {
            return true;
        }

        return false;
    }


}









