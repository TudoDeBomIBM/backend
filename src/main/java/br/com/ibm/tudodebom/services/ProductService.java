package br.com.ibm.tudodebom.services;

import br.com.ibm.tudodebom.dtos.requests.RequestProductDTO;
import br.com.ibm.tudodebom.dtos.responses.ResponseProductDTO;
import br.com.ibm.tudodebom.entities.ProductEntity;
import br.com.ibm.tudodebom.exceptions.ProductNotFoundException;
import br.com.ibm.tudodebom.repositorys.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {
	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private ModelMapper modelMapper;

	public ResponseProductDTO save(RequestProductDTO requestProductDTO) {
		BigDecimal porcentagem = new BigDecimal("0.8") ;
		BigDecimal quantidade = new BigDecimal(requestProductDTO.getPedido().getQuantidade());

		if (requestProductDTO.getIsMedicine().equals(true) && requestProductDTO.getIsGeneric().equals(true)) {
			ProductEntity orderEntity = modelMapper.map(requestProductDTO, ProductEntity.class);
			ProductEntity savedEntity = productRepository.save(orderEntity);
			ResponseProductDTO map = modelMapper.map(savedEntity, ResponseProductDTO.class);
			BigDecimal result =  porcentagem.multiply(requestProductDTO.getPedido().getPrecoUnitario()).multiply(quantidade);
			map.getPedido().setValorFinal(result);
			productRepository.save(modelMapper.map(map, ProductEntity.class));
			return map;
		}
		ProductEntity orderEntity = modelMapper.map(requestProductDTO, ProductEntity.class);
		ProductEntity savedEntity = productRepository.save(orderEntity);
		ResponseProductDTO map = modelMapper.map(savedEntity, ResponseProductDTO.class);

		map.getPedido().setValorFinal(requestProductDTO.getPedido().getPrecoUnitario().multiply(quantidade));
		productRepository.save(modelMapper.map(map, ProductEntity.class));
		return map;
	}

	public List<ResponseProductDTO> getAll() {
		List<ProductEntity> allClients = productRepository.findAll();
		List<ResponseProductDTO> dtos = allClients.stream().map(productEntity ->
				modelMapper.map(productEntity, ResponseProductDTO.class)).collect(Collectors.toList());
		return dtos;
	}

	public ResponseProductDTO getById(Long id){
		ProductEntity productEntity = productRepository.findById(id).orElseThrow(ProductNotFoundException::new);
		return modelMapper.map(productEntity, ResponseProductDTO.class);
	}

	public ResponseProductDTO update(RequestProductDTO requestProductDTO, Long id) {
		ProductEntity productEntity = productRepository.findById(id).orElseThrow(ProductNotFoundException::new);
		ResponseProductDTO map = modelMapper.map(requestProductDTO, ResponseProductDTO.class);
		productRepository.save(productEntity);
		return map;
	}

	public void delete(@PathVariable Long id) {
		productRepository.findById(id).orElseThrow(ProductNotFoundException::new);
		productRepository.deleteById(id);
	}
}