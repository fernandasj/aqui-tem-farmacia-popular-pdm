package ifpb.edu.br.appfarmaciapopular;


import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.List;

import ifpb.edu.br.appfarmaciapopular.adapter.FarmaciaAdapter;
import ifpb.edu.br.appfarmaciapopular.model.FarmaciaMarker;


/**
 * A simple {@link Fragment} subclass.
 */
public class FarmaciasFragment extends Fragment implements OnMapReadyCallback {

    private MapView mMapView;
    private GoogleMap mMap;

    public FarmaciasFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_farmacias, container, false);
        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this::onMapReady);
        return view;
    }

    @SuppressLint("MissingPermission")
    @Override
    public void onMapReady(GoogleMap gMap) {
        this.mMap = gMap;
        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(googleMap -> {
            mMap.setMyLocationEnabled(true);
            LocationManager locationManager = (LocationManager) getActivity().getSystemService(Context.LOCATION_SERVICE);
            Location getLastLocation = locationManager.getLastKnownLocation(LocationManager.PASSIVE_PROVIDER);
            Double currentLongitude = getLastLocation.getLongitude();
            Double currentLatitude = getLastLocation.getLatitude();
            LatLng myLocation = new LatLng(currentLatitude, currentLongitude);
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(myLocation, 12));

            List<FarmaciaMarker> markers = nearbyFarmaciaMarkers(myLocation);

            for (FarmaciaMarker marker : markers) {
                LatLng latLng = new LatLng(marker.getLat(), marker.getLng());
                mMap.addMarker(new MarkerOptions().position(latLng).title(marker.getNome()));
            }

        });
    }

    public List<FarmaciaMarker> nearbyFarmaciaMarkers(LatLng myLocation) {
        FarmaciaAdapter adapter = new FarmaciaAdapter(this.getContext());
        return adapter.nearby(myLocation);
    }

}
