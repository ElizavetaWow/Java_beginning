package Models;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class YandexModel implements SourceModel {
    private Document html;
    private String temperature;
    private String wind;
    private String humidity;
    private String pressure;
    private final String URL = "https://yandex.ru/pogoda/moscow";

    public YandexModel(){
        parseData();
    }

    @Override
    public void parseData() {
        try {
            html = Jsoup.connect(URL).get();
            temperature = html.body().getElementsByClass("fact__temp").first()
                    .getElementsByClass("temp__value").text() + "°";
            wind = html.body().getElementsByClass("fact__wind-speed").first()
                    .getElementsByClass("term__value").text();
            wind = wind.replaceFirst(",", ".");
            humidity = html.body().getElementsByClass("fact__humidity").first()
                    .getElementsByClass("term__value").text();
            pressure = html.body().getElementsByClass("fact__pressure").first()
                    .getElementsByClass("term__value").text();
        } catch (IOException e) {
            System.out.println("Сервис "+URL+" не доступен");
        }
    }

    @Override
    public String toString() {
        return "Температура: " + temperature + '\n' +
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
