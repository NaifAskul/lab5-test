package sa.edu.kau.fcit.cpit252.weather;

import sa.edu.kau.fcit.cpit252.geoLocation.GeoLocationService;
import sa.edu.kau.fcit.cpit252.geoLocation.Location;


/* This is the adapter class, WeatherAdapter, which takes a geographic coordinates of a city and returns the daily weather forecasts.
 * The adapter is a class used as an intermediary between the client and the adaptee.
 *
 */
public class WeatherAdapter implements WeatherCity{

    private WeatherGeo weatherGeo;
    private GeoLocationService geoLocation;

    public WeatherAdapter(WeatherGeo weatherGeo) {
        this.weatherGeo = weatherGeo;
        this.geoLocation = new GeoLocationService();
    }


    @Override
    public WeatherInfo getWeatherInfo(String cityName) {

        Location location = this.geoLocation.search(cityName);
        WeatherInfo weatherInfo = this.weatherGeo.getWeatherInfo(location.getLatitude(), location.getLongitude());
        weatherInfo.setCity(cityName);
        return weatherInfo;

    }
}
