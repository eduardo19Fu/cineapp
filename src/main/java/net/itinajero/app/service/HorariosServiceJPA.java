package net.itinajero.app.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import net.itinajero.app.model.Horario;
import net.itinajero.app.repository.HorariosRepository;

@Service
public class HorariosServiceJPA implements IHorariosService {

	@Autowired
	private HorariosRepository horariosRepo;
	
	@Override
	public List<Horario> buscarPorIdPelicula(int idPelicula, Date fecha) {
		return horariosRepo.findByPelicula_IdAndFechaOrderByHora(idPelicula, fecha);
	}

	@Override
	public List<Horario> buscarTodas() {
		return horariosRepo.findBy();
	}

	@Override
	public void guardar(Horario horario) {
		horariosRepo.save(horario);
	}

	@Override
	public Page<Horario> buscarTodas(Pageable page) {
		return horariosRepo.findAll(page);
	}

	@Override
	public Horario buscarPorId(int idHorario) {
		Optional<Horario> horario = horariosRepo.findById(idHorario);
		return horario.get();
	}

	@Override
	public void eliminar(int idHorario) {
		horariosRepo.deleteById(idHorario);
	}

}
