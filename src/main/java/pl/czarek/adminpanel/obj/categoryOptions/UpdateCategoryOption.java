package pl.czarek.adminpanel.obj.categoryOptions;

import pl.czarek.adminpanel.io.input;
import pl.czarek.adminpanel.io.output;
import pl.czarek.adminpanel.obj.Option;
import pl.czarek.adminpanel.service.CategoryService;

public class UpdateCategoryOption extends Option {

    private final CategoryService categoryService;

    public UpdateCategoryOption(CategoryService categoryService){
        super("update-category");

        this.categoryService = categoryService;
    }

    @Override
    public void execute() {
        output.write("Aktualizacja produktu");

        int id = Integer.parseInt(input.question("Podaj id"));
        String name = input.question("Podaj nazwę");

        categoryService.updateCategory(new Category(id, name));
    }
}
