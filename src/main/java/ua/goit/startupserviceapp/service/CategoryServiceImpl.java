package ua.goit.startupserviceapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.goit.startupserviceapp.model.Category;
import ua.goit.startupserviceapp.repository.CategoryRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category getCategoryById(long id) {
        return categoryRepository.getOne(id);
    }

    @Override
    public List<String> getAllCategoryNames() {

        List<String> categoryNames;

        categoryNames = this.getAllCategories().stream()
                .map(Category::getName)
                .collect(Collectors.toList());

        return categoryNames;
    }

    @Override
    public Category getCategoryByName(String name) {
        return this.categoryRepository.findByName(name);
    }
}
