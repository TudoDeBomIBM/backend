package br.com.ibm.tudodebom.controllers;

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
@RequestMapping("/produtos")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@PostMapping()
	public ResponseEntity<ResponseProductDTO> post(@Valid @RequestBody RequestProductDTO requestProductDTO){
		ResponseProductDTO responseProductDTO = productService.save(requestProductDTO);
		return ResponseEntity.ok(responseProductDTO);		
	}
	
	@GetMapping()
	public ResponseEntity<List<ResponseProductDTO>> get(ResponseProductDTO responseProductDTO){
		List<ResponseProductDTO> responseProductsDTO = productService.getAll();
		return ResponseEntity.ok(responseProductsDTO);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<ResponseProductDTO> put(@Valid @RequestBody RequestProductDTO requestProductDTO, @PathVariable Long id){
		ResponseProductDTO responseProductDTO = productService.update(requestProductDTO, id);
		return ResponseEntity.ok(responseProductDTO);
	}
	
	@DeleteMapping("/{id}")
	public  ResponseEntity<Void> delete(@PathVariable Long id){
		productService.delete(id);
		return ResponseEntity.noContent().build();
	}
		
	

}
