package ifpb.edu.br.appfarmaciapopular.helper;

import java.io.BufferedReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import ifpb.edu.br.appfarmaciapopular.model.Farmacia;

public class FarmaciaCsvParser {
    private Reader reader;

    public FarmaciaCsvParser(Reader reader) {
        this.reader = reader;
    }

    public List<Farmacia> parse() {
        List<Farmacia> farmacias = new ArrayList<>();

        final BufferedReader bufferedReader = new BufferedReader(reader);

        try {
            final String[] header = bufferedReader.readLine().split(",");
            String line = bufferedReader.readLine();

            while (line != null) {
                final Farmacia farmacia = new Farmacia(line.split(","));
                farmacias.add(farmacia);

                line = bufferedReader.readLine();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return farmacias;
    }
}
