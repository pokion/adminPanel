package pl.czarek.adminpanel.obj.categoryOptions;

import pl.czarek.adminpanel.obj.Option;
import pl.czarek.adminpanel.obj.productOptions.Product;
import pl.czarek.adminpanel.service.CategoryService;

import java.util.ArrayList;
import java.util.Optional;

public class FindAllCategoryOption extends Option {

    private  final CategoryService categoryService;

    public FindAllCategoryOption(CategoryService categoryService){
        super("findAll-category");

        this.categoryService = categoryService;
    }

    @Override
    public void execute() {
        System.out.println("Wszystkie category");

        Optional<ArrayList<Category>> categories = this.categoryService.findAll();

        for (Category category:
                categories.get()) {
            System.out.println(
                            "id: "+category.getId()+", " +
                            "name: "+category.getName()
            );
        }
    }
}
