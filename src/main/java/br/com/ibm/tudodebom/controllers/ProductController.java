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

import br.com.ibm.tudodebom.dtos.requests.RequestProductDTO;
import br.com.ibm.tudodebom.dtos.responses.ResponseProductDTO;
import br.com.ibm.tudodebom.services.ProductService;


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
        boolean resultado = productService.update(requestProductDTO, id);
        if(resultado) {
            ResponseProductDTO responseProductDTO = productService.getById(id);
            return ResponseEntity.ok(responseProductDTO);
        }
        return ResponseEntity.notFound().build();
    }
   

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		productService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
