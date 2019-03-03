package fi.product.ProductApplication.domain;

import fi.product.ProductApplication.domain.User;
import org.springframework.data.repository.CrudRepository;
 
public interface UserRepository extends CrudRepository<User, Integer> {
    User findByName(String name);
}
