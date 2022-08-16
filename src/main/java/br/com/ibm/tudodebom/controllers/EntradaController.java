package br.com.ibm.tudodebom.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/entradas")
public class EntradaController {
	
	@Autowired
	private EntradaService entradaService;
	
	@PostMapping()
	public ResponseEntity<ResponseEntradaDTO> post(@Valid @RequestBody RequestEntradaDTO requestEntradaDTO){
		ResponseEntradaDTO responseEntradaDTO = entradaService.save(requestEntradaDTO);
		return ResponseEntity.ok(responseEntradaDTO);		
	}
	

}
