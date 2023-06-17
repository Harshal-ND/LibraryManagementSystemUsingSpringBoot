package com.lms.librarymanagementsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lms.librarymanagementsystem.model.Category;
import com.lms.librarymanagementsystem.repository.CategoryRepository;

@Service
public class CategoryService {
    
    @Autowired
    public CategoryRepository categoryRepository;

    public List<Category> viewAllCategory()
    {
        return this.categoryRepository.findAll();
    }

    public Category getCategoryById(Integer id) {
        return categoryRepository.findById(id).get();
    }

    
    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }

    
    public Category updateCategory(Integer id, Category category) {
        Category existingCategory = categoryRepository.findById(id).get();
        // Update other fields as needed

        return categoryRepository.save(existingCategory);
    }

   
    public void deleteCategory(Integer id) {
        categoryRepository.deleteById(id);
    }
}
