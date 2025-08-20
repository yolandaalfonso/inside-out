package dev.yolanda.views;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import dev.yolanda.controllers.MomentController;
import dev.yolanda.dtos.MomentDTO;
import dev.yolanda.models.Emotion;
import dev.yolanda.models.Mood;
import dev.yolanda.singletons.MomentControllerSingleton;

public class MomentPostView extends View{

    private static MomentController CONTROLLER = MomentControllerSingleton.getInstance();

    public static void printStoreMenu() {
        System.out.println("Ingrese el título:");
        String momentTitle = SCANNER.next();

        //System.out.println("Ingresa la fecha(dd/mm/year):");
        //String date = SCANNER.next();
        //SimpleDateFormat inputFormat = new SimpleDateFormat("dd-MM-yyyy");
        //try {
            //Date inputDate = inputFormat.parse(date);
            //System.out.println("String to Date: " + inputDate);
        //} catch (ParseException e) {
            //e.printStackTrace();
        //}

        //System.out.println("Ingresa la fecha(dd/mm/year):");
       // Date date = null;
            //SimpleDateFormat inputFormat = new SimpleDateFormat("dd/MM/yyyy");
            //inputFormat.setLenient(false); // para evitar que acepte fechas inválidas
            //while (date == null) {
                //System.out.println("Ingresa la fecha (dd/MM/yyyy):");
                //String dateStr = SCANNER.nextLine();
            //try {
                //date = inputFormat.parse(dateStr);
            //} catch (ParseException e) {
                //System.out.println("Fecha inválida. Intente de nuevo.");
            //}
            //};

        LocalDate date = null;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        do { 
            System.out.println("Ingresa la fecha (dd/mm/year):");
            String dateStr = SCANNER.next();       
            
            try {
                date = LocalDate.parse(dateStr, formatter);
            } catch (DateTimeParseException e) {
                System.out.println("⚠️ Formato de fecha inválido. Por favor, use el formato dd/MM/yyyy.");            
            }
        
        } while (date == null);



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
        SCANNER.nextLine();

        Emotion emotion = Emotion.values()[numberEmotion - 1];

        String textMood = """
                Seleccione si el momento ha sido bueno o malo:
                1. Bueno
                2. Malo
                """;

        System.out.print(textMood);
        int numberMood = SCANNER.nextInt();
        SCANNER.nextLine();

        Mood mood = Mood.values()[numberMood - 1];

        MomentDTO moment = new MomentDTO(1, momentTitle, description, emotion, date, mood);
        CONTROLLER.StoreMoment(moment);

        System.out.println("Momento añadido con éxito.");
        HomeView.printMenu();
        
        //System.out.println("--- Lista de momentos vividos ---");
        //System.out.printf("%d. Ocurrió el: %s. Título: %s. Descripción: %s. Emoción: %s%n",
                          //newMoment.getId(),
                          //newMoment.getMomentDate().format(formatter),
                          //newMoment.getMomentTitle(),
                          //newMoment.getMomentDescription(),
                          //newMoment.getEmotion().name());

        //MomentDTO moment = new MomentDTO(int id, String momentTitle, String description, Emotion emotion, Date date);
        //CONTROLLER.StoreMoment(moment);
    }

}