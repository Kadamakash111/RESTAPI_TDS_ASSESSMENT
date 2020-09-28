package com.tds.demo;

import org.springframework.http.HttpStatus;

public class Tds_Exception extends RuntimeException {

    private HttpStatus responsecode;
    private  String responsemessage;

    public Tds_Exception(HttpStatus responsecode, String responsemessage) {
        responsecode=this.responsecode;
        responsemessage=this.responsemessage;
    }

    public HttpStatus getResponsecode() {
        return responsecode;
    }

    public void setResponsecode(HttpStatus responsecode) {
        this.responsecode = responsecode;
    }

    public String getResponsemessage() {
        return responsemessage;
    }

    public void setResponsemessage(String responsemessage) {
        this.responsemessage = responsemessage;
    }
}
