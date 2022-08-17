package br.com.ibm.tudodebom.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ibm.tudodebom.dtos.responses.ResponseOrderDTO;
import br.com.ibm.tudodebom.services.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;
    
    @GetMapping()
	public ResponseEntity<List<ResponseOrderDTO>> get() {
		List<ResponseOrderDTO> responseOrderDTO = orderService.getAll();
		return ResponseEntity.ok(responseOrderDTO);
	}

    @GetMapping("/{id}")
    public ResponseEntity<ResponseOrderDTO> getSaidaById(@PathVariable Long id) {
        ResponseOrderDTO responseOrderDTO = orderService.getById(id);
        return ResponseEntity.ok(responseOrderDTO);
    }
    
    @DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		orderService.delete(id);
		return ResponseEntity.noContent().build();
	}
    
    

    /*@PutMapping("/{idProduct}/orders")
    public ResponseEntity<Void> update(@RequestBody @Valid RequestOrderDTO request, @PathVariable Long idProduct) {
        orderService.update(request, idProduct);
        return ResponseEntity.noContent().build();
    }*/

}
