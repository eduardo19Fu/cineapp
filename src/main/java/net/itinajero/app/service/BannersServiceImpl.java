package net.itinajero.app.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import net.itinajero.app.model.Banner;

//@Service
public class BannersServiceImpl implements IBannersService {
	
	private List<Banner> lista = null;
	private SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
	
	public BannersServiceImpl() {
		
		try {
			lista = new LinkedList<>();
			Banner banner1 = new Banner();
			banner1.setId(1);
			banner1.setTitulo("King Kong: La Isla Calavera");
			//banner1.setFechaPublicacion(formato.parse("20-05-2019"));
			//banner1.setImagen("slide1.jpg");
			banner1.setEstatus("Activo");
			
			Banner banner2 = new Banner();
			banner2.setId(2);
			banner2.setTitulo("La Bella y la Bestia");
			//banner2.setFechaPublicacion(formato.parse("31-05-2019"));
			//banner2.setImagen("slide2.jpg");
			banner2.setEstatus("Activo");
			
			Banner banner3 = new Banner();
			banner3.setId(3);
			banner3.setTitulo("Spider-Man: De regreso a casa");
			//banner3.setFechaPublicacion(formato.parse("01-06-2019"));
			//banner3.setImagen("slide3.jpg");
			banner3.setEstatus("Activo");
			
			Banner banner4 = new Banner();
			banner4.setId(4);
			banner4.setTitulo("Cars 3");
			//banner4.setFechaPublicacion(formato.parse("02-06-2019"));
			//banner4.setImagen("slide4.jpg");
			banner4.setEstatus("Activo");
			
			lista.add(banner1);
			lista.add(banner2);
			lista.add(banner3);
			lista.add(banner4);
			
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
	

	@Override
	public List<Banner> buscarTodas() {
		// TODO Auto-generated method stub
		return lista;
	}


	@Override
	public void insertar(Banner banner) {
		lista.add(banner);
	}


	@Override
	public Banner buscarPorId(int id) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void eliminar(int id) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public Page<Banner> buscarTodas(Pageable page) {
		// TODO Auto-generated method stub
		return null;
	}

}
