package com.belicones.APIRest.service.carne;

import com.belicones.APIRest.model.dto.CarneDto;
import com.belicones.APIRest.model.entity.Carne;

import java.util.List;

public interface InterfaceCarneService {
    List<Carne> listAll();
    Carne save(CarneDto carneDto);
    Carne findById(int id);
    List<Carne> findByTipo(int id);
    void delete(Carne carne);
    boolean existsById(int id);
}
