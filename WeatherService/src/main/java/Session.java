import Models.MailModel;
import Models.SourceModel;
import Models.WorldWeatherModel;
import Models.YandexModel;

import java.io.IOException;
import java.util.*;

public class Session {
    private Scanner scan = new Scanner(System.in);
    private int sourceNum = 1;
    private String inputLine;
    private ArrayList<String> commandList = new ArrayList<>
            (Arrays.asList(new String[] {"help", "quit", "source"}));
    private ArrayList<String> sources = new ArrayList<>
            (Arrays.asList(new String[] {"Погода Mail.ru", "Яндекс.Погода", "World Weather"}));
    private SourceModel source;


    public Session(){
        System.out.println("Добро пожаловать в консольный сервис погоды!");
        getInstructions(false);
        chooseSource();
    }

    public void chooseSource(){
        System.out.println("Выберите источник из списка:");
        for (int i = 0; i < sources.size(); i++){
            System.out.println((i + 1) + ". " + sources.get(i));
        }
        System.out.println("Введите номер источника");
        //добавить сохранение в настройки
        check(true);
        switch (sourceNum) {
            case 1:
                source = new MailModel();
                break;
            case 2:
                source = new YandexModel();
                break;
            case 3:
                source = new WorldWeatherModel();
                break;
        }
        System.out.println(source.toString());
        check(false);
    }

    public void getInstructions(Boolean type){
        //добавить инструкции про выход, помощь и меню сервисов
        System.out.println(" inst");
        if (type){
            check(false);
        }
    }

    public void check(Boolean type){
        if (scan.hasNext()) {
            inputLine = scan.next();
            if (!type) {
                if (commandList.contains(inputLine)) {
                    switch (inputLine) {
                        case "help":
                            getInstructions(true);
                            break;
                        case "source":
                            chooseSource();
                            break;
                        case "quit":
                            finish();
                    }
                } else {
                    System.out.println("Введена некорректная команда. Попробуйте ещё раз");
                    check(false);
                }
            }
            else{
                try{
                    if (Integer.parseInt(inputLine) <= sources.size() && 0 < Integer.parseInt(inputLine)){
                        sourceNum = Integer.parseInt(inputLine);
                    }
                    else{
                        throw new Exception();
                    }
                }
                catch (Exception e){
                    System.out.println("Введен некорректный номер. Попробуйте ещё раз");
                    check(true);
                }
            }
        }
    }

    public void finish(){
        scan.close();
    }
}

