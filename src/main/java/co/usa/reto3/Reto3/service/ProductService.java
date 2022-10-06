package co.usa.reto3.Reto3.service;

import co.usa.reto3.Reto3.entities.Product;
import co.usa.reto3.Reto3.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAll() {
        return productRepository.getAll();
    }

    public Optional<Product> getProduct(int id) {
        return productRepository.getProduct(id);
    }

    public Product save(Product g) {
        if (g.getId() == null) {
            return productRepository.save(g);
        } else {
            Optional<Product> gaux = productRepository.getProduct(g.getId());
            if (gaux.isPresent()) {
                return g;
            } else {
                return productRepository.save(g);
            }
        }

    }

    public Product update(Product g) {
        if (g.getId() != null) {
            Optional<Product> q = productRepository.getProduct(g.getId());
            if (q.isPresent()) {
                if (g.getName() != null) {
                    q.get().setName(g.getName());
                }
                if (g.getYear() != null) {
                    q.get().setYear(g.getYear());
                }
                productRepository.save(q.get());
                return q.get();
            } else {
                return g;
            }
        } else {
            return g;
        }
    }

        public boolean delete ( int id){
            boolean flag = false;
            Optional<Product> g = productRepository.getProduct(id);
            if (g.isPresent()) {
                productRepository.delete(g.get());
                flag = true;
            }
            return flag;
        }


}

