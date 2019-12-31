package net.itinajero.app.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import net.itinajero.app.model.Noticia;
import net.itinajero.app.service.INoticiasService;

@Controller
@RequestMapping("/noticias")
public class NoticiasController {
	
	@Autowired
	private INoticiasService serviceNoticia;
	
	@GetMapping(value = "/index")
	public String mostrarIndex(Model model) {
		List<Noticia> listaNoticias = serviceNoticia.buscarTodas();
		model.addAttribute("noticias", listaNoticias);
		return "noticias/listNoticias";
	}
	
	@GetMapping(value = "/indexPaginate")
	public String mostrarIndexPaginado(Pageable page, Model model) {
		Page<Noticia> noticias = serviceNoticia.buscarNoticias(page);
		model.addAttribute("noticias", noticias);
		return "noticias/listNoticias";
	}
	
	@GetMapping(value="/create")
	public String crear(@ModelAttribute Noticia noticia) {
		return "noticias/formNoticia";
	}
	
	@PostMapping(value="/save")
	//public String guardar(@RequestParam("titulo") String titulo,@RequestParam("estatus") String estatus,@RequestParam("detalle") String detalle) {
	public String guardar(@ModelAttribute Noticia noticia, BindingResult result, RedirectAttributes attributes) {
		
		if(result.hasErrors()) {
			return "noticias/formNoticia";
		}
		serviceNoticia.guardar(noticia);
		attributes.addFlashAttribute("mensaje", "La noticia fue guardada.");
		return "redirect:/noticias/indexPaginate";
	}
	
	@GetMapping(value = "/edit/{id}")
	public String editar(Model model, @PathVariable("id") int idNoticia) {
		Noticia noticia = serviceNoticia.buscarPorId(idNoticia);
		model.addAttribute("noticia", noticia);
		return "noticias/formNoticia";
	}
	
	@GetMapping(value = "/delete/{id}")
	public String eliminar(@PathVariable("id") int idNoticia, RedirectAttributes attributes) {
		serviceNoticia.eliminar(idNoticia);
		attributes.addFlashAttribute("mensaje", "El registro fue eliminado con exito.");
		return "redirect:/noticias/indexPaginate";
	}
	
	
	@InitBinder("noticia")
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));		
	}

}
