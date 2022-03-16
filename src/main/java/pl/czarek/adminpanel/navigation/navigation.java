package pl.czarek.adminpanel.navigation;

import pl.czarek.adminpanel.io.output;
import pl.czarek.adminpanel.service.OptionService;

import java.util.*;

public class navigation {

    private List<Stage> stages;
    public static ArrayList<Options> options;
    private int currentStage = 0;

    public navigation() {
        this.stages = new ArrayList<>();
        this.options = new ArrayList<>();
    }


    public void start(OptionService optionService){
        ArrayList<String> opts = new ArrayList<>();
        ArrayList<String> allOpts = new ArrayList<>();

        for(int i=0; i<optionService.options.size(); i++){
            opts.add( optionService.options.get(i).getName().split("-")[1] );
            allOpts.add(optionService.options.get(i).getName());
        }

        Set<String> set = new HashSet<>(opts);
        opts.clear();
        opts.addAll(set);

        for(int i=0; i<opts.size(); i++){
            Options option = new Options();

            for(String s: allOpts){
                option.nestOptions.add(s.split("-")[0]);
            }
            option.option = opts.get(i);

            options.add(option);
        }

        this.createStage(opts);

    }

    public void createStage(ArrayList<String> options){
        stages.add(new Stage(stages.size(), options));
    }

    public void showStage(){
        output.napisz("Wybierz opcję");

        Optional<Stage> stageStream = stages.stream().filter(stage -> stage.getIdx() == currentStage).findFirst();

        String show = stageStream.get().getOptions();

        output.napisz(show);
    }

    public void goTo(String name){
        Optional<Options> opts = options.stream().filter(options1 -> options1.option.equals(name)).findFirst();

        this.createStage(opts.get().nestOptions);
        currentStage++;
        this.showStage();

    }

    public void removeStage(int idx){
        stages.remove(idx);
    }

    public String prevStage(){
        return stages.get(currentStage - 1).getOptions();
    }

    public void exit(){
        System.exit(1);
    }
}
