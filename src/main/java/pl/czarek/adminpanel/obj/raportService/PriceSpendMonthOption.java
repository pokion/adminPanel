package pl.czarek.adminpanel.obj.raportService;

import pl.czarek.adminpanel.io.output;
import pl.czarek.adminpanel.obj.Option;
import pl.czarek.adminpanel.service.RaportService;

import java.util.ArrayList;

public class PriceSpendMonthOption extends Option {

    private final RaportService raportService;

    public PriceSpendMonthOption(RaportService raportService){
        super("priceSpendMonth-raport");

        this.raportService = raportService;
    }

    @Override
    public void execute() {
        output.write("PriceSpendMonth");

        ArrayList<PriceSpendMonth> raport = this.raportService.PriceSpendMonth();
        output.write("NAME | MONTH |  PRICE");
        for (PriceSpendMonth user:
                raport) {
            output.write(user.getName()+" | "+user.getMonth()+" | "+ user.getSumPrice());
        }
    }
}
