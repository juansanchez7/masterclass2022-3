package co.usa.reto3.Reto3.repository;

import co.usa.reto3.Reto3.entities.Product;
import co.usa.reto3.Reto3.repository.crudRepository.ProductCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public class ProductRepository {

    @Autowired
    private ProductCrudRepository productCrudRepository;

    public List<Product> getAll(){
        return (List<Product>)productCrudRepository.findAll();
    }

    public Optional<Product>getProduct(int id){
        return productCrudRepository.findById(id);
    }

    public Product save(Product g){
        return productCrudRepository.save(g);
    }

    public void delete(Product g){productCrudRepository.delete(g);
    }
}