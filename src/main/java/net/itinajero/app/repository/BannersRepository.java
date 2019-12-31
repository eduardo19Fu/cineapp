package net.itinajero.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.itinajero.app.model.Banner;

public interface BannersRepository extends JpaRepository<Banner, Integer> {

}
