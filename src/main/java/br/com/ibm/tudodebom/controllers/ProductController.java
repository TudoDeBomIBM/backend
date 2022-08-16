package br.com.ibm.tudodebom.controllers;

import br.com.ibm.tudodebom.dtos.requests.RequestProductDTO;
import br.com.ibm.tudodebom.dtos.responses.ResponseProductDTO;
import br.com.ibm.tudodebom.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;


@RestController
@RequestMapping("/products")
public class ProductController {
	@Autowired
	private ProductService productService;

	@PostMapping
	public ResponseEntity<ResponseProductDTO> post(@Valid @RequestBody RequestProductDTO requestProductDTO, UriComponentsBuilder uriComponentsBuilder) {
		ResponseProductDTO responseProductDTO = productService.save(requestProductDTO);
		URI uri = uriComponentsBuilder.path("/products/{id}").buildAndExpand(responseProductDTO.getId()).toUri();
		return ResponseEntity.created(uri).body(responseProductDTO);
	}
	@GetMapping()
	public ResponseEntity<List<ResponseProductDTO>> get() {
		List<ResponseProductDTO> responsesProductDTO = productService.getAll();
		return ResponseEntity.ok(responsesProductDTO);
	}

	@GetMapping("/{id}")
	public ResponseEntity<ResponseProductDTO> getProductById(@PathVariable Long id) {
		ResponseProductDTO responseProductDTO = productService.getById(id);
		return ResponseEntity.ok(responseProductDTO);
	}

	@PutMapping("/{id}")
	public ResponseEntity<ResponseProductDTO> put(@Valid @RequestBody RequestProductDTO requestProductDTO, @PathVariable Long id) {
		ResponseProductDTO responseProductDTO = productService.update(requestProductDTO, id);
		return ResponseEntity.ok(responseProductDTO);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		productService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
