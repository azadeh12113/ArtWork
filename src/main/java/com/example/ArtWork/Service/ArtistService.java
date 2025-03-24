package com.example.ArtWork.Service;

import org.springframework.stereotype.Service;

import com.example.ArtWork.Repository.ArtistRepository;
import com.example.ArtWork.Repository.JudgeRepository;
import com.example.ArtWork.model.Artist;
import com.example.ArtWork.model.Judge;

import java.util.List;

@Service
public class ArtistService {

    private final ArtistRepository artistRepository;
    private final JudgeRepository judgeRepository;  // Inject the judge repository to fetch the default judge

    // Constructor injection
    public ArtistService(ArtistRepository artistRepository, JudgeRepository judgeRepository) {
        this.artistRepository = artistRepository;
        this.judgeRepository = judgeRepository;
    }

}