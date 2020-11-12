package pl.coderslab.charity.service;

import org.springframework.stereotype.Service;
import pl.coderslab.charity.entity.Category;
import pl.coderslab.charity.enums.CategoryEnum;
import pl.coderslab.charity.repository.CategoryRepository;
import pl.coderslab.charity.service.interfaces.CategoryInterface;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService implements CategoryInterface {
    
    private CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


    @Override
    public List<Category> getCategory() {
        List<Category> categoryList = new ArrayList<>();
        for (int i = 0; i < CategoryEnum.values().length; i++) {
            Category category = new Category();
            category.setName(CategoryEnum.values()[i].getName());
            categoryList.add(category);
        }
        return categoryList;
    }

    @Override
    public void saveCategory(List<Category> categoryList) {
    for (Category category : categoryList){
        categoryRepository.save(category);
    }
    }
}
