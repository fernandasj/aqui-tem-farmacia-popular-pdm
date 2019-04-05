package ifpb.edu.br.appfarmaciapopular.helper;


public class DistanceHelper {
    public static final Double EARTH_RADIUS = 6371.0;

    public Double distance(double startLat, double startLong, double endLat, double endLong) {

        Double dLat = Math.toRadians((endLat - startLat));
        Double dLong = Math.toRadians((endLong - startLong));

        startLat = Math.toRadians(startLat);
        endLat = Math.toRadians(endLat);

        Double a = haversin(dLat) + Math.cos(startLat) * Math.cos(endLat) * haversin(dLong);
        return EARTH_RADIUS * (2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a)));
    }

    private Double haversin(Double value) {
        return Math.pow(Math.sin(value / 2), 2);
    }
}
