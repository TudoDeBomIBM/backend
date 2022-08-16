package br.com.ibm.tudodebom.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ibm.tudodebom.dtos.requests.RequestClientDTO;
import br.com.ibm.tudodebom.dtos.responses.ResponseClientDTO;
import br.com.ibm.tudodebom.entities.ClientEntity;
import br.com.ibm.tudodebom.exceptions.ClientNotFoundException;
import br.com.ibm.tudodebom.repositorys.ClientRepository;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ModelMapper modelMapper;

    public ResponseClientDTO save(RequestClientDTO requestClientDTO) {
        ClientEntity entity = modelMapper.map(requestClientDTO, ClientEntity.class);
        ClientEntity saved = clientRepository.save(entity);
        return modelMapper.map(saved, ResponseClientDTO.class);
    }

    public List<ResponseClientDTO> get() {
        List<ClientEntity> allClients = clientRepository.findAll();
        List<ResponseClientDTO> dtos = allClients.stream().map(clientEntity ->
                modelMapper.map(clientEntity, ResponseClientDTO.class)).collect(Collectors.toList());
        return dtos;
    }

    public void delete(Long id) {
        clientRepository.findById(id);
        clientRepository.deleteById(id);
    }

    public void update(RequestClientDTO request, Long id) {
        ClientEntity clientEntity = clientRepository.findById(id).orElse(null);
        modelMapper.map(request, clientEntity);
        clientRepository.save(clientEntity);
    }

	public ResponseClientDTO getById(Long id){
		ClientEntity clientEntity = clientRepository.findById(id).orElseThrow(ClientNotFoundException::new);
		return modelMapper.map(clientEntity, ResponseClientDTO.class);
	}
}




