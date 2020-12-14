package Models;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.List;

public class WorldWeatherModel implements SourceModel {
    private Document html;
    private String temperature;
    private String wind;
    private String humidity;
    private String pressure;
    private final String URL = "https://world-weather.ru/pogoda/russia/moscow/";

    public WorldWeatherModel(){
        parseData();
    }

    @Override
    public void parseData() {
        try {
            html = Jsoup.connect(URL).get();

            temperature = html.body().getElementById("weather-now-number").text();
            List<String> argslist = html.body().getElementById("weather-now-description").getElementsByTag("dd").eachText();
            wind = argslist.get(2);
            humidity = argslist.get(3);
            pressure = argslist.get(1);
        } catch (IOException e) {
            System.out.println("Сервис "+URL+" не доступен");
        }
    }

    @Override
    public String toString() {
        return "World Weather сообщает"+'\n'+
                "Температура: " + temperature + '\n' +
                "Ветер: " + wind + '\n' +
                "Влажность: " + humidity + '\n' +
                "Давление: " + pressure + '\n';
    }

    public String getHumidity() {
        return humidity;
    }

    public String getPressure() {
        return pressure;
    }

    public String getWind() {
        return wind;
    }

    public String getTemperature() {
        return temperature;
    }
}
