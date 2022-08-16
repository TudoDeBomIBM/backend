package br.com.ibm.tudodebom.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @PostMapping()
    public ResponseEntity<ResponsePedidoDTO> post(@Valid @RequestBody RequestPedidoDTO requestPedidoDTO) {
        ResponsePedidoDTO responsePedidoDTO = pedidoService.save(requestPedidoDTO);
        return ResponseEntity.ok(responsePedidoDTO);
    }

    @GetMapping()
    public ResponseEntity<ResponsePedidoDTO> get(ResponsePedidoDTO responsePedidoDTO) {
        List<ResponsePedidoDTO> responsePedidoDTO = pedidoService.getAll();
        return ResponseEntity.ok(responsePedidoDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResposePedidoDTO> put(@Valid @ResponseBody RequestPedidoDTO requestPedidoDTO, @PathVariable Long id) {
        ResponsePedidoDTO responsePedidoDTO = pedidoService.update(requestPedidoDTO, id);
        return ResponseEntity.ok(responsePedidoDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        pedidoService.delete(id);
        return ResponseEntity.noContent().build();
    }


}
