package com.belicones.APIRest.model.dao;

import com.belicones.APIRest.model.entity.Carne;
import org.springframework.data.repository.CrudRepository;

public interface CarneDao extends CrudRepository<Carne,Integer> {
}
