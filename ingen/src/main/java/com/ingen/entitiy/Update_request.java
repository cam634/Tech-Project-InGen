package com.ingen.entitiy;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;


@Entity
public class Update_request {

    @Id
    @GeneratedValue
    private int id;
    private int employee_id;
    private int request_id;
    private String action;





public static void update_request() {

}


    public Update_request(int employee_id, int request_id, String action ) {
    this.employee_id = employee_id;
    this.request_id = request_id;
    this.action = action;
}
    


    public int getId(int id) {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEmployee_id() {
        return employee_id;
    }
    public void setEmployee_id(int employee_id)  {
        this.employee_id = employee_id;
    }
    public int getRequest_id() {
        return request_id;
    }

    public void setRequest_id(int request_id) {
        this.request_id = request_id;
    }
    public String getAction() {
        return action;
    }
    
    
    public void setAction(String action) {
        this.action = action;
    }


    @Override
    public String toString() {
        return "Update_request [action=" + action + ", employee_id=" + employee_id + ", id=" + id + ", request_id="
                + request_id + "]";
    }
    
    
    

}