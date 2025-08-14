package dev.yolanda.views;

import dev.yolanda.controllers.MomentController;
import dev.yolanda.singletons.MomentControllerSingleton;

public class MomentFilterView extends View{
    private static MomentController CONTROLLER = MomentControllerSingleton.getInstance();

    public static void printFilterMenu() {

        String text = """
                Filtrar por...
                1.Emoción
                2.Fecha
                "Ingresa una opcion: ")
                """;
        
        System.out.print(text);
        int option = SCANNER.nextInt();

        //if (option == 1) CONTROLLER.printStoreMenu();
        //if (option == 2) CONTROLLER.GetAllMoments();

        //CONTROLLER.deleteMoment(id);

        HomeView.printMenu();
    }

}
