package pl.coderslab.charity.service.interfaces;


import pl.coderslab.charity.entity.Category;
import pl.coderslab.charity.entity.Institution;

import java.util.List;

public interface CategoryInterface {

    List<Category> getCategory();
    void saveCategory(List<Category> categoryList);
}
