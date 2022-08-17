package br.com.ibm.tudodebom.services;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.ibm.tudodebom.dtos.requests.RequestOrderDTO;
import br.com.ibm.tudodebom.dtos.requests.RequestOrderDetailsDTO;
import br.com.ibm.tudodebom.dtos.responses.ResponseOrderDTO;
import br.com.ibm.tudodebom.entities.OrderDetailsEntity;
import br.com.ibm.tudodebom.entities.OrderEntity;
import br.com.ibm.tudodebom.entities.ProductEntity;
import br.com.ibm.tudodebom.exceptions.OrderNotFoundException;
import br.com.ibm.tudodebom.exceptions.ProductNotFoundException;
import br.com.ibm.tudodebom.repositorys.OrderDetailsRepository;
import br.com.ibm.tudodebom.repositorys.OrderRepository;
import br.com.ibm.tudodebom.repositorys.ProductRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private OrderDetailsRepository orderDetailsRepository;

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

	public Long save(RequestOrderDTO requestOrderDTO) {
        BigDecimal total = new BigDecimal(0.0);
        List<RequestOrderDetailsDTO> orderDetails = requestOrderDTO.getOrderDetails();
        for (int i = 0; i < orderDetails.size(); i++) {
            BigDecimal porcentagem = new BigDecimal("0.8");
            BigDecimal quantidade = new BigDecimal(orderDetails.get(i).getQuantity());
            ProductEntity product = productRepository.findById(orderDetails.get(i).getProduct().getId())
                    .orElseThrow(ProductNotFoundException::new);
            if (product.getIsMedicine().equals(true) && product.getIsGeneric().equals(true)) {
                BigDecimal result = porcentagem.multiply(orderDetails.get(i).getUnityPrice()).multiply(quantidade);
                orderDetails.get(i).setTotalPrice(result);
                total = total.add(result);
            } else {
                BigDecimal result2 = orderDetails.get(i).getUnityPrice().multiply(quantidade);
                orderDetails.get(i).setTotalPrice(result2);
                total = total.add(result2);
            }
        }
        requestOrderDTO.setOrderPrice(total);
        OrderEntity mapEntity = modelMapper.map(requestOrderDTO, OrderEntity.class);
        mapEntity = orderRepository.saveAndFlush(mapEntity);
        List<OrderDetailsEntity> mapDetailsEntity = requestOrderDTO.getOrderDetails().stream()
                .map(orderDetail -> modelMapper.map(orderDetail, OrderDetailsEntity.class))
                .collect(Collectors.toList());
        OrderEntity order = mapEntity;
        mapDetailsEntity.forEach(f -> f.setOrder(order));
        mapDetailsEntity = orderDetailsRepository.saveAllAndFlush(mapDetailsEntity);
        return mapEntity.getId();
    }
	
	public List<ResponseOrderDTO> getAll() {
		List<OrderEntity> allOrders = orderRepository.findAll();
		List<ResponseOrderDTO> dtos = Arrays.asList();
		if (allOrders.size() > 0) {
			dtos = allOrders.stream().map(orderEntity -> modelMapper.map(orderEntity, ResponseOrderDTO.class))
					.collect(Collectors.toList());

		}
		return dtos;
	}
	
	public void delete(@PathVariable Long id) {
		orderRepository.findById(id).orElseThrow(OrderNotFoundException::new);
		orderRepository.deleteById(id);
	}

}
