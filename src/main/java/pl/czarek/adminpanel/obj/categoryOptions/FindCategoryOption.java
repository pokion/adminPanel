package pl.czarek.adminpanel.obj.categoryOptions;

import pl.czarek.adminpanel.io.input;
import pl.czarek.adminpanel.io.output;
import pl.czarek.adminpanel.obj.Option;
import pl.czarek.adminpanel.service.CategoryService;

import java.util.Optional;

public class FindCategoryOption extends Option {

    private final CategoryService categoryService;

    public FindCategoryOption(CategoryService categoryService){
        super("find-category");

        this.categoryService = categoryService;
    }

    @Override
    public void execute() {
        output.napisz("Szukanie kategorii");

        int id = Integer.parseInt(input.zapytanie("Podaj id"));

        Optional<Category> category = categoryService.findCategory(id);
        if(category.isPresent()){
            output.napisz("id: "+category.get().getId());
            output.napisz("name: "+category.get().getName());
        }else {
            output.napisz("Nie znaleziono");
        }
    }
}
