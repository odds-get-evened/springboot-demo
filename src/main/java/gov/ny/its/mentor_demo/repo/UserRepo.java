package gov.ny.its.mentor_demo.repo;

import gov.ny.its.mentor_demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepo extends JpaRepository<User, Long> {
	@Query(value = "SELECT * FROM users AS u WHERE u.email = :email", nativeQuery = true)
	User findByEmail(String email);
}
