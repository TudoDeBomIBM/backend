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
@RequestMapping("/entradas")
public class EntradaController {

	@Autowired
	private EntradaService entradaService;

	@PostMapping()
	public ResponseEntity<ResponseEntradaDTO> post(@Valid @RequestBody RequestEntradaDTO requestEntradaDTO) {
		ResponseEntradaDTO responseEntradaDTO = entradaService.save(requestEntradaDTO);
		return ResponseEntity.ok(responseEntradaDTO);
	}

	@GetMapping()
	public ResponseEntity<List<ResponseEntradaDTO>> get(ResponseEntradaDTO responseEntradaDTO) {
		List<ResponseEntradaDTO> responseentradasDTO = entradaService.getAll();
		return ResponseEntity.ok(responseEntradaDTO);
	}

	@PutMapping("/{id}")
	public ResponseEntity<ResponseEntradaDTO> put(@Valid @RequestBody RequestEntradaDTO requestEntradaDTO,
			@PathVariable Long id) {
		ResponseEntradaDTO responseEntradaDTO = entradaService.update(requestEntradaDTO, id);
		return ResponseEntity.ok(responseEntradaDTO);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		entradaService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
