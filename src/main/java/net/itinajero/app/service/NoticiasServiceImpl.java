package net.itinajero.app.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import net.itinajero.app.model.Noticia;

//@Service
public class NoticiasServiceImpl implements INoticiasService{

	private Noticia noticia = null;
	
	public NoticiasServiceImpl() {
		System.out.println("Creando Instancia de la implementación Noticias Service");
	}
	
	@Override
	public void guardar(Noticia noticia) {
		System.out.println("Guardado: " + noticia);
	}

	@Override
	public List<Noticia> buscarTodas() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Noticia> buscarTodas(String estatus) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Noticia> buscarNoticias(Pageable page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Noticia buscarPorId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminar(int id) {
		// TODO Auto-generated method stub
		
	}

}
