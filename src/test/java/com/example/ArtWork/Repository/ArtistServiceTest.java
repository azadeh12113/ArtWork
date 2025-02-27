package com.example.ArtWork.Repository;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import com.example.Repository.ArtistRepository;
import com.example.Service.ArtistService;
import com.example.ArtWork.model.Artist;
import com.example.ArtWork.model.Judge;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class ArtistServiceTest {

    @Mock
    private ArtistRepository artistRepository;

    @InjectMocks
    private ArtistService artistService;  // The service we’re testing

    private Artist artist;
    private Judge judge;

    @Before
    public void setUp() {
        judge = new Judge("JudgeName");
        artist = new Artist("ArtistName", "ArtName", 90, judge);
    }

    @Test
    public void testGetArtistByName() {
        // Arrange
        when(artistRepository.findByName("ArtistName")).thenReturn(artist);

        // Act
        Artist foundArtist = artistService.getArtistByName("ArtistName");

        // Assert
        assertNotNull(foundArtist);
        assertEquals("ArtistName", foundArtist.getName());
        assertEquals("ArtName", foundArtist.getArtName());
        assertEquals(Integer.valueOf(90), foundArtist.getScore());
    }

    @Test
    public void testGetArtistsWithHighScores() {
        // Arrange
        List<Artist> artists = Arrays.asList(artist);
        when(artistRepository.findByScoreGreaterThan(80)).thenReturn(artists);

        // Act
        List<Artist> result = artistService.getArtistsWithHighScores(80);

        // Assert
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("ArtistName", result.get(0).getName());
    }
}
