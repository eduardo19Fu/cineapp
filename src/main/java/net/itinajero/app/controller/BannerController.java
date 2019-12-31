package net.itinajero.app.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import net.itinajero.app.model.Banner;
import net.itinajero.app.service.IBannersService;
import net.itinajero.app.util.Utileria;

@Controller
@RequestMapping(value="/banners")
public class BannerController {
	
	@Autowired
	private IBannersService serviceBanners;
	
	@GetMapping(value = "/index")
	public String index(Model model) {
		List<Banner> lista = serviceBanners.buscarTodas();
		model.addAttribute("banners", lista);
		return "banners/listBanners";
	}
	
	@GetMapping(value = "/indexPaginate")
	public String indexPaginado(Model model, Pageable page) {
		Page<Banner> banners = serviceBanners.buscarTodas(page);
		model.addAttribute("banners", banners);
		return "banners/listBanners";
	}
	
	@GetMapping(value = "/create")
	public String create(@ModelAttribute Banner banner) {
		return "banners/formBanner";
	}
	
	@PostMapping(value = "/save")
	public String save(@ModelAttribute Banner banner, BindingResult result, RedirectAttributes attributes,
						@RequestParam("archivoImagen") MultipartFile multipart, HttpServletRequest request) {
		
		if(result.hasErrors()) {
			System.out.println("Existen errores");
			return "banners/formBanner";
		}
		
		if(!multipart.isEmpty()) {
			String nombreImagen = Utileria.guardarImagen(multipart, request);
			banner.setArchivo(nombreImagen);
		}
		
		serviceBanners.insertar(banner);
		attributes.addFlashAttribute("mensaje","El registro fue agregado con éxito");
		return "redirect:/banners/indexPaginate";
	}
	
	@GetMapping(value = "/edit/{id}")
	public String editar(@PathVariable("id") int idBanner, Model model) {
		Banner banner = serviceBanners.buscarPorId(idBanner);
		model.addAttribute("banner", banner);
		return "banners/formBanner";
	}
	
	@GetMapping(value = "/delete/{id}")
	public String eliminar(@PathVariable("id") int id, RedirectAttributes attributes) {
		serviceBanners.eliminar(id);
		attributes.addFlashAttribute("mensaje", "Registro eliminado con exito.");
		return "redirect:/banners/indexPaginate";
	}

}
