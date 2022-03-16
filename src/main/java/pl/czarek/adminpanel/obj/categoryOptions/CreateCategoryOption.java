package pl.czarek.adminpanel.obj.categoryOptions;

import pl.czarek.adminpanel.io.input;
import pl.czarek.adminpanel.io.output;
import pl.czarek.adminpanel.obj.Option;
import pl.czarek.adminpanel.service.CategoryService;

public class CreateCategoryOption extends Option {

    private final CategoryService categoryService;

    public CreateCategoryOption(CategoryService categoryService){
        super("create-category");

        this.categoryService = categoryService;
    }

    @Override
    public void execute() {
        output.napisz("Tworzenie kategorii" + "\n");

        int id = Integer.parseInt(input.zapytanie("Podaj id"));
        String name = input.zapytanie("Podaj nazwę");

        categoryService.createCategory(id, name);

    }
}
