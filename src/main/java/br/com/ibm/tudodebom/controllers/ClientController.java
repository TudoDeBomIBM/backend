package br.com.ibm.tudodebom.controllers;

import java.net.URI;
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
import org.springframework.web.util.UriComponentsBuilder;

import br.com.ibm.tudodebom.dtos.requests.RequestClientDTO;
import br.com.ibm.tudodebom.dtos.responses.ResponseClientDTO;
import br.com.ibm.tudodebom.services.ClientService;

@RestController
@RequestMapping("/clients")
public class ClientController {
    @Autowired
    private ClientService clientService;

    @PostMapping
    public ResponseEntity<ResponseClientDTO> post(@Valid @RequestBody RequestClientDTO request, UriComponentsBuilder uriComponentsBuilder) {
        ResponseClientDTO responseClientDTO = clientService.save(request);
        URI uri = uriComponentsBuilder.path("/clients/{id}").buildAndExpand(responseClientDTO.getId()).toUri();
        return ResponseEntity.created(uri).body(responseClientDTO);
    }

    @GetMapping
    public ResponseEntity<List<ResponseClientDTO>> get(ResponseClientDTO response) {
        List<ResponseClientDTO> responseClientDTOS = clientService.get();
        return ResponseEntity.ok(responseClientDTOS);
    }
    
    @GetMapping("/{id}")
	public ResponseEntity<ResponseClientDTO> getClientById(@PathVariable Long id) {
		ResponseClientDTO responseClientDTO = clientService.getById(id);
		return ResponseEntity.ok(responseClientDTO);
	}

    @PutMapping("/{id}")
    public ResponseEntity<ResponseClientDTO> update(@RequestBody @Valid RequestClientDTO request, @PathVariable Long id) {
        clientService.update(request, id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        clientService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
