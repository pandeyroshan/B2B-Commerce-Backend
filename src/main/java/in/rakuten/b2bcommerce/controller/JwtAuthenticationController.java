package in.rakuten.b2bcommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.rakuten.b2bcommerce.dto.BusinessDetail;
import in.rakuten.b2bcommerce.dto.JwtRequest;
import in.rakuten.b2bcommerce.dto.JwtResponse;
import in.rakuten.b2bcommerce.dto.JwtToken;
import in.rakuten.b2bcommerce.service.JwtUserDetailsService;
import in.rakuten.b2bcommerce.service.UserService;
import in.rakuten.b2bcommerce.utils.JwtTokenUtil;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class JwtAuthenticationController {
	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private JwtUserDetailsService userDetailsService;
	
	@Autowired
	private UserService userService;

	@PostMapping("/login")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {

		authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());

		final UserDetails userDetails = userDetailsService
				.loadUserByUsername(authenticationRequest.getUsername());

		final String token = jwtTokenUtil.generateToken(userDetails);

		return ResponseEntity.ok(new JwtResponse(token));
	}
	
	@PostMapping("/get-role")
	public String getUserRoleFromJwtToken(@RequestBody JwtToken jwtToken) {
		return userService.getUserRoleFromJwtToken(jwtToken.getToken());
	}
	
	@PostMapping("/get-detail-from-token")
	public BusinessDetail getBusinessDetailFromJwtToken(@RequestBody JwtToken jwtToken) {
		return userService.getBusinessDetailsFromJwtToken(jwtToken.getToken());
	}

	private void authenticate(String username, String password) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
	}
}
