package by.tms.petstoreboot.sample.storage;

import by.tms.petstoreboot.sample.model.Category;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CategoryStorage {

    private final List<Category> categoryList = new ArrayList<>();

    public List<Category> getCategoryList(){
        return categoryList;
    }
}
