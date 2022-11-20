package com.nsk.musiclib.db.model;

import java.util.ArrayList;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("library")
public class Track {

    @Id
    private String id;
    private String title;
    private String artist;
    private String album;
    private String link;
    private String lastUpdatedOn;
    private boolean lockStatus;
    private ArrayList<String> genres;
    private ArrayList<String> additionalArtists;


    public Track() {
    }

    public Track(String id, String title, String artist, String album, String link, String lastUpdatedOn, boolean lockStatus, ArrayList<String> genres, ArrayList<String> additionalArtists) {
        this.id = id;
        this.title = title;
        this.artist = artist;
        this.album = album;
        this.link = link;
        this.lastUpdatedOn = lastUpdatedOn;
        this.lockStatus = lockStatus;
        this.genres = genres;
        this.additionalArtists = additionalArtists;
    }

    public Track(String title, String artist, String album, String link, String lastUpdatedOn) {
        this.title = title;
        this.artist = artist;
        this.album = album;
        this.link = link;
        this.lastUpdatedOn = lastUpdatedOn;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return this.artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getAlbum() {
        return this.album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getLink() {
        return this.link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getLastUpdatedOn() {
        return this.lastUpdatedOn;
    }

    public void setLastUpdatedOn(String lastUpdatedOn) {
        this.lastUpdatedOn = lastUpdatedOn;
    }

    public boolean isLockStatus() {
        return this.lockStatus;
    }

    public boolean getLockStatus() {
        return this.lockStatus;
    }

    public void setLockStatus(boolean lockStatus) {
        this.lockStatus = lockStatus;
    }

    public ArrayList<String> getGenres() {
        return this.genres;
    }

    public void setGenres(ArrayList<String> genres) {
        this.genres = genres;
    }

    public ArrayList<String> getAdditionalArtists() {
        return this.additionalArtists;
    }

    public void setAdditionalArtists(ArrayList<String> additionalArtists) {
        this.additionalArtists = additionalArtists;
    }

    public Track id(String id) {
        setId(id);
        return this;
    }

    public Track title(String title) {
        setTitle(title);
        return this;
    }

    public Track artist(String artist) {
        setArtist(artist);
        return this;
    }

    public Track album(String album) {
        setAlbum(album);
        return this;
    }

    public Track link(String link) {
        setLink(link);
        return this;
    }

    public Track lastUpdatedOn(String lastUpdatedOn) {
        setLastUpdatedOn(lastUpdatedOn);
        return this;
    }

    public Track lockStatus(boolean lockStatus) {
        setLockStatus(lockStatus);
        return this;
    }

    public Track genres(ArrayList<String> genres) {
        setGenres(genres);
        return this;
    }

    public Track additionalArtists(ArrayList<String> additionalArtists) {
        setAdditionalArtists(additionalArtists);
        return this;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", title='" + getTitle() + "'" +
            ", artist='" + getArtist() + "'" +
            ", album='" + getAlbum() + "'" +
            ", link='" + getLink() + "'" +
            ", lastUpdatedOn='" + getLastUpdatedOn() + "'" +
            ", lockStatus='" + isLockStatus() + "'" +
            ", genres='" + getGenres() + "'" +
            ", additionalArtists='" + getAdditionalArtists() + "'" +
            "}";
    }

}