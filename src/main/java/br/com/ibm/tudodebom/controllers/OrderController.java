package br.com.ibm.tudodebom.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.ibm.tudodebom.dtos.requests.RequestOrderDTO;
import br.com.ibm.tudodebom.dtos.responses.ResponseOrderDTO;
import br.com.ibm.tudodebom.services.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/{idOrder}")
    public ResponseEntity<ResponseOrderDTO> getSaidaById(@PathVariable Long idOrder) {
        ResponseOrderDTO responseOrderDTO = orderService.getById(idOrder);
        return ResponseEntity.ok(responseOrderDTO);
    }
    
    @PostMapping
	public ResponseEntity<?> post(@Valid @RequestBody RequestOrderDTO requestOrderDTO, UriComponentsBuilder uriComponentsBuilder) {
		var responseOrderDTO = orderService.save(requestOrderDTO);
		//URI uri = uriComponentsBuilder.path("/{idProduct}/orders").buildAndExpand(responseOrderDTO.getId()).toUri();
		//return ResponseEntity.created(uri).body(responseOrderDTO);
		return ResponseEntity.ok(responseOrderDTO);
	}

    @PutMapping("/{idProduct}/orders")
    public ResponseEntity<Void> update(@RequestBody @Valid RequestOrderDTO request, @PathVariable Long idProduct) {
        orderService.update(request, idProduct);
        return ResponseEntity.noContent().build();
    }

}
