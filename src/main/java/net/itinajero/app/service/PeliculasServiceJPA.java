package net.itinajero.app.service;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import net.itinajero.app.model.Pelicula;
import net.itinajero.app.repository.PeliculasRepository;

@Service
public class PeliculasServiceJPA implements IPeliculasService {
	
	@Autowired
	private PeliculasRepository peliculasRepo;
	
	@Override
	public void insertar(Pelicula pelicula) {
		peliculasRepo.save(pelicula);
	}

	@Override
	public List<Pelicula> buscarTodas() {
		List<Pelicula> lista = peliculasRepo.findAll();
		return lista;
	}

	@Override
	public Pelicula buscarPorId(int id) {
		Optional<Pelicula> pelicula = peliculasRepo.findById(id);
		
		if(pelicula.isPresent()) {
			return pelicula.get();
		}
		
		return null;
	}

	@Override
	public List<String> buscarGeneros() {
		// TODO Auto-generated method stub
		List<String> generos = new LinkedList<>();
		generos.add("Acci�n");
		generos.add("Aventura");
		generos.add("Cl�sicas");
		generos.add("Comedia");
		generos.add("Drama");
		generos.add("Terror");
		generos.add("Infantil");
		generos.add("Accion y Aventura");
		generos.add("Rom�ntica");
		generos.add("Ciancia Ficci�n");
		
		return generos;
	}

	@Override
	public void eliminar(int idPelicula) {
		peliculasRepo.deleteById(idPelicula);
	}

	@Override
	public Page<Pelicula> buscarTodas(Pageable page) {
		return peliculasRepo.findAll(page);
	}

	@Override
	public List<Pelicula> buscarTodas(String estatus, Date fecha) {
		return peliculasRepo.findByEstatusAndFechaEstreno(estatus, fecha);
	}

	@Override
	public List<Pelicula> buscarActivas() {
		return peliculasRepo.findByEstatus_OrderByTitulo("Activa");
	}

}
