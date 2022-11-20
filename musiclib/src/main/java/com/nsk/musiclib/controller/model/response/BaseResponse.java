package com.nsk.musiclib.controller.model.response;

import java.io.Serializable;

public class BaseResponse implements Serializable{
    long reqid;
    int statuscode;

    public BaseResponse() {
    }

    public BaseResponse(long reqid, int statuscode) {
        this.reqid = reqid;
        this.statuscode = statuscode;
    }

    public long getReqid() {
        return this.reqid;
    }

    public void setReqid(long reqid) {
        this.reqid = reqid;
    }

    public int getStatuscode() {
        return this.statuscode;
    }

    public void setStatuscode(int statuscode) {
        this.statuscode = statuscode;
    }


    @Override
    public String toString() {
        return "{" +
            " reqid='" + getReqid() + "'" +
            ", statuscode='" + getStatuscode() + "'" +
            "}";
    }
}