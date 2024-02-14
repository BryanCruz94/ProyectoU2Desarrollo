package com.espe.idao;

import com.espe.model.User;
import com.espe.model.Vehiculo;

import java.util.List;

public interface IVehiculoDao {
    void guardar(Vehiculo vehiculo);
    void editar(Vehiculo vehiculo);

    Vehiculo buscarVehiculo(int id);

    List<Vehiculo> obtenerVehiculo();

    void eliminar(int id);

}
