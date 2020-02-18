package br.com.devmedia.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.devmedia.domain.Usuario;
import br.com.devmedia.service.UsuarioService;

@Controller
@RequestMapping("users")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping("/cadastro")
    public String preSalvar(@ModelAttribute("usuario") Usuario usuario) {
        return "/users/cadastroUsuario";
    }
	
	@PostMapping("/salvar")
    public String salvar(@Valid @ModelAttribute("usuario") Usuario usuario, BindingResult result, RedirectAttributes attr) {
        if (result.hasErrors()) {
            return "/users/cadastroUsuario";
        }

        usuarioService.salvar(usuario);
        attr.addFlashAttribute("mensagem", "Usuario cadastrado com sucesso!");
        return "redirect:/users/listar";
    }
	
	 @GetMapping("/listar")
	    public ModelAndView listar(ModelMap model) {
	        model.addAttribute("usuarios", usuarioService.recuperar());
	        return new ModelAndView("/users/listUsuario", model);
	    }
	 
	 @GetMapping("/{id}/remover")
	    public String remover(@PathVariable("id") long id, RedirectAttributes attr) {
	        usuarioService.excluir(id);
	        attr.addFlashAttribute("mensagem", "Usuario excluído com sucesso.");
	        return "redirect:/users/listar";
	    }
	
}
