package com.nsk.musiclib.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nsk.musiclib.controller.model.request.BulkInputRequest;
import com.nsk.musiclib.controller.model.request.GeneralQuery;
import com.nsk.musiclib.controller.model.request.InputRequest;
import com.nsk.musiclib.controller.model.response.BaseResponse;
import com.nsk.musiclib.controller.model.response.MessageResponse;
import com.nsk.musiclib.controller.model.response.TrackListResponse;
import com.nsk.musiclib.db.model.Track;
import com.nsk.musiclib.db.repository.TrackRepository;

@Service
public class LibraryService {
    @Autowired
    private TrackRepository trackRepo;
    private static String datePattern;
    private static DateTimeFormatter dtf;

    Logger logger = LoggerFactory.getLogger(LibraryService.class);
    
    static{
        datePattern = "yyyy-MM-dd hh:mm:ss";
        dtf = DateTimeFormatter.ofPattern(datePattern);
    }
    
    public BaseResponse queryLibrary(GeneralQuery req){
        logger.trace(req.toString());
        List<Track> tracklist;
        try{
            String parameter = req.getField();
            logger.info(parameter);
            if(parameter.equals("artist")){
                logger.info(req.getValue());
                tracklist = trackRepo.findAllByArtist(req.getValue());
            }else if(parameter.equals("album")){
                logger.info(req.getValue());
                tracklist = trackRepo.findAllByAlbum(req.getValue());
            }else{
                logger.error("Nothing matched");
                return new MessageResponse(200, "A" + req.getField().substring(1) + " not found");
            }
            
        }catch(Exception e){
            e.printStackTrace();
            return new MessageResponse(500, "Card Creation Failed");
        }
        return new TrackListResponse(tracklist);
    }

    public BaseResponse listAllTracksInLibrary(){
        try{
            return new TrackListResponse(trackRepo.findAll());
        }catch(Exception e){
            e.printStackTrace();
            return new MessageResponse(500, "Tracklist retrieval failed");
        }
    }

    public BaseResponse addToLibrary(InputRequest req){
        logger.trace(req.toString());
        String lastUpdateString = LocalDateTime.now().format(dtf);
        Track newTrack = new Track( req.getTitle(), req.getArtist(), req.getAlbum(), req.getLink(), lastUpdateString);
        try{
            trackRepo.save(newTrack);
        }catch(Exception e){
            e.printStackTrace();
            return new MessageResponse(500, "Track could not be saved");
        }
        return new MessageResponse(200, "Track added to library");
    }

    public BaseResponse addAllToLibrary(BulkInputRequest reqL){
        logger.trace(reqL.toString());
        List<String> completedList = new ArrayList<String>();

        try{
            String lastUpdateString = LocalDateTime.now().format(dtf);
            for (InputRequest req : reqL.getTrackList()) {
                Track newTrack = new Track( req.getTitle(), req.getArtist(), req.getAlbum(), req.getLink(), lastUpdateString);
                trackRepo.save(newTrack);
                completedList.add(req.getTitle());
            }    
        }catch(Exception e){
            e.printStackTrace();
            return new MessageResponse(500, "Track addition could not be complete. Tracks saved so far: " + completedList.toString());
        }
        return new MessageResponse(200, "All tracks added to library");
    }
}
