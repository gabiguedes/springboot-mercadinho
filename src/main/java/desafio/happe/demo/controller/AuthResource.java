package desafio.happe.demo.controller;

import javax.servlet.http.HttpServletResponse;

import desafio.happe.demo.entity.Usuario;
import desafio.happe.demo.security.JWTUtil;
import desafio.happe.demo.security.UserSS;
import desafio.happe.demo.service.AuthService;
import desafio.happe.demo.service.UserSService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/auth")
public class AuthResource {

	@Autowired
	private JWTUtil jwtUtil;

	@Autowired
	AuthService authService;
	
	@RequestMapping(value = "/refresh_token", method = RequestMethod.POST)
	public ResponseEntity<Void> refreshToken(HttpServletResponse response) {
		UserSS user = UserSService.authenticated();
		String token = jwtUtil.generateToken(user.getUsername());

		response.addHeader("Authorization", "Bearer " + token);
		response.addHeader("access-control-expose-headers", "Authorization");

		return ResponseEntity.noContent().build();
	}

	@RequestMapping(value = "/facebook", method = RequestMethod.POST)
	public ResponseEntity<String> facebookLogin(HttpServletResponse response,@RequestBody Usuario usuario) {
		Usuario user = authService.facebookLogin(usuario);
		String token = jwtUtil.generateToken(user.getEmail());
		response.addHeader("Authorization", "Bearer " + token);
		response.addHeader("access-control-expose-headers", "Authorization");
		return ResponseEntity.noContent().build();
	}

}
