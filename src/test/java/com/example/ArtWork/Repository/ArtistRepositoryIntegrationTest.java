package com.example.ArtWork.Repository;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;

import com.example.ArtWork.model.Artist;
import com.example.ArtWork.model.Judge;
import com.example.Repository.ArtistRepository;
import com.example.Service.ArtistService;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

import com.example.ArtWork.model.Artist;
import com.example.ArtWork.model.Judge;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)

public class ArtistRepositoryIntegrationTest {

    @Autowired
    private TestEntityManager entityManager; // ✅ Injects TestEntityManager

    @Autowired
    private ArtistRepository artistRepository;

    private Judge judge;

    @Before
    public void setUp() {
        judge = new Judge("Judge1");
        entityManager.persist(judge); // ✅ Saves Judge before using it
        entityManager.flush();
    }

    @Test
    public void testSaveAndFindByName() {
        // Arrange
        Artist artist = new Artist("John Doe", "Painter", 85, judge);
        entityManager.persist(artist); // ✅ Saves Artist to DB
        entityManager.flush();

        // Act
        Artist foundArtist = artistRepository.findByName("John Doe");

        // Assert
        assertNotNull(foundArtist);
        assertEquals("John Doe", foundArtist.getName());
    }
}
