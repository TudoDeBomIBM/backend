package br.com.ibm.tudodebom.services;

import br.com.ibm.tudodebom.dtos.requests.RequestClienteDTO;
import br.com.ibm.tudodebom.dtos.responses.ResponseClienteDTO;
import br.com.ibm.tudodebom.entities.ClienteEntity;
import br.com.ibm.tudodebom.exceptions.ClientNotFoundException;
import br.com.ibm.tudodebom.repositorys.ClientRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ModelMapper modelMapper;

    public ResponseClienteDTO save(RequestClienteDTO requestClienteDTO) {
        //fazendo a requisição
        ClienteEntity entity = modelMapper.map(requestClienteDTO, ClienteEntity.class);
        //salvando no BD
        ClienteEntity clienteSaved = clientRepository.save(entity);
        //retornando e transformando num response
        return modelMapper.map(clienteSaved, ResponseClienteDTO.class);
    }

    public List<ResponseClienteDTO> getAll() {
        //usando o método do JpaRepository (findAll()) para obter todos os clientes salvos
        List<ClienteEntity> allClients = clientRepository.findAll();

        List<ResponseClienteDTO> dtos = allClients.stream().map(clienteEntity ->
                modelMapper.map(clienteEntity, ResponseClienteDTO.class)).collect(Collectors.toList());
        return dtos;
    }

    public ResponseClienteDTO getById(Long id){
        ClienteEntity clienteEntity = clientRepository.findById(id).orElseThrow(ClientNotFoundException::new);
        return modelMapper.map(clienteEntity, ResponseClienteDTO.class);
    }


    public ResponseClienteDTO update(RequestClienteDTO requestClienteDTO, Long id) {
        ClienteEntity clienteEntity = clientRepository.findById(id).orElseThrow(ClientNotFoundException::new);
        ResponseClienteDTO map = modelMapper.map(requestClienteDTO, ResponseClienteDTO.class);
        clientRepository.save(clienteEntity);
        return map;
    }

    public void delete(@PathVariable Long id) {
        clientRepository.findById(id).orElseThrow(ClientNotFoundException::new);
        clientRepository.deleteById(id);
    }

}
