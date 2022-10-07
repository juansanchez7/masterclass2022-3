package co.usa.reto3.Reto3.controller;

import co.usa.reto3.Reto3.entities.Category;
import co.usa.reto3.Reto3.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/Category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/all")
    public List<Category> getAll() {
        return categoryService.getAll();
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Category save(@RequestBody Category g) {
        return categoryService.save(g);
    }
}
