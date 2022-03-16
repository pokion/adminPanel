package pl.czarek.adminpanel.navigation;

import java.util.ArrayList;
import java.util.Arrays;

public class Stage {
    private int idx;
    private ArrayList<String> options;

    public Stage(int idx, ArrayList<String> options){
        this.idx = idx;
        this.options = options;
    }

    public int getIdx(){
        return idx;
    }

    public String getOptions(){
        String result = options.stream()
                        .reduce("", (partialStr, el) -> partialStr + el + "\n");

        return result;
    }
}
