package com.jhone.estudos.config;

import com.jhone.estudos.services.DBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration

public class DevConfig {

    @Autowired
    private DBService dbService;


    @Bean
    public boolean instanciaDB() {
        this.dbService.instanciaDB();
        return true;
    }
}
