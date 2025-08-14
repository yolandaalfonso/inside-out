package dev.yolanda.views;

import dev.yolanda.controllers.MomentController;
import dev.yolanda.singletons.MomentControllerSingleton;

public class MomentDeleteView extends View{

    private static MomentController CONTROLLER = MomentControllerSingleton.getInstance();

    public static void printDeleteMenu() {
        System.out.println("Ingresa el identificador del momento:");
        int id = SCANNER.nextInt();
        SCANNER.nextLine();

        CONTROLLER.deleteMoment(id);
        System.out.println("Momento vivido eliminado correctamente");

        HomeView.printMenu();
    }
}
