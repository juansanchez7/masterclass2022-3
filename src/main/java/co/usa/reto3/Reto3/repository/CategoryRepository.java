package co.usa.reto3.Reto3.repository;

import co.usa.reto3.Reto3.entities.Category;
import co.usa.reto3.Reto3.repository.crudRepository.CategoryCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public class CategoryRepository {

    @Autowired
    private CategoryCrudRepository categoryCrudRepository;

    public List<Category> getAll(){
        return (List<Category>)categoryCrudRepository.findAll();
    }

    public Optional<Category> getCategory(int id){
        return categoryCrudRepository.findById(id);
    }

    public Category save(Category g){
        return categoryCrudRepository.save(g);
    }

    public void delete(Category g){categoryCrudRepository.delete(g);
    }
}