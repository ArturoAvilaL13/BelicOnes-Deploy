package com.belicones.APIRest.model.dao.tipos.carne;

import com.belicones.APIRest.model.entity.tipos.carne.TipoDeCarne;
import org.springframework.data.repository.CrudRepository;

public interface TipoDeCarneDao extends CrudRepository<TipoDeCarne,Integer> {
}
