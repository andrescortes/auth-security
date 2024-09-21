package com.app.auth.service.impl;

import com.app.auth.dto.SaveCategory;
import com.app.auth.exception.ObjectNotFoundException;
import com.app.auth.persistence.entity.Category;
import com.app.auth.persistence.repository.CategoryRepository;
import com.app.auth.service.CategoryService;
import com.app.auth.util.Constants;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {


    private final CategoryRepository categoryRepository;

    @Override
    public Page<Category> findAll(Pageable pageable) {
        return categoryRepository.findAll(pageable);
    }

    @Override
    public Optional<Category> findOneById(Long categoryId) {
        return categoryRepository.findById(categoryId);
    }

    @Override
    public Category createOne(SaveCategory saveCategory) {

        Category category = new Category();
        category.setName(saveCategory.getName());
        category.setStatus(Category.CategoryStatus.ENABLED);

        return categoryRepository.save(category);
    }

    @Override
    public Category updateOneById(Long categoryId, SaveCategory saveCategory) {
        Category categoryFromDB = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ObjectNotFoundException(Constants.CATEGORY_NOT_FOUND_WITH_ID + categoryId));

        categoryFromDB.setName(saveCategory.getName());

        return categoryRepository.save(categoryFromDB);
    }

    @Override
    public Category disableOneById(Long categoryId) {
        Category categoryFromDB = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ObjectNotFoundException(Constants.CATEGORY_NOT_FOUND_WITH_ID + categoryId));

        categoryFromDB.setStatus(Category.CategoryStatus.DISABLED);

        return categoryRepository.save(categoryFromDB);
    }
}
