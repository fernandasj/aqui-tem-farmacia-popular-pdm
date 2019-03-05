package ifpb.edu.br.appfarmaciapopular.services;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import java.util.List;

import ifpb.edu.br.appfarmaciapopular.adapter.FarmaciaAdapter;
import ifpb.edu.br.appfarmaciapopular.model.Farmacia;

public class DatabaseTask extends AsyncTask<String, String, Boolean> {

    private RedeConveniadaService service = new RedeConveniadaService();
    private Context context;

    public DatabaseTask(Context context) {
        this.context = context;
    }

    @Override
    protected void onPreExecute() {
        Toast.makeText(context, "Atualizando base de dados...", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onPostExecute(Boolean result) {
        if (result) {
            Toast.makeText(context, "Base de dados atualizada!", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected Boolean doInBackground(String... strings) {
        List<Farmacia> farmacias = service.getFarmacias();
        FarmaciaAdapter adapter = new FarmaciaAdapter(context);

        Boolean shouldInsert = (adapter.count() != farmacias.size());

        if (shouldInsert) {
            adapter.clear();
            adapter.save(farmacias);
        }

        return true;
    }
}
