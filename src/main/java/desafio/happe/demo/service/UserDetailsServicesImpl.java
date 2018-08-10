package desafio.happe.demo.service;

import desafio.happe.demo.entity.Usuario;
import desafio.happe.demo.repository.UsuarioRepository;
import desafio.happe.demo.security.UserSS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


@Service
public class UserDetailsServicesImpl implements UserDetailsService {
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Usuario obj = usuarioRepository.findByEmail(email);
		if (obj == null) {
			throw new UsernameNotFoundException(email);
		}
		return new UserSS(obj.getId(), obj.getEmail(), obj.getSenha(), obj.getPerfis());
	}

}
