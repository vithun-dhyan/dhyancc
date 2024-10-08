package com.dhyancc.handson.security;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class SecurityInit {

	@Autowired
	private RoleRepo roleRepo;

	@Autowired
	private UserAccountRepo userRepo;

	@PostConstruct
	public void init() {
		if(userRepo.count()>0)
		{
			log.info("data already exists");
			return;
		}
			
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		try {
			Role adminRole = new Role();
			adminRole.setRole("all");
			roleRepo.save(adminRole);

			Role addStudent = new Role();
			addStudent.setRole("add_student");
			addStudent = roleRepo.save(addStudent);

			Role viewStudent = new Role();
			viewStudent.setRole("view_student");
			viewStudent = roleRepo.save(viewStudent);

			UserAccount user1 = new UserAccount();
			user1.setUsername("user1");
			user1.setPassword(encoder.encode("user1"));
			user1.setRoles(Set.of(adminRole));
			userRepo.save(user1);

			UserAccount user2 = new UserAccount();
			user2.setUsername("user2");
			user2.setPassword(encoder.encode("user2"));
			user2.setRoles(Set.of(addStudent, viewStudent));
			userRepo.save(user2);

			UserAccount user3 = new UserAccount();
			user3.setUsername("user3");
			user3.setPassword(encoder.encode("user3"));
			user3.setRoles(Set.of(viewStudent));
			userRepo.save(user3);

		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
