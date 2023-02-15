package com.projectmanagement.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.projectmanagement.entity.Admin;
import com.projectmanagement.exceptions.ResourceNotFoundException;
import com.projectmanagement.repo.AdminRepo;

@SpringBootTest
class AdminServiceTest {

	@Autowired
	private AdminService adminService;
	@Autowired
	private AdminRepo adminRepo;

	@Test
	void testAddAdmin() {
		Admin admin = new Admin();
		admin.setUserId(1);
		admin.setUserName("admin");
		admin.setUserPassword("1234");
		admin.setRole("ADMIN");
		assertEquals(admin.toString(), adminService.addAdmin(admin).toString());
		adminRepo.delete(admin);
		

	}

	@Test
	void testUpdateAdmin() throws ResourceNotFoundException {
		Admin admin = new Admin();
		admin.setUserId(1);
		admin.setUserName("admin");
		admin.setUserPassword("1234");
		admin.setRole("ADMIN");

		adminRepo.save(admin);

		

		Admin uadmin = new Admin();
		uadmin.setUserId(1);
		uadmin.setUserName("admin");
		uadmin.setUserPassword("root");
		uadmin.setRole("ADMIN");
		assertEquals(uadmin.toString(), adminService.updateAdmin(uadmin).toString());
		adminRepo.delete(uadmin);
	}

	@Test
	void testAuthenticateAdmin() throws Exception {
		Admin admin = new Admin();
		admin.setUserId(1);
		admin.setUserName("admin");
		admin.setUserPassword("1234");
		admin.setRole("ADMIN");
		adminRepo.save(admin);
		assertEquals(admin.toString(), adminService.authenticateAdmin("admin", "1234").toString());
		adminRepo.delete(admin);
	}

}
