package com.jhone.estudos.services;

import com.jhone.estudos.dominio.Aluno;
import com.jhone.estudos.dominio.Tecnologias;
import com.jhone.estudos.repositories.AlunoRepository;
import com.jhone.estudos.repositories.TecnologiasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Arrays;

@Service
public class DBService {
    @Autowired
    private TecnologiasRepository tecrepository;
    @Autowired
    private AlunoRepository alunorepository;

    public void instanciaDB() {

        Tecnologias t1 = new Tecnologias(null, "JAVA", "tecnologia top só para fera",LocalDateTime.now());
        Tecnologias t2 = new Tecnologias(null, "PHP", "tecnologia mais ou menos",LocalDateTime.now());
        Tecnologias t3 = new Tecnologias(null, "PHYTON", "tecnologia que não conheço ainda",LocalDateTime.now());
        Tecnologias t4 = new Tecnologias(null, "ANGULAR", "front end show de bola!",LocalDateTime.now());

        tecrepository.saveAll(Arrays.asList(t1, t2,t3,t4));

    }
}
