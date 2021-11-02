package com.pinhobrunodev.hrworker.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pinhobrunodev.hrworker.dto.WorkerDTO;
import com.pinhobrunodev.hrworker.services.WorkerService;

@RestController
@RequestMapping(value = "/workers")
public class WorkerResource {


    @Autowired
    private WorkerService service;

    @GetMapping(value = "/configs")
    public ResponseEntity<Void> getConfigs() {
        service.getConfigs();
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<WorkerDTO>> findAll() {
        return ResponseEntity.ok().body(service.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<WorkerDTO> findById(@PathVariable Long id) {

       //Sempre que chamar um worker pelo findById vai esperar 3s pra responder a req
       // Porem tempo de 3s Vai estourar o Timeout , ja que o balanceamento de Carga com Ribbon = 1s
        try {
           Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok().body(service.findById(id));
    }
}
