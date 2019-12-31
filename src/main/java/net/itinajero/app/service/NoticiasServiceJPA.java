package net.itinajero.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import net.itinajero.app.model.Noticia;
import net.itinajero.app.repository.NoticiasRepository;

@Service
public class NoticiasServiceJPA implements INoticiasService {

	@Autowired
	private NoticiasRepository noticiasRepo;
	
	@Override
	public List<Noticia> buscarTodas() {
		return noticiasRepo.findBy();
	}

	@Override
	public void guardar(Noticia noticia) {
		noticiasRepo.save(noticia);
	}

	@Override
	public List<Noticia> buscarTodas(String estatus) {
		return noticiasRepo.findTop3ByEstatusOrderByFechaDesc(estatus);
	}

	@Override
	public Page<Noticia> buscarNoticias(Pageable page) {
		Page<Noticia> lista = noticiasRepo.buscarNoticiasOrdenadas(page);
		return lista;
	}

	@Override
	public Noticia buscarPorId(int id) {
		Optional<Noticia> noticia = noticiasRepo.findById(id);
		if(noticia.isPresent())
			return noticia.get();
		else
			return null;
	}

	@Override
	public void eliminar(int id) {
		noticiasRepo.deleteById(id);
	}

}
