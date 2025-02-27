package com.example.Service;

import org.springframework.stereotype.Service;
import com.example.ArtWork.model.Artist;
import com.example.ArtWork.model.Judge;
import com.example.Repository.ArtistRepository;

import java.util.List;

@Service
public class ArtistService {

    private final ArtistRepository artistRepository;

    // Constructor injection
    public ArtistService(ArtistRepository artistRepository) {
        this.artistRepository = artistRepository;
    }

    // Get all artists by judge
    public List<Artist> getArtistsByJudge(Judge judge) {
        return artistRepository.findByJudge(judge);
    }

    // Get an artist by name
    public Artist getArtistByName(String name) {
        return artistRepository.findByName(name);
    }

    // Get artists with a score greater than a certain threshold
    public List<Artist> getArtistsWithHighScores(Integer score) {
        return artistRepository.findByScoreGreaterThan(score);
    }
}
