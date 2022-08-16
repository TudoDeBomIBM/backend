package br.com.ibm.tudodebom.controllers;

import br.com.ibm.tudodebom.dtos.requests.RequestInputDTO;
import br.com.ibm.tudodebom.dtos.responses.ResponseInputDTO;
import br.com.ibm.tudodebom.services.InputService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/products")
public class InputController {

    @Autowired
    private InputService inputService;

    @GetMapping("/{idProduct}/inputs")
    public ResponseEntity<ResponseInputDTO> getProductById(@PathVariable Long idProduct) {
        ResponseInputDTO responseInputDTO = inputService.getById(idProduct);
        return ResponseEntity.ok(responseInputDTO);
    }

    @PutMapping("/{idProduct}/inputs")
    public ResponseEntity<Void> put(@Valid @RequestBody RequestInputDTO requestInputDTO, @PathVariable Long idProduct) {
        inputService.update(requestInputDTO, idProduct);
        return ResponseEntity.noContent().build();
    }

}
