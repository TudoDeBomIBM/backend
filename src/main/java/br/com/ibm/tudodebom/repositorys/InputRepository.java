package br.com.ibm.tudodebom.repositorys;

import br.com.ibm.tudodebom.entities.InputEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InputRepository extends JpaRepository<InputEntity, Long> {
}

