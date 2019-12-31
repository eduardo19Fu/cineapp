package net.itinajero.app.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import net.itinajero.app.model.Noticia;

public interface INoticiasService {
	
	List<Noticia> buscarTodas();
	void guardar(Noticia noticia);
	List<Noticia> buscarTodas(String estatus);
	Page<Noticia> buscarNoticias(Pageable page);
	Noticia buscarPorId(int id);
	void eliminar(int id);
}
