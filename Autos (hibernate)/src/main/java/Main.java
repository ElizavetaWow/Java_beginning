import models.Auto;
import models.User;
import services.AutoService;
import services.UserService;

import java.util.List;

public class Main {
    public static void main(String[] args){
        UserService userService = new UserService();
        User user = new User("Liza", 26);
        User user2 = new User("Ann", 27);
        userService.saveUser(user);
        userService.saveUser(user2);
        List<User> userList = userService.findAllUsers();
        for (User userFor:userList) {
            System.out.println(userFor);
        }
        Auto car1 = new Auto("Ford", "red");
        user.addAuto(car1);
        Auto car2 = new Auto("BMW", "black");
        car2.setUser(user);
        user.addAuto(car2);
        user2.addAuto(new Auto("lada", "blue"));
        userService.updateUser(user);
        userService.updateUser(user2);
        AutoService autoService = new AutoService();
        List<Auto> autoList = autoService.findAllAutos();
        for (Auto autoFor:autoList) {
            System.out.println(autoFor);
        }
        System.out.println(userService.findUser(2));
        System.out.println(userService.findAuto(2));
        System.out.println(autoService.findUser(3));
    }
}
