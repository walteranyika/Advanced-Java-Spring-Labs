package platform.codingnomads.co.springweb.gettingdatafromclient.requestbody.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import platform.codingnomads.co.springweb.gettingdatafromclient.requestbody.models.Fruit;

@Repository
public interface FruitRepository extends JpaRepository<Fruit, Long> {
}
