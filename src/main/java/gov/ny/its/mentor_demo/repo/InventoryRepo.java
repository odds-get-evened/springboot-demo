package gov.ny.its.mentor_demo.repo;

import gov.ny.its.mentor_demo.entity.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepo extends JpaRepository<Inventory, Long> {}
