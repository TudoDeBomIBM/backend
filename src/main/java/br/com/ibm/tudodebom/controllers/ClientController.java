package br.com.ibm.tudodebom.controllers;


import br.com.ibm.tudodebom.dtos.requests.RequestClienteDTO;
import br.com.ibm.tudodebom.dtos.responses.ResponseClienteDTO;
import br.com.ibm.tudodebom.services.ClientService;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @PostMapping()
    public ResponseEntity<ResponseClienteDTO> post(@Valid @RequestBody RequestClienteDTO requestClienteDTO) {
        ResponseClienteDTO responseClienteDTO = clientService.save(requestClienteDTO);
        return ResponseEntity.ok(responseClienteDTO);
    }

    @GetMapping()
    public ResponseEntity<List<ResponseClienteDTO>> get(ResponseClienteDTO responseClienteDTO) {
        List<ResponseClienteDTO> responsesClienteDTO = clientService.getAll();
        return ResponseEntity.ok(responsesClienteDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseClienteDTO> getClientById(@PathVariable Long id) {
        ResponseClienteDTO responseClienteDTO = clientService.getById(id);
        return ResponseEntity.ok(responseClienteDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseClienteDTO> put(@Valid @RequestBody RequestClienteDTO requestClienteDTO, @PathVariable Long id) {
        ResponseClienteDTO responseClienteDTO = clientService.update(requestClienteDTO, id);
        return ResponseEntity.ok(responseClienteDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        clientService.delete(id);
        return ResponseEntity.noContent().build();
    }


}
