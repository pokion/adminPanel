package pl.czarek.adminpanel.obj.categoryOptions;

import pl.czarek.adminpanel.builder.CategoryBuilder;
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

        String name = input.zapytanie("Podaj nazwę");

        categoryService.createCategory(new CategoryBuilder()
                .setName(name)
                .getCategory());

    }
}
