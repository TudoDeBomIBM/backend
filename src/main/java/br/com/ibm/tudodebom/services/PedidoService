package br.com.ibm.tudodebom.services;

import br.com.ibm.tudodebom.dtos.requests.RequestPedidoDTO;
import br.com.ibm.tudodebom.dtos.responses.ResponsePedidoDTO;
import br.com.ibm.tudodebom.entities.PedidoEntity;
import br.com.ibm.tudodebom.exceptions.PedidoNotFoundException;
import br.com.ibm.tudodebom.repositorys.PedidoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.stream.Collectors;

public class PedidoService {

	@Autowired
	private PedidoRepository pedidoRepository;

	@Autowired
	private ModelMapper modelMapper;

	public ResponsePedidoDTO save(RequestPedidoDTO requestPedidoDTO) {
		// fazendo a requisição
		PedidoEntity entity = modelMapper.map(requestPedidoDTO, PedidoEntity.class);
		// salvando no BD
		PedidoEntity pedidoSaved = pedidoRepository.save(entity);
		// retornando e transformando num response
		return modelMapper.map(pedidoSaved, ResponsePedidoDTO.class);
	}

	public List<ResponsePedidoDTO> getAll() {
		// usando o método do JpaRepository (findAll()) para obter todos os clientes
		// salvos
		List<PedidoEntity> allClients = pedidoRepository.findAll();

		List<ResponsePedidoDTO> dtos = allClients.stream()
				.map(pedidoEntity -> modelMapper.map(pedidoEntity, ResponsePedidoDTO.class))
				.collect(Collectors.toList());
		return dtos;
	}

	public ResponsePedidoDTO getById(Long id) {
		PedidoEntity pedidoEntity = pedidoRepository.findById(id).orElseThrow(PedidoNotFoundException::new);
		return modelMapper.map(pedidoEntity, ResponsePedidoDTO.class);
	}

	public ResponsePedidoDTO update(RequestPedidoDTO requestPedidoDTO, Long id) {
		PedidoEntity pedidoEntity = pedidoRepository.findById(id).orElseThrow(PedidoNotFoundException::new);
		ResponsePedidoDTO map = modelMapper.map(requestPedidoDTO, ResponsePedidoDTO.class);
		pedidoRepository.save(pedidoEntity);
		return map;
	}

	public void delete(@PathVariable Long id) {
		pedidoRepository.findById(id).orElseThrow(PedidoNotFoundException::new);
		pedidoRepository.deleteById(id);
	}
}
