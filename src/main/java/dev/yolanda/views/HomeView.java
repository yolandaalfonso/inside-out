package dev.yolanda.views;

import dev.yolanda.controllers.MomentController;
import dev.yolanda.singletons.MomentControllerSingleton;

public class HomeView extends View{

    private static MomentController CONTROLLER = MomentControllerSingleton.getInstance();

    public static void printMenu() {

        String text = """
                My diario:
                1. Añadir momento
                2. Ver todos los momentos disponibles
                3. Eliminar un momento
                4. Filtrar los momentos
                5. Salir
                ----------------------
                Seleccione una opción:
                """;

        System.out.print(text);

        int option = SCANNER.nextInt();

        if (option == 1) MomentPostView.printStoreMenu();
        if (option == 2) CONTROLLER.GetAllMoments();
        if (option == 3) MomentDeleteView.printDeleteMenu();
        if (option == 4) MomentFilterView.printFilterMenu();
        if (option == 5) System.out.println("¡Hasta la próxima!!! 👋");



    }
    
}
