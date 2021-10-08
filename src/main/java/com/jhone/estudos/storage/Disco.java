package com.jhone.estudos.storage;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Component
public class Disco {
    @Value("C:/Users/Jhone/Documents/front/estudos/src")
    private String raiz;

    @Value("assets")
    private String diretorio;

    public void SalvarArquivos(MultipartFile arquivoP){
        System.out.println("no disco this.diretorio.:"+this.diretorio);
        System.out.println("no disco arquivoP.:"+arquivoP);
        this.salvar(this.diretorio,arquivoP);
    }

    private void salvar(String diretorio, MultipartFile arquivo) {
        Path diretorioPath = Paths.get(this.raiz,diretorio);
        Path arquivoPath   = diretorioPath.resolve(arquivo.getOriginalFilename());
        System.out.println("no disco diretorioPath.:"+diretorioPath);
        System.out.println("no disco arquivoPath.:"+arquivoPath);
        try {
            Files.createDirectories(diretorioPath);
            arquivo.transferTo(arquivoPath.toFile());
        }
        catch (IOException e){
            throw  new RuntimeException("Houve um problema na tentativa de salvar o arquivo "+e);
        }
    }


}
