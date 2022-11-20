package com.nsk.musiclib.db.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.nsk.musiclib.db.model.Track;

public interface TrackRepository extends MongoRepository<Track, String>{
    
    @Query("{title:'?0'}")
    Track findItemByTitle(String title);

    @Query("{artist:'?0'}")
    List<Track> findAllByArtist(String artist);
    
    @Query("{album:'?0'}")
    List<Track> findAllByAlbum(String album);

    // @Query(value="{category:'?0'}", fields="{'title' : 1, 'artist' : 1, 'album' : 1}")
    // List<Track> findAll(String category);
    
    public long count();    
}
