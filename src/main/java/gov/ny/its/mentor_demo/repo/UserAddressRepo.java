package gov.ny.its.mentor_demo.repo;

import gov.ny.its.mentor_demo.entity.UserAddress;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAddressRepo extends JpaRepository<UserAddress, Long> {
}
