import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.errors.ApiException;
import com.google.maps.model.GeocodingResult;
import com.google.maps.model.LatLng;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.net.URL;

public class Main {
    public static void main(String[] args) throws InterruptedException, ApiException, IOException {

        String plz = "10969";

        String country = "Germany";

        String api = "in Slack api to take";

        String mapsApi = "https://maps.googleapis.com/maps/api/geocode/json?address=";

        //   https://maps.googleapis.com/maps/api/geocode/json?address=Lindenstraße+77+10969+Berlin&key=AIzaSyBttiDLyRGz9gQ-FB3-DGBBhhNHaW_E8KU

        String plzCountry = plz + " " + country;

        String mapsJson = mapsApi + plz.concat("+") + country.concat("&key=") + api;
        System.out.println( " String mapsJson = " + mapsJson);

        URL url = new URL("https://maps.googleapis.com/maps/api/geocode/json?address=Lindenstraße+77+10969+Berlin&key=AIzaSyBttiDLyRGz9gQ-FB3-DGBBhhNHaW_E8KU");
        System.out.println( " URL url = " + url);


        GeoApiContext context = new GeoApiContext.Builder()
                .apiKey(api)
                .build();
        GeocodingResult[] results = GeocodingApi.geocode(context,
                plz).await();
        System.out.println("***************************");

        LatLng coords = (results[0].geometry.location);
        System.out.println(results[0].geometry.location);
        System.out.println("***************************");


        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        System.out.println(gson.toJson(results[0].addressComponents));
        System.out.println("***************************");
        System.out.println(gson.toJson(results[0]));
        System.out.println("***************************");
        System.out.println(gson.toJson(results[0].formattedAddress));
        System.out.println(gson.toJson(results[0]));
        System.out.println("***************************");
        System.out.println(gson.toJson(results[0].geometry));
        System.out.println(gson.toJson(results[0]));
        System.out.println("***************************");


    }

}
