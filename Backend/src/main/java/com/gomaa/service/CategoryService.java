package com.ahmed.service;

import com.ahmed.deo.CategoryRepository;
import com.ahmed.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CategoryService {
    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> allCategories(){
        return categoryRepository.findAll();
    }
}
