import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Session {
    private Scanner scan = new Scanner(System.in);
    private int sourcesNum = 0;

    public Session(){
        HashMap<String, String> sources = new HashMap<>();
        sources.put("Погода Mail.ru", "https://pogoda.mail.ru/prognoz/");
        sources.put("Яндекс.Погода", "https://yandex.ru/pogoda/");
        sources.put("World Weather", "https://world-weather.ru/pogoda/");
        System.out.println("Добро пожаловать в консольный сервис погоды!");
        System.out.println("Выберите источник из списка:");

        for (String key: sources.keySet()){
            sourcesNum++;
            System.out.println(sourcesNum + ". " + key);
        }
        System.out.println("Введите номер источника");
        try {
            int a = scan.nextInt();
        }
        catch (
                InputMismatchException e) {
            System.out.println("Введен некорректный номер. Попробуйте ещё раз");

        }
    }

}

