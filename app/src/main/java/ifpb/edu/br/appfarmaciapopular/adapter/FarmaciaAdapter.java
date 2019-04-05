package ifpb.edu.br.appfarmaciapopular.adapter;

import android.content.Context;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;
import java.util.List;

import ifpb.edu.br.appfarmaciapopular.helper.DistanceHelper;
import ifpb.edu.br.appfarmaciapopular.helper.FarmaciaHelper;
import ifpb.edu.br.appfarmaciapopular.model.Farmacia;
import ifpb.edu.br.appfarmaciapopular.model.FarmaciaMarker;

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

    public List<FarmaciaMarker> nearby(LatLng coords) {
        final FarmaciaHelper farmaciaHelper = new FarmaciaHelper(context);
        List<FarmaciaMarker> farmaciaMarkers = farmaciaHelper.findAllFarmaciaMarkers();
        List<FarmaciaMarker> nearbyMarkers = new ArrayList<>();
        DistanceHelper distanceHelper = new DistanceHelper();

        for (FarmaciaMarker marker : farmaciaMarkers) {
            Double distance = distanceHelper.distance(coords.latitude, coords.longitude, marker.getLat(), marker.getLng());
            if (distance < 10.0) {
                System.out.println(" >>> MARKER " + marker.getNome() + " " + marker.getLat() + " " + marker.getLng() + " " + marker.getEndereco());
                nearbyMarkers.add(marker);
            }
        }
        System.out.println(" >>> NEARBY: " + nearbyMarkers.size());
        return nearbyMarkers;
    }
}

