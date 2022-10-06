package co.usa.reto3.Reto3.service;

import co.usa.reto3.Reto3.entities.Category;
import co.usa.reto3.Reto3.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getAll() {
        return categoryRepository.getAll();
    }

    public Optional<Category> getCategory(int id) {
        return categoryRepository.getCategory(id);
    }

    public Category save(Category g) {
        if (g.getId() == null) {
            return categoryRepository.save(g);
        } else {
            Optional<Category> gaux = categoryRepository.getCategory(g.getId());
            if (gaux.isPresent()) {
                return g;
            } else {
                return categoryRepository.save(g);
            }
        }

    }

    public Category update(Category g) {
        if (g.getId() != null) {
            Optional<Category> q = categoryRepository.getCategory(g.getId());
            if (q.isPresent()) {
                if (g.getName() != null) {
                    q.get().setName(g.getName());
                }
                if (g.getDescription() != null) {
                    q.get().setDescription(g.getDescription());
                }
                categoryRepository.save(q.get());
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
        Optional<Category> g = categoryRepository.getCategory(id);
        if (g.isPresent()) {
            categoryRepository.delete(g.get());
            flag = true;
        }
        return flag;
    }


}

