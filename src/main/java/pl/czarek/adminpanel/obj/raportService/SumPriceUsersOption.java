package pl.czarek.adminpanel.obj.raportService;

import pl.czarek.adminpanel.io.output;
import pl.czarek.adminpanel.obj.Option;
import pl.czarek.adminpanel.service.DatabaseService;
import pl.czarek.adminpanel.service.RaportService;

import java.util.ArrayList;

public class SumPriceUsersOption extends Option {

    private final RaportService raportService;

    public SumPriceUsersOption(RaportService raportService){
        super("sumPriceUsers-raport");

        this.raportService = raportService;
    }

    @Override
    public void execute() {
        output.write("SumPriceUsers");

        ArrayList<SumPriceUsers> raport = this.raportService.SumPriceUsers();
        output.write("NAME  |  PRICE");
        for (SumPriceUsers user:
             raport) {
            output.write(user.getName()+" | "+user.getPrice());
        }
    }
}
