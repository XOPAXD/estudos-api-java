package com.jhone.estudos.resources;

import com.jhone.estudos.dominio.Tecnologias;
import com.jhone.estudos.services.TecnologiasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/estudos")
public class TecnologiasResource {

    @Autowired
    private TecnologiasService service;

    @CrossOrigin("*")
    @GetMapping(value = "/tecnologias")
    public List<Tecnologias> findAll(){
        return  service.findAll();
    }

    @CrossOrigin("*")
    @PostMapping(value = "/tecnologia")
    public Tecnologias createosexame(@RequestBody Tecnologias obj) {
        System.out.println("resource tecnologia.:"+obj.getTitulo());
        service.create(obj);
        return obj;
    }

    @CrossOrigin("*")
    @GetMapping(value = "/tecnologia/{id}")
    public Optional<Tecnologias> getById(@PathVariable (value = "id") Integer id){
        System.out.println("resource xxx tecnologia.:"+id);
        return service.getById(id);
    }

    @CrossOrigin("*")
    @DeleteMapping(value = "tecnologia/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
