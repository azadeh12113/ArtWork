package com.example.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.ArtWork.model.Artist;
import com.example.ArtWork.model.Judge;

import java.util.List;

@Repository
public interface ArtistRepository extends JpaRepository<Artist, Long> {

    // Find all artists by judge
    List<Artist> findByJudge(Judge judge);

    // Find an artist by name
    Artist findByName(String name);

    // Find artists by score greater than a certain threshold
    List<Artist> findByScoreGreaterThan(Integer score);
}
