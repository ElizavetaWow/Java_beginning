import Exceptions.WrongInputException;
import Models.MailModel;
import Models.WorldWeatherModel;
import Models.YandexModel;
import org.jsoup.Jsoup;
import org.jsoup.nodes.*;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args){


        YandexModel ym = new YandexModel();
        System.out.println(ym.toString());

        WorldWeatherModel wwm = new WorldWeatherModel();
        System.out.println(wwm.toString());

        MailModel mm = new MailModel();
        System.out.println(mm.toString());

    }

}
