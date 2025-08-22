package dev.yolanda.views;

import dev.yolanda.controllers.MomentController;
import dev.yolanda.singletons.MomentControllerSingleton;

public class MomentExportCsvView extends View{

    private static final MomentController CONTROLLER = MomentControllerSingleton.getInstance();

    public static void printExportMenu() {
        System.out.println("Nombre del CSV:");
        String fileName = SCANNER.nextLine();

        if(fileName.isEmpty()) {
            fileName = "diario.csv";
        }
        
        CONTROLLER.exportAllMoments(fileName);
        System.out.println("Exportación completada!");

        HomeView.printMenu();
    }
}
