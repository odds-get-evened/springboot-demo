package gov.ny.its.mentor_demo.repo;

import gov.ny.its.mentor_demo.entity.ArtistEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtistRepo extends JpaRepository<ArtistEntity, Long> {
	// @Query("SELECT * FROM album_artists AS a LEFT JOIN artists AS b ON (b.id = a.artist_id")

}
