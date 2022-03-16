package pl.czarek.adminpanel.obj.categoryOptions;

import pl.czarek.adminpanel.io.input;
import pl.czarek.adminpanel.io.output;
import pl.czarek.adminpanel.obj.Option;
import pl.czarek.adminpanel.service.CategoryService;

public class RemoveCategoryOption extends Option {

    private final CategoryService categoryService;

    public RemoveCategoryOption(CategoryService categoryService){
        super("remove-category");

        this.categoryService = categoryService;
    }

    @Override
    public void execute() {
        output.napisz("Usuwanie kategori");

        int id = Integer.parseInt(input.zapytanie("Podaj id"));

        categoryService.removeCategory(id);
    }
}
