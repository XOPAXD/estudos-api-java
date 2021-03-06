package com.jhone.estudos.resources;

import com.jhone.estudos.dominio.Quadrinhos;
import com.jhone.estudos.message.ResponseMessage;
import com.jhone.estudos.services.QuadrinhosService;
import com.jhone.estudos.storage.Disco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping(value = "/estudos")
public class QuadrinhosResource {

    @Autowired
    private QuadrinhosService service;

    @Autowired
    private Disco disco;

    @CrossOrigin("*")
    @GetMapping(value = "/quadrinhos")
    public List<Quadrinhos> findAll(){
        return  service.findAll();
    }

    @CrossOrigin("*")
    @PostMapping(value = "/quadrinho")
    public Quadrinhos createquadrinho(@RequestBody Quadrinhos obj) {
        System.out.println("resource quadrinho.:"+obj.getNome());
        service.create(obj);
        return obj;
    }

    @CrossOrigin("*")
    @PostMapping("/upload")
    public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file) {
        String message = "";
        try {
            disco.SalvarArquivos(file);

            message = "Uploaded the file successfully: " + file.getOriginalFilename();
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
        } catch (Exception e) {
            message = "Could not upload the file: " + file.getOriginalFilename() + "!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message+' '+e));
        }
    }
}
