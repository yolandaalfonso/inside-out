package dev.yolanda.views;

import java.util.Collections;
import java.util.List;

import dev.yolanda.controllers.MomentController;
import dev.yolanda.models.Moment;
import dev.yolanda.models.Mood;
import dev.yolanda.singletons.MomentControllerSingleton;

public class FilterMoodView extends View{
    private static final MomentController CONTROLLER = MomentControllerSingleton.getInstance();

    public static List<Moment> filterByMood() {
        System.out.print("Seleccione si quiere momentos bueno o malos: ");
        //¿Imprimir las emociones?
        
        for (Mood m : Mood.values()) {
            System.out.println(m.getNumberMood() + ". " + m.name());
        }

        int option = SCANNER.nextInt();
        SCANNER.nextLine();

        Mood selectedMood = null;
        for (Mood m : Mood.values()) {
            if (m.getNumberMood() == option) {
                selectedMood = m;
                break;
            }
        }

        if (selectedMood == null) {
            System.out.println("Opción inválida");
            return Collections.emptyList();
        }

        List<Moment> filteredMoments = CONTROLLER.getMomentsByMood(selectedMood);
        
        
        if (filteredMoments.isEmpty()) {
            System.out.println("No hay momentos con ese mood.");
        } else {
            System.out.println("Lista de momentos vividos:");
            for (Moment m : filteredMoments) {
                System.out.println(m.getId() + ". Ocurrió el: " + m.getDate() + ". Título:" + m.getMomentTitle() + ". Descripción: " + m.getDescription() + ". Emocion:" + m.getEmotion()+ ". Mood:" + m.getMood());
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
