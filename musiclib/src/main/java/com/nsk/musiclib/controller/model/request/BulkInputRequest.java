package com.nsk.musiclib.controller.model.request;

import java.util.List;

public class BulkInputRequest extends BaseRequest{
    List<InputRequest> trackList;

    public BulkInputRequest() {
    }

    public BulkInputRequest(List<InputRequest> trackList) {
        this.trackList = trackList;
    }

    public List<InputRequest> getTrackList() {
        return this.trackList;
    }

    public void setTrackList(List<InputRequest> trackList) {
        this.trackList = trackList;
    }

    public BulkInputRequest trackList(List<InputRequest> trackList) {
        setTrackList(trackList);
        return this;
    }

    @Override
    public String toString() {
        return "{" +
            " trackList='" + getTrackList() + "'" +
            "}";
    }
    
}
