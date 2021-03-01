package by.tms.petstoreboot.sample.service;

import by.tms.petstoreboot.sample.model.Category;
import by.tms.petstoreboot.sample.resources.exceptions.CategoryExistsException;
import by.tms.petstoreboot.sample.resources.exceptions.CategoryNotFoundException;
import by.tms.petstoreboot.sample.resources.exceptions.InvalidIDSuppliedException;
import by.tms.petstoreboot.sample.resources.exceptions.ValidationException;
import by.tms.petstoreboot.sample.storage.CategoryStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    private CategoryStorage categoryStorage;

    public List<Category> getCategories() {
        return categoryStorage.getCategoryList();
    }

    public boolean contains(String name) {
        for (Category category : categoryStorage.getCategoryList()) {
            if (category.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public Category addNewCategory(Category category) {
        if (categoryStorage.getCategoryList().contains(category)) {
            throw new CategoryExistsException("This category exists");
        }
        categoryStorage.getCategoryList().add(category);
        return category;
    }

    public Category findCategoryById(long id) {
        for (Category category : categoryStorage.getCategoryList()) {
            if (category.getId() == id) {
                return category;
            }
        }
        throw new InvalidIDSuppliedException("Invalid ID supplied(category)");
    }

    public Category findCategoryByName(String name) {
        for (Category category : categoryStorage.getCategoryList()) {
            if (category.getName().equals(name)) {
                return category;
            }
        }
        throw new CategoryNotFoundException("Category not found");
    }

    public Category updateCategory(Category category) {
        for (Category c : categoryStorage.getCategoryList()) {
            if (c.getId() == category.getId()) {
                c.setName(category.getName());
                return c;
            }
        }
        throw new ValidationException("Validation exception(category)");
    }

    public Boolean deleteCategory(long id) {
        categoryStorage.getCategoryList().removeIf(category -> category.getId() == id);
        return true;
    }

    @Autowired
    public void setCategoryStorage(CategoryStorage categoryStorage) {
        this.categoryStorage = categoryStorage;
    }
}
