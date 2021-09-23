package com.jhone.estudos.services;

import com.jhone.estudos.dominio.Tecnologias;
import com.jhone.estudos.repositories.TecnologiasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TecnologiasService {

    @Autowired
    private TecnologiasRepository tecrepository;

    public List<Tecnologias> findAll(){
        return tecrepository.findAll();
    }

    public Tecnologias create(Tecnologias obj) {
        Tecnologias newObj = new Tecnologias();
        newObj.setId(obj.getId());
        newObj.setTitulo(obj.getTitulo());
        newObj.setDescricao(obj.getDescricao());

        return tecrepository.save(newObj);
    }

    public Optional<Tecnologias> getById(Integer id) {
        return tecrepository.findById(id);
    }

    public void delete(Integer id) {
        tecrepository.deleteById(id);
    }
}
