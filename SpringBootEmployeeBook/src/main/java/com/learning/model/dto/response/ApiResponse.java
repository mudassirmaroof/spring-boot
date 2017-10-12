package com.learning.model.dto.response;

/**
 * Created by mudassir on 17/01/2017.
 */
public class ApiResponse {
    protected String status;
    protected String version = "1.0";
//    protected Date timestamp = new Date();

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

//    public Date getTimestamp() {
//        return timestamp;
//    }
//
//    public void setTimestamp(Date timestamp) {
//        this.timestamp = timestamp;
//    }
}
