package br.com.ibm.tudodebom.repositorys;

import br.com.ibm.tudodebom.entities.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<ClienteEntity, Long> {
}
