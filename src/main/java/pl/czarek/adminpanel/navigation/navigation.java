package pl.czarek.adminpanel.navigation;

import pl.czarek.adminpanel.io.output;
import pl.czarek.adminpanel.service.OptionService;

import java.util.*;

public class navigation {

    private List<Stage> stages;
    public static ArrayList<Options> options;
    public static String prevOpt;
    public int currentStage = 0;

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
        output.write("Wybierz opcję");

        Optional<Stage> stageStream = stages.stream().filter(stage -> stage.getIdx() == currentStage).findFirst();

        String show = stageStream.get().getOptions();

        output.write(show);
        output.write("exit");
    }

    public void goTo(String name){
        Optional<Options> opts = options.stream().filter(options1 -> options1.option.equals(name)).findFirst();

        ArrayList<String> optsArray = opts.get().nestOptions;

        Set<String> set = new HashSet<>(optsArray);
        optsArray.clear();
        optsArray.addAll(set);

        prevOpt = opts.get().option;
        this.createStage(optsArray);
        currentStage++;
        this.showStage();

    }

    public void removeStage(int idx){
        stages.remove(idx);
        currentStage = 0;

    }

    public String prevStage(){
        return stages.get(currentStage - 1).getOptions();
    }

    public void exit(){
        System.exit(1);
    }
}
