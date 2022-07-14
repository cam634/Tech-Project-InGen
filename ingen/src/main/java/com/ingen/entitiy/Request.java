package com.ingen.entitiy;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "REQUEST")
public class Request {

    @Id
    @GeneratedValue
    @Column(name = "REQUEST_ID")
    private int requestId;
    private String status;
    private int value;
    @Column(length = 500)
    private String requestReason;
    @Column(length = 500)
    private String reviewReason;
    private String requestedBy;
    private String reviewedBy;

    public Request() {
    }

    public Request(String status, int value, String requestReason, String reviewReason, String requestedBy,
            String reviewedBy) {
        this.status = status;
        this.value = value;
        this.requestReason = requestReason;
        this.reviewReason = reviewReason;
        this.requestedBy = requestedBy;
        this.reviewedBy = reviewedBy;
    }

    public Request(int requestId, String status, int value, String requestReason, String reviewReason, String requestedBy,
            String reviewedBy) {
        this.requestId = requestId;
        this.status = status;
        this.value = value;
        this.requestReason = requestReason;
        this.reviewReason = reviewReason;
        this.requestedBy = requestedBy;
        this.reviewedBy = reviewedBy;
    }

    public int getId() {
        return requestId;
    }

    public void setId(int requestId) {
        this.requestId = requestId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getRequestReason() {
        return requestReason;
    }

    public void setRequestReason(String requestReason) {
        this.requestReason = requestReason;
    }

    public String getReviewReason() {
        return reviewReason;
    }

    public void setReviewReason(String reviewReason) {
        this.reviewReason = reviewReason;
    }

    public String getRequestedBy() {
        return requestedBy;
    }

    public void setRequestedBy(String requestedBy) {
        this.requestedBy = requestedBy;
    }

    public String getReviewedBy() {
        return reviewedBy;
    }

    public void setReviewedBy(String reviewedBy) {
        this.reviewedBy = reviewedBy;
    }

    @Override
    public String toString() {
        return "Request [requestId=" + requestId + ", requestReason=" + requestReason + ", requestedBy=" + requestedBy + ", reviewReason="
                + reviewReason + ", reviewedBy=" + reviewedBy + ", status=" + status + ", value=" + value + "]";
    }
      
}
