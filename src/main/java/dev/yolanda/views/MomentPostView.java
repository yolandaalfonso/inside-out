package dev.yolanda.views;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import dev.yolanda.controllers.ModelController;
import dev.yolanda.dtos.MomentDTO;

public class MomentPostView extends View{

    private static ModelControllerController CONTROLLER = ModelControllerSingleton.getInstance();

    public static void printStoreMenu() {
        System.out.println("Ingrese el título:");
        String momentTitle = SCANNER.next();

        System.out.println("Ingresa la fecha(dd/mm/year):");
        String date = SCANNER.next();
        SimpleDateFormat inputFormat = new SimpleDateFormat("dd-MM-yyyy");
        try {
            Date inputDate = inputFormat.parse(date);
            System.out.println("String to Date: " + inputDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        

        System.out.println("Ingrese la descripción:");
        String description = SCANNER.next();

        MomentDTO moment = new MomentDTO(momentTitle, date, description);
        CONTROLLER.StoreMoment(moment);
    }

}