package desafio.happe.demo.service;

import desafio.happe.demo.security.UserSS;
import org.springframework.security.core.context.SecurityContextHolder;


public class UserSService {

	public static UserSS authenticated() {
		try {
			return (UserSS) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		} catch (Exception e) {
			return null;
		}
	}

}
