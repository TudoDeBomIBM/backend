package br.com.ibm.tudodebom.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.ibm.tudodebom.repositorys.ProdutoRepository;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	public ResponseProdutoDTO save(RequestProdutoDTO requestProdutoDTO) {
		// fazendo a requisição
		ProdutoEntity entity = modelMapper.map(requestProdutoDTO, ProdutoEntity.class);
		// salvando no BD
		ProdutoEntity produtoSaved = ProdutoRepository.save(entity);
		// retornando e transformando num response
		return modelMapper.map(produtoSaved, ResponseProdutoDTO.class);
	}
	
	public List<ResponseProdutoDTO> getAll() {
		// usando o método do jpa findAll() para obter todos os produtos salvos
		List<ProdutoEntity> allProdutos = produtoRepository.findAll();
		
		List<ResponseProdutoDTO> dtos = allProdutos.Stream().map(produtoEntity ->
				modelMapper.map(produtoEntity, ResponseProdutoDTO.class)).collect(Collectors.toList());
		return dtos;
	}
	
	public ResponseProdutoDTO getById(Long id) {
		ProdutoEntity produtoEntity = produtoRepository.findById(id).orElseThrow(ProdutoNotFoundException::new);
		return modelMapper.map(produtoEntity, ResponseProdutoDTO.class);
	}
	
	public ResponseProdutoDTO update(Long id) {
		ProdutoEntity produtoEntity = produtoRepository.findById(id).orElseThrow(ProdutoNotFoundException::new);
		ResponseProdutoDTO map = modelMapper.map(produtoEntity, ResponseProdutoDTO.class);
		produtoRepository.save(produtoEntity);
		return map;
	}
	
	public ResponseProdutoDTO delete(@PathVariable Long id) {
		produtoRepository.findById(id).orElseThrow(ProdutoNotFoundException::new);
		produtoRepository.deleteById(id);
	}
	
}
