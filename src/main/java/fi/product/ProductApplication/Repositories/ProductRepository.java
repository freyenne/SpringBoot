package fi.product.ProductApplication.Repositories;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

import fi.product.ProductApplication.Model.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {

    List<Product> findProductName(String name);
    
}