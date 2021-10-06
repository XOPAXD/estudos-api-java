package com.jhone.estudos.services;

import com.jhone.estudos.dominio.Quadrinhos;
import com.jhone.estudos.repositories.QuadrinhosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuadrinhosService {

    @Autowired
    private QuadrinhosRepository quadrepository;

    public List<Quadrinhos> findAll(){
        return quadrepository.findAll();
    }

    public Quadrinhos create(Quadrinhos obj) {
        Quadrinhos newObj = new Quadrinhos();
        newObj.setId(obj.getId());
        newObj.setNome(obj.getNome());
        newObj.setDescricao(obj.getDescricao());
        newObj.setDataPublicacao(obj.getDataPublicacao());
        newObj.setUrlImage(obj.getUrlImage());
        return quadrepository.save(newObj);
    }
}
