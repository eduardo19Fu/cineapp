package net.itinajero.app.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import net.itinajero.app.model.Noticia;

@Repository
//public interface NoticiasRepository extends CrudRepository<Noticia, Integer> {
public interface NoticiasRepository extends JpaRepository<Noticia, Integer> {
	
	// select * from Noticias
	List<Noticia> findBy();
	
	// select * from Noticias where estatus = ?
	List<Noticia> findByEstatus(String estatus);
	
	// select * from Noticias where fecha = ?
	List<Noticia> findByFecha(Date fecha);	
	
	// select * from Noticias where estatus = ? and fecha = ?
	List<Noticia> findByEstatusAndFecha(String estatus, Date fecha);
	
	// select * from Noticias where estatus = ? or fecha = ?
	List<Noticia> findByEstatusOrFecha(String estatus, Date fecha);
	
	// select * from Noticias where fecha between ? and ?
	List<Noticia> findByFechaBetween(Date fechaIni, Date fechaFin);
	
	// select * from Noticias where estatus = ? order by fecha desc limit 3
	List<Noticia> findTop3ByEstatusOrderByFechaDesc(String estatus);
	
	// select n.* from noticias as n order by fecha desc
	// consulta personalizada utilizando anotation-query
	@Query("select n from Noticia n order by fecha desc")
	Page<Noticia> buscarNoticiasOrdenadas(Pageable page);
	
}
