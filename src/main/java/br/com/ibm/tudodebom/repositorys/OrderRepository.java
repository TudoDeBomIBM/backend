package br.com.ibm.tudodebom.repositorys;

import br.com.ibm.tudodebom.entities.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Long>{

}
