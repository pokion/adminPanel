package pl.czarek.adminpanel.service;

import pl.czarek.adminpanel.obj.Option;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OptionService {
    private final List<Option> options;

    public OptionService() {
        this.options = new ArrayList<>();
    }

    public void registerOption(Option option) {
        this.options.add(option);
    }

    public Optional<Option> findOption(String name) {
        return this.options
                .stream()
                .filter( option -> option.getName().equalsIgnoreCase(name))
                .findFirst();
    }
}
