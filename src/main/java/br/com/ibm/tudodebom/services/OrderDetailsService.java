/*package br.com.ibm.tudodebom.services;

import java.math.BigDecimal;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.ibm.tudodebom.dtos.requests.RequestOrderDetailsDTO;
import br.com.ibm.tudodebom.dtos.requests.RequestProductDTO;
import br.com.ibm.tudodebom.entities.ProductEntity;
import br.com.ibm.tudodebom.repositorys.ProductRepository;

public class OrderDetailsService {
	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private ProductRepository productRepository;

	public RequestOrderDetailsDTO save(RequestOrderDetailsDTO requestOrderDetailsDTO, RequestProductDTO requestProductDTO) {
		BigDecimal porcentagem = new BigDecimal("0.8");
		BigDecimal quantidade = new BigDecimal(requestOrderDetailsDTO.getQuantity());

		if (requestProductDTO.getIsMedicine().equals(true) && requestProductDTO.getIsGeneric().equals(true)) {
			ProductEntity orderEntity = modelMapper.map(requestProductDTO, ProductEntity.class);
			ProductEntity savedEntity = productRepository.save(orderEntity);
			RequestOrderDetailsDTO map = modelMapper.map(savedEntity, RequestOrderDetailsDTO.class);
			BigDecimal result = porcentagem.multiply(requestOrderDetailsDTO.getUnityPrice())
					.multiply(quantidade);
			map.setTotalPrice(result);
			productRepository.save(modelMapper.map(map, ProductEntity.class));
			return map;
		}
		return requestOrderDetailsDTO;
}
}
*/