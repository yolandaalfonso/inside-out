package dev.yolanda.views;

import java.nio.file.Path;

import dev.yolanda.controllers.MomentController;
import dev.yolanda.singletons.MomentControllerSingleton;

public class MomentExportCsvView extends View{
    
    private static final MomentController CONTROLLER = MomentControllerSingleton.getInstance();

    public static void printExportMenu() {
        System.out.println("Ruta del CSV (ej: data/moments.csv):");
        String p = SCANNER.nextLine();

        try {
            CONTROLLER.exportMomentsCsv(Path.of(p));
            System.out.println("CSV exportado en: " + p);
        } catch (Exception e) {
            System.out.println("No se pudo exportar el CSV: " + e.getMessage());
        }
        HomeView.printMenu();
    }
}
