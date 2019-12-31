package net.itinajero.app.service;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import net.itinajero.app.model.Horario;

public interface IHorariosService {
	List<Horario> buscarPorIdPelicula(int idPelicula, Date fecha);
	List<Horario> buscarTodas();
	Page<Horario> buscarTodas(Pageable page);
	void guardar(Horario horario);
	Horario buscarPorId(int idHorario);
	void eliminar(int idHorario);
}
