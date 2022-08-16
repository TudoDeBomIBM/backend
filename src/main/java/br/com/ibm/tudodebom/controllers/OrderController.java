package br.com.ibm.tudodebom.controllers;

import java.net.URI;

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
import br.com.ibm.tudodebom.dtos.requests.RequestOrderDetailsDTO;
import br.com.ibm.tudodebom.dtos.responses.ResponseOrderDTO;
import br.com.ibm.tudodebom.entities.OrderDetailsEntity;
import br.com.ibm.tudodebom.repositorys.OrderDetailsRepository;
import br.com.ibm.tudodebom.services.OrderDetailsService;
import br.com.ibm.tudodebom.services.OrderService;

@RestController
@RequestMapping("/products")
public class OrderController {

    @Autowired
    private OrderService orderService;
    
    @Autowired
    private OrderDetailsService orderDetailsService;

    @Autowired
    private OrderDetailsRepository orderDetailsRepository;

    @GetMapping("/{idProduct}/orders")
    public ResponseEntity<ResponseOrderDTO> getSaidaById(@PathVariable Long idProduct) {
        ResponseOrderDTO responseOrderDTO = orderService.getById(idProduct);
        return ResponseEntity.ok(responseOrderDTO);
    }
    
    @PostMapping
	public ResponseEntity<?> post(@Valid @RequestBody OrderDetailsEntity orderDetailsEntity, RequestOrderDetailsDTO requestOrderDetailsDTO, UriComponentsBuilder uriComponentsBuilder) {
		var responseOrderDetailsDTO = orderDetailsRepository.save(orderDetailsEntity);
		URI uri = uriComponentsBuilder.path("/{idProduct}/orders").buildAndExpand(responseOrderDetailsDTO.getId()).toUri();
		return ResponseEntity.created(uri).body(responseOrderDetailsDTO);
	}

    @PutMapping("/{idProduct}/orders")
    public ResponseEntity<Void> update(@RequestBody @Valid RequestOrderDTO request, @PathVariable Long idProduct) {
        orderService.update(request, idProduct);
        return ResponseEntity.noContent().build();
    }

}
