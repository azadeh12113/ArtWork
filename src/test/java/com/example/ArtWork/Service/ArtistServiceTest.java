package com.example.ArtWork.Service;

import com.example.ArtWork.Repository.ArtistRepository;
import com.example.ArtWork.Repository.JudgeRepository;
import com.example.ArtWork.model.Artist;
import com.example.ArtWork.model.Judge;
import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ArtistServiceTest {

    @Mock
    private ArtistRepository artistRepository;

    @Mock
    private JudgeRepository judgeRepository;

    @InjectMocks
    private ArtistService artistService;
    @Test
    public void test_createArtist_setJudgeAndSavesArtist() {
    
    Artist artist = new Artist();
    artist.setName("Azadeh");
    
    Judge judge = new Judge();
    judge.setId(1L);
    
    Artist savedArtist = new Artist();
    savedArtist.setName("Azadeh");
    savedArtist.setJudge(judge);
    
    when(judgeRepository.findById(1L)).thenReturn(Optional.of(judge));
    when(artistRepository.save(artist)).thenReturn(savedArtist);
    
    Artist result = artistService.createArtist(artist);
    
    assertThat(result.getJudge()).isEqualTo(judge);
    verify(artistRepository).save(artist);
    
    }
    
    

}
