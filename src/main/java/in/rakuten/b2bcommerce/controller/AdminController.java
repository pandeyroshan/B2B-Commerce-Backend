package in.rakuten.b2bcommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import in.rakuten.b2bcommerce.dto.AdminTilesInfo;
import in.rakuten.b2bcommerce.service.AdminService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	@GetMapping("/admin-information")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public AdminTilesInfo getAdminInformation() {
		return adminService.getAdminTileInformation();
	}
}
