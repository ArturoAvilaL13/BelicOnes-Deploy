package com.belicones.APIRest.service.carne;

import com.belicones.APIRest.builder.Builders;
import com.belicones.APIRest.model.dao.CarneDao;
import com.belicones.APIRest.model.dto.CarneDto;
import com.belicones.APIRest.model.entity.Carne;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarneImplementsService implements InterfaceCarneService{
    @Autowired
    private CarneDao carneDao;
    @Transactional
    @Override
    public List<Carne> listAll() {
        List<Carne> carnes = (List<Carne>) carneDao.findAll();
        if (carnes.isEmpty()){
            return null;
        }
        return carnes;
    }
    @Transactional
    @Override
    public Carne save(CarneDto carneDto) {
        Carne carne = new Builders().builderCarne(carneDto);
        return carneDao.save(carne);
    }
    @Transactional
    @Override
    public Carne findById(int id) {
        return carneDao.findById(id).orElse(null);
    }
    @Transactional
    @Override
    public List<Carne> findByTipo(int id) {
        List<Carne> carnes = (List) carneDao.findAll();
        List<Carne> carnesFiltradas = new ArrayList<>();
        if(carnes.isEmpty()){
            return null;
        }
        for(Carne carne:carnes){
            if(carne.getFkIdTipoDeCorte() == id){
                carnesFiltradas.add(carne);
            }
        }
        return carnesFiltradas;
    }
    @Transactional
    @Override
    public void delete(Carne carne) {
        carneDao.delete(carne);
    }
    @Transactional
    @Override
    public boolean existsById(int id) {
        return carneDao.existsById(id);
    }
}
