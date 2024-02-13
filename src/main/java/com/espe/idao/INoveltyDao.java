package com.espe.idao;
import com.espe.model.novelties.Novelties;
import com.espe.model.novelties.view_novelties;

import java.util.List;

public interface INoveltyDao {
    public void guardar(Novelties novelties);
    public List<view_novelties> verNovedades();

}
