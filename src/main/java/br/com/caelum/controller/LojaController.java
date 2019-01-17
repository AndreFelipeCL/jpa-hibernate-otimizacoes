package br.com.caelum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.caelum.dao.LojaDao;
import br.com.caelum.model.Loja;

@Controller
@RequestMapping("/loja")
public class LojaController {
	
	@Autowired
	private LojaDao lojaDao;
	
	@RequestMapping("/form")
	public String form() { 
		return "loja/form";
	}
	
	@RequestMapping("/{id}")
	public String detalhe(@PathVariable Integer id, Model model) {
		Loja loja = lojaDao.getLoja(id);
		
		model.addAttribute("loja", loja);
		return "loja/detalhe";
	}	
}
