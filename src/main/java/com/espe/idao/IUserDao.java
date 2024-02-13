package com.espe.idao;

import com.espe.model.User;

import java.util.List;

public interface IUserDao {
    void guardar(User user);
    void editar(User user);

    User buscarUsuario(int id);

    List<User> obtenerUsuarios();

    void eliminar(int id);

    User login(User usuario);
}
