package com.example.ArtWork.Repository;

import com.example.ArtWork.model.Artist;
import com.example.ArtWork.model.Judge;
import com.example.Repository.ArtistRepository;
import com.example.Service.ArtistService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class Repositorytest {

    @Mock
    private ArtistRepository artistRepository;

    @InjectMocks
    private ArtistService artistService;

    private Judge judge;
    private Artist artist;

    @Before
    public void setUp() {
        judge = new Judge("JudgeName"); // Assuming you have a constructor for Judge
        artist = new Artist("ArtistName", "ArtName", 85, judge); // Assuming Artist constructor is like this
    }

    @Test
    public void testGetArtistByName() {
        // Mock the repository method
        when(artistRepository.findByName("ArtistName")).thenReturn(artist);

        // Call the service method
        Artist foundArtist = artistService.getArtistByName("ArtistName");

        // Assert the result
        assertEquals("ArtistName", foundArtist.getName());
        assertEquals("ArtName", foundArtist.getArtName());
        assertEquals(Integer.valueOf(85), foundArtist.getScore());
    }
}
