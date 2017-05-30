package ua.goit.startupserviceapp.service;

import org.springframework.stereotype.Service;
import ua.goit.startupserviceapp.model.Category;

import java.util.List;


public interface CategoryService {

    List<Category> getAllCategories();

    Category getCategoryById(long id);
}
