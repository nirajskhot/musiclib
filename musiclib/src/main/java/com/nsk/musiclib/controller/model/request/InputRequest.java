package com.nsk.musiclib.controller.model.request;

public class InputRequest extends BaseRequest{
    private String title;
    private String artist;
    private String album;
    private String link;

    public InputRequest() {
    }

    public InputRequest(String title, String artist, String album, String link) {
        this.title = title;
        this.artist = artist;
        this.album = album;
        this.link = link;
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

    public InputRequest title(String title) {
        setTitle(title);
        return this;
    }

    public InputRequest artist(String artist) {
        setArtist(artist);
        return this;
    }

    public InputRequest album(String album) {
        setAlbum(album);
        return this;
    }

    public InputRequest link(String link) {
        setLink(link);
        return this;
    }

    @Override
    public String toString() {
        return "{" +
            " title='" + getTitle() + "'" +
            ", artist='" + getArtist() + "'" +
            ", album='" + getAlbum() + "'" +
            ", link='" + getLink() + "'" +
            "}";
    }
    
}
