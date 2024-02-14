package com.espe.idao;

import com.espe.model.Driver;
import com.espe.model.Vehiculo;

import java.util.List;

public interface IDriverDao {
    void guardar(Driver driver);
    void editar(Driver driver);

    Driver buscarDriver(int id);

    List<Driver> obtenerDriver();

    void eliminar(int id);
}
