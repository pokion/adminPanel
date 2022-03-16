package pl.czarek.adminpanel.obj;

public abstract class Option {

    private final String name;

    public Option(String name) {
        this.name = name;
    }

    public abstract void execute();

    public String getName() {
        return name;
    }
}
