package br.com.ibm.tudodebom.services;

import br.com.ibm.tudodebom.dtos.requests.RequestOrderDTO;
import br.com.ibm.tudodebom.dtos.responses.ResponseOrderDTO;
import br.com.ibm.tudodebom.entities.OrderEntity;
import br.com.ibm.tudodebom.exceptions.OrderNotFoundException;
import br.com.ibm.tudodebom.repositorys.OrderRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private ModelMapper modelMapper;

	public ResponseOrderDTO getById(Long id) {
		OrderEntity orderEntity = orderRepository.findById(id).orElseThrow(OrderNotFoundException::new);
		return modelMapper.map(orderEntity, ResponseOrderDTO.class);
	}

	public ResponseOrderDTO update(RequestOrderDTO requestOrderDTO, Long id) {
		OrderEntity orderEntity = orderRepository.findById(id).orElseThrow(OrderNotFoundException::new);
		ResponseOrderDTO map = modelMapper.map(requestOrderDTO, ResponseOrderDTO.class);
		orderRepository.save(orderEntity);
		return map;
	}
}





