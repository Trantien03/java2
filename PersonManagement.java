package com.Person;

import com.Person.model.Person;
import com.Person.util.DBUtil;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class PersonManagement {
    public void addnewPerson(Person person) throws Exception{
        try {
            Connection conn = com.Person.util.DBUtil.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(
                    "INSERT INTO Person(Name, Email,Address,Phone) VALUES (?,?,?,?)");
            pstmt.setString(1,person.getName());
            pstmt.setString(2,person.getEmail());
            pstmt.setString(3,person.getAddress());
            pstmt.setString(4,person.getPhone());

            int updated = pstmt.executeUpdate();
            if(updated > 0) {
                System.out.println("Insert Person success!!!");
            }

            pstmt.close();
            conn.close();
        }catch(Exception e){
            throw new Exception(e.getMessage());
        }
    }
    public void getAllPerson() throws Exception{
        try {
            Connection conn = DBUtil.getConnection();
            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT Id, Name, Email, Address, Phone FROM Person");

            while(rs.next()) {
                Person pr = new Person(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5)
                );

                System.out.println(pr.toString());
            }

            rs.close();
            stmt.close();
            conn.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public Person getPersonById(int id) throws Exception {

        Person pr = null;

        try {
            Connection conn =  DBUtil.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(
                    "SELECT Id, Name, Email, Address,Phone FROM Person WHERE Id = ?");
            pstmt.setInt(1, id);

            ResultSet rs = pstmt.executeQuery();
            if(rs.next()) {
                pr = new Person(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5)
                );
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        return pr;
    }

    public void updatePerson(int id) throws Exception {
        try {

            Person updatingPerson = this.getPersonById(id);
            if(updatingPerson != null) {
                //input new data of Person
                updatingPerson.inputData();
                // UPDATE Person into Database

                Connection conn =  DBUtil.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(
                        "UPDATE Person SET Name = ?, Email = ?, Address = ?,Phone= ? WHERE Id = ?");
                pstmt.setString(1, updatingPerson.getName());
                pstmt.setString(2, updatingPerson.getEmail());
                pstmt.setString(3, updatingPerson.getAddress());
                pstmt.setString(4, updatingPerson.getPhone());
                pstmt.setInt(5, updatingPerson.getId());

                int updated = pstmt.executeUpdate();
                if(updated > 0) {
                    System.out.println("Update Person success!!!");
                }

                pstmt.close();
                conn.close();
            } else  {
                System.out.println("Person not found");
            }

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }


    public void deletePerson(int id) throws Exception {
        try {
            Connection conn =  DBUtil.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(
                    "DELETE from Person WHERE Id=?");
            pstmt.setInt(1, id);

            int updated = pstmt.executeUpdate();
            if(updated > 0) {
                System.out.println("Delete Person success!!!");
            }

            pstmt.close();
            conn.close();

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
