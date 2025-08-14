package dev.yolanda.views;

import java.util.Collections;
import java.util.List;

import dev.yolanda.controllers.MomentController;
import dev.yolanda.models.Emotion;
import dev.yolanda.models.Moment;
import dev.yolanda.singletons.MomentControllerSingleton;

public class FilterDateView extends View{
    private static final MomentController CONTROLLER = MomentControllerSingleton.getInstance();

    public static List<Moment> filterByDate() {
        System.out.print("Ingresa el mes: ");
        int month = SCANNER.nextInt();
        

        System.out.print("Ingrese el año: ");
        int year = SCANNER.nextInt();
        //SCANNER.nextLine();

        List<Moment> filteredMoments = CONTROLLER.getMomentsByDate(month, year);
        
        
        if (filteredMoments.isEmpty()) {
            System.out.println("No hay momentos con esa fecha.");
        } else {
            System.out.println("Lista de momentos vividos:");
            for (Moment m : filteredMoments) {
                System.out.println(m.getId() + ". Ocurrió el: " + m.getDate() + ". Título:" + m.getMomentTitle() + ". Descripción: " + m.getDescription() + ". Emocion:" + m.getEmotion());
                //System.out.println("- " + m.getMomentTitle() + ": " + m.getDescription());
            }
        }

        /*if (filteredMoments.isEmpty()) {
            System.out.println("No hay momentos con esa emoción.");
        } else {
            filteredMoments = CONTROLLER.GetAllMoments();
        } */
        
        return filteredMoments;
        

    }
}
