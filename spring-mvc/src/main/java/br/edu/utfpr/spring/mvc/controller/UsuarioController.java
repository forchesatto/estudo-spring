package br.edu.utfpr.spring.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.edu.utfpr.spring.mvc.model.Permissao;
import br.edu.utfpr.spring.mvc.model.Usuario;
import br.edu.utfpr.spring.mvc.repository.PermissaoRepository;
import br.edu.utfpr.spring.mvc.repository.UsuarioRepository;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private PermissaoRepository permissaoRepository;

	@GetMapping(value = "/")
	public String novo() {
		return "usuario/form";
	}

	@PostMapping(value = "/")
	public String salvar(Usuario usuario, BindingResult erros, Model model,
			RedirectAttributes redirect) {
		String password = usuario.getPassword();
		String encodePassword = usuario.getEncodePassword(password);
		usuario.setPassword(encodePassword);
		usuario.addPermissao(getPermissao());
		redirect.addFlashAttribute("mensagem", "Usuário criado com sucesso");
		usuarioRepository.save(usuario);
		return "redirect:/login";
	}

	private Permissao getPermissao() {
		Permissao permissao = permissaoRepository.findByPermissao("ROLE_USER");
		if (permissao == null) {
			permissao = new Permissao();
			permissao.setPermissao("ROLE_USER");
			permissaoRepository.save(permissao);
		}
		return permissao;
	}
}
