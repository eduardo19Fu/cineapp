package net.itinajero.app.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import net.itinajero.app.model.Banner;

public interface IBannersService {
	
	List<Banner> buscarTodas();
	void insertar(Banner banner);
	Banner buscarPorId(int id);
	void eliminar(int id);
	Page<Banner> buscarTodas(Pageable page);
}
