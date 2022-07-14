
package com.ingen.entitiy;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;

@Entity
@Table(name = "UPDATE_REQUEST")
public class UpdateRequest {

    @Id
    @GeneratedValue
    private int updateRequestId;

    @ManyToOne (optional = false)
    @JoinColumn(name="EMPLOYEE_ID")
    private int employeeId;

    @ManyToOne (optional = false)
    @JoinColumn(name = "REQUEST_ID")
    private int requestId;

    private String change;

    public UpdateRequest(){
    }

    public UpdateRequest(int employeeId, int requestId, String change){
        this.employeeId = employeeId;
        this.requestId = requestId;
        this.change = change;
    }

    public UpdateRequest(int updateRequestId, int employeeId, int requestId, String change){
        this.updateRequestId = updateRequestId;
        this.employeeId = employeeId;
        this.requestId = requestId;
        this.change = change;
    }

    public int getId() {
        return updateRequestId;
    }

    public void setId(int updateRequestId) {
        this.updateRequestId = updateRequestId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public int getRequestId() {
        return requestId;
    }

    public void setRequestId(int requestId) {
        this.requestId = requestId;
    }

    public String getChange() {
        return change;
    }

    public void setChange(String change) {
        this.change = change;
    }

    @Override
    public String toString() {
        return "UpdateRequest [change=" + change + ", employeeId=" + employeeId + ", requestId=" + requestId
                + ", updateRequestId=" + updateRequestId + "]";
    }
  
}
