package gov.ny.its.mentor_demo.service;

import gov.ny.its.mentor_demo.entity.User;
import gov.ny.its.mentor_demo.entity.UserAddress;
import gov.ny.its.mentor_demo.repo.UserAddressRepo;
import gov.ny.its.mentor_demo.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	@Autowired
	private UserRepo userRepo;

	@Autowired
	private UserAddressRepo userAddressRepo;

	public void createUserWithAddress(User user) {
		// save the user
		User savedUser = userRepo.save(user);

		// add the user reference to each address
		for(UserAddress addr : user.getAddresses()) {
			addr.setUser(savedUser);
		}

		// save addresses
		userAddressRepo.saveAll(user.getAddresses());
	}
}
