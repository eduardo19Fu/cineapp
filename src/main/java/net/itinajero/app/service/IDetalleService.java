package net.itinajero.app.service;

import net.itinajero.app.model.Detalle;

public interface IDetalleService {
	
	void insertar(Detalle detalle);
	void eliminar(int idDetalle);
}
