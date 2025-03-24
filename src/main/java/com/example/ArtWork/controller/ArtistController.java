package com.example.ArtWork.controller;

import com.example.ArtWork.Service.ArtistService;
import com.example.ArtWork.model.Artist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.example.ArtWork.Service.ArtistService;
import com.example.ArtWork.Repository.ArtistRepository;

@RestController
@RequestMapping("/artists")
public class ArtistController {

    private final ArtistService artistService;

    // Constructor injection for ArtistService
    @Autowired
    public ArtistController(ArtistService artistService) {
        this.artistService = artistService;
    }

    // Endpoint to create an artist
    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Artist createArtist(@RequestBody Artist artist) {
        return artistService.createArtist(artist);
    }
}

