package com.arpita.week2.hibernatecrud.service;

import java.util.List;
import com.arpita.week2.hibernatecrud.dto.CategoryDTO;
import com.arpita.week2.hibernatecrud.model.Category;

public interface CategoryService {
    List<Category> getAllCategories();
    Category getCategoryById(Long id);
    Category createCategory(CategoryDTO categoryDTO);
    Category updateCategory(Long id, CategoryDTO categoryDTO);
    void deleteCategory(Long id);
}
