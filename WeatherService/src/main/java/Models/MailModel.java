package Models;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.List;

public class MailModel implements SourceModel {
    private Document html;
    private String temperature;
    private String wind;
    private String humidity;
    private String pressure;
    private final String URL = "https://pogoda.mail.ru/prognoz/moskva/";

    public MailModel(){
        parseData();
    }

    @Override
    public void parseData() {
        try {
            html = Jsoup.connect(URL).get();
            List<String> argslist = html.body().getElementsByClass("information__content__additional_second").
                    first().getElementsByTag("span").eachText();
            temperature = html.body().getElementsByClass("information__content__temperature").text();
            wind = argslist.get(5).split(" ")[0] + " м/с";
            humidity = argslist.get(3).split(" ")[0];
            pressure = argslist.get(0).split(" ")[0] + " мм рт. ст.";
        } catch (IOException e) {
            System.out.println("Сервис "+URL+" не доступен");
        }
    }

    @Override
    public String toString() {
        return "Погода Mail.ru сообщает"+'\n'+
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
