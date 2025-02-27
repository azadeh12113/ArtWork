package com.example.ArtWork.Repository;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import com.example.Repository.ArtistRepository;
import com.example.ArtWork.model.Artist;
import com.example.ArtWork.model.Judge;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)  // ✅ Corrected import
public class RepositoryTest2 {

    @Mock
    private ArtistRepository artistRepository;

    private Artist artist;
    private Judge judge;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);  // ✅ Fixed deprecated method
        judge = new Judge();  // Assuming Judge has a default constructor
        artist = new Artist("John Doe", "Painter", 85, judge);
    }

    @Test
    public void testFindByName() {
        when(artistRepository.findByName("John Doe")).thenReturn(artist);

        Artist foundArtist = artistRepository.findByName("John Doe");

        assertNotNull(foundArtist);
        assertEquals("John Doe", foundArtist.getName());
        assertEquals("Painter", foundArtist.getArtName());
        assertEquals(Integer.valueOf(85), foundArtist.getScore());
    }

    @Test
    public void testFindByScoreGreaterThan() {
        List<Artist> artists = Arrays.asList(artist);
        when(artistRepository.findByScoreGreaterThan(80)).thenReturn(artists);

        List<Artist> result = artistRepository.findByScoreGreaterThan(80);

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("John Doe", result.get(0).getName());
    }
}
