package dev.yolanda.views;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import dev.yolanda.controllers.MomentController;

public class MomentPostView extends View{

    private static MomentController CONTROLLER = ModelControllerSingleton.getInstance();

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

        String text = """
                Selecciona una emoción:
                1. Alegría
                2. Tristeza
                3. Ira
                4. Asco
                5. Miedo
                6. Ansiedad
                7. Envidia
                8. Vergüenza
                9. Aburrimiento
                10. Nostalgia
                """;

        System.out.print(text);
        int numberEmotion = SCANNER.nextInt();

        //MomentDTO moment = new MomentDTO(momentTitle, date, description);
        //CONTROLLER.StoreMoment(moment);
    }

}