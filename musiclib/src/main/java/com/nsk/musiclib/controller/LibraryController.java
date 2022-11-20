package com.nsk.musiclib.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nsk.musiclib.controller.model.request.BulkInputRequest;
import com.nsk.musiclib.controller.model.request.GeneralQuery;
import com.nsk.musiclib.controller.model.request.InputRequest;
import com.nsk.musiclib.controller.model.response.BaseResponse;
import com.nsk.musiclib.service.LibraryService;

@RestController
public class LibraryController {
    @Autowired
    private LibraryService libraryService;

    Logger logger = LoggerFactory.getLogger(LibraryService.class);
    
    @GetMapping("/list/all")
    public BaseResponse getAllTracks(){
        return libraryService.listAllTracksInLibrary();
    }

    @PostMapping("/list/artist")
    public BaseResponse getTracksForArtist(@RequestBody GeneralQuery req){
        logger.debug(req.toString());
        req.setField("artist");
        BaseResponse res = libraryService.queryLibrary(req);
        return res;
    }

    @PostMapping("/list/album")
    public BaseResponse getTracksForAlbum(@RequestBody GeneralQuery req){
        logger.debug(req.toString());
        req.setField("album");
        BaseResponse res = libraryService.queryLibrary(req);
        return res;
    }

    @PostMapping("/add/track")
    public BaseResponse addTrack(@RequestBody InputRequest req){
        logger.debug(req.toString());
        BaseResponse res = libraryService.addToLibrary(req);
        return res;
    }

    @PostMapping("/add/all")
    public BaseResponse addAllTracks(@RequestBody BulkInputRequest req){
        logger.debug(req.toString());
        BaseResponse res = libraryService.addAllToLibrary(req);
        return res;
    }
}
