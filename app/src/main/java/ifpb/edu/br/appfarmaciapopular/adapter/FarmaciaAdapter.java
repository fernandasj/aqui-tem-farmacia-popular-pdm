package ifpb.edu.br.appfarmaciapopular.adapter;

import android.content.Context;

import java.util.List;

import ifpb.edu.br.appfarmaciapopular.helper.FarmaciaHelper;
import ifpb.edu.br.appfarmaciapopular.model.Farmacia;

public class FarmaciaAdapter {
    private Context context;

    public FarmaciaAdapter(Context context) {
        this.context = context;
    }

    public void save(List<Farmacia> farmacias) {
        final FarmaciaHelper helper = new FarmaciaHelper(context);

        for (Farmacia farmacia : farmacias) {
            helper.insertFarmacia(farmacia);
        }
    }

    public Integer count() {
        final FarmaciaHelper helper = new FarmaciaHelper(context);
        return helper.countFarmacias();
    }

    public void clear() {
        final FarmaciaHelper helper = new FarmaciaHelper(context);
        helper.clearFarmacias();
    }
}
