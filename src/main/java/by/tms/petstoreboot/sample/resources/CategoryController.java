package by.tms.petstoreboot.sample.resources;

import by.tms.petstoreboot.sample.model.Category;
import by.tms.petstoreboot.sample.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@Valid
@RequestMapping(path = "/category")
public class CategoryController {

    private CategoryService categoryService;

    @GetMapping
    public List<Category> getCategories(){
        return categoryService.getCategories();
    }

    @GetMapping(path = "/{categoryId}")
    public Category findById(@PathVariable long categoryId){
        return categoryService.findCategoryById(categoryId);
    }

    @GetMapping(path = "/name/{categoryName}")
    public Category findByName(@PathVariable String categoryName){
        return categoryService.findCategoryByName(categoryName);
    }

    @PostMapping(path = "/add")
    public Category newCategory(@RequestBody Category category){
        return categoryService.addNewCategory(category);
    }

    @PutMapping(path = "/update")
    public Category updateCategory(@RequestBody Category category){
        return categoryService.updateCategory(category);
    }

    @DeleteMapping(path = "/{categoryId}")
    public Boolean deleteCategoryById(@PathVariable long categoryId){
        return categoryService.deleteCategory(categoryId);
    }

    @Autowired
    public void setCategoryService(CategoryService categoryService) {
        this.categoryService = categoryService;
    }
}
