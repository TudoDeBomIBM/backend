package br.com.ibm.tudodebom.services;

import br.com.ibm.tudodebom.dtos.requests.RequestInputDTO;
import br.com.ibm.tudodebom.dtos.responses.ResponseInputDTO;
import br.com.ibm.tudodebom.entities.InputEntity;
import br.com.ibm.tudodebom.entities.ProductEntity;
import br.com.ibm.tudodebom.exceptions.ProductNotFoundException;
import br.com.ibm.tudodebom.repositorys.InputRepository;
import br.com.ibm.tudodebom.repositorys.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InputService {

    @Autowired
    private InputRepository inputRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ModelMapper modelMapper;

    public ResponseInputDTO getById(Long idProduto){
        ProductEntity product = productRepository.findById(idProduto).orElseThrow(ProductNotFoundException::new);
        InputEntity input = product.getEntrada();
        return modelMapper.map(input, ResponseInputDTO.class);
    }

    public void update(RequestInputDTO requestInputDTO, Long idProduto) {
        ProductEntity product = productRepository.findById(idProduto).orElseThrow(ProductNotFoundException::new);
        InputEntity input = product.getEntrada();
        modelMapper.map(requestInputDTO, input);
        inputRepository.save(input);
    }

}
