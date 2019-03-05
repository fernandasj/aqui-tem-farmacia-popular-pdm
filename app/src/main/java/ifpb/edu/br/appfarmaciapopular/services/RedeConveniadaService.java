package ifpb.edu.br.appfarmaciapopular.services;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import ifpb.edu.br.appfarmaciapopular.helper.FarmaciaCsvParser;
import ifpb.edu.br.appfarmaciapopular.model.Farmacia;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class RedeConveniadaService {
    private static final String url = "http://i3geo.saude.gov.br/i3geo/ogc.php?service=WFS&version=1.0.0&request=GetFeature&typeName=farmacia_popular_estabelecimento&outputFormat=CSV";

    private OkHttpClient httpClient = new OkHttpClient();

    public List<Farmacia> getFarmacias() {
        List<Farmacia> farmacias = new ArrayList<>();
        Request request = new Request.Builder()
                .url(url)
                .build();

        try (Response response = httpClient.newCall(request).execute()) {
            Reader reader = response.body().charStream();
            farmacias = new FarmaciaCsvParser(reader).parse();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return farmacias;
    }
}
