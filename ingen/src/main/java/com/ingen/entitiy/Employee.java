package com.ingen.entitiy;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;

@Entity
@Table(name = "EMPLOYEE")
public class Employee {

    @Id
    @GeneratedValue
    @Column(name = "EMPLOYEE_ID")
    private int employeeId;
    @Column(unique = true)
    private String username;
    private String password;
    private String role;
    private String fname;
    private String lname;
    
    public Employee() {
    }

    public Employee(String username, String password, String role, String fname, String lname) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.fname = fname;
        this.lname = lname;
    }

    public Employee(int employeeId, String username, String password, String role, String fname, String lname) {
        this.employeeId = employeeId;
        this.username = username;
        this.password = password;
        this.role = role;
        this.fname = fname;
        this.lname = lname;
    }

    public Employee(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public int getId() {
        return employeeId;
    }

    public void setId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }
    public void setLname(String lname) {
        this.lname = lname;
    }

    @Override
    public String toString(){
        return "Employee [employeeId=" + employeeId + ", username=" + username + ", password=" + password + ", role=" + role + ", fname=" + fname + ", lname=" + lname + "]";
    }

}
