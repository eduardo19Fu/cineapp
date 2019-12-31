package net.itinajero.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import net.itinajero.app.model.Banner;
import net.itinajero.app.repository.BannersRepository;

@Service
public class BannersServiceJPA implements IBannersService{

	@Autowired
	private BannersRepository bannersRepo;
	
	@Override
	public List<Banner> buscarTodas() {
		return bannersRepo.findAll();
	}

	@Override
	public void insertar(Banner banner) {
		bannersRepo.save(banner);
	}

	@Override
	public Banner buscarPorId(int id) {
		Optional<Banner> banner = bannersRepo.findById(id);
		
		if(banner.isPresent())
			return banner.get();
		else
			return null;
	}

	@Override
	public void eliminar(int id) {
		bannersRepo.deleteById(id);
	}

	@Override
	public Page<Banner> buscarTodas(Pageable page) {
		return bannersRepo.findAll(page);
	}

}
