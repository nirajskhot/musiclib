package com.nsk.musiclib.controller.model.response;

import java.util.List;

import com.nsk.musiclib.db.model.Track;

public class TrackListResponse extends BaseResponse{
    private List<Track> trackList;

    public TrackListResponse() {
    }

    public TrackListResponse(List<Track> trackList) {
        super(200, 200);
        this.trackList = trackList;
    }

    public List<Track> getTrackList() {
        return this.trackList;
    }

    public void setTrackList(List<Track> trackList) {
        this.trackList = trackList;
    }

    public TrackListResponse trackList(List<Track> trackList) {
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
