package dev.yolanda.views;

import java.util.Collections;
import java.util.List;

import dev.yolanda.controllers.MomentController;
import dev.yolanda.models.Emotion;
import dev.yolanda.models.Moment;
import dev.yolanda.singletons.MomentControllerSingleton;

public class FilterMoodView extends View{
    private static final MomentController CONTROLLER = MomentControllerSingleton.getInstance();

    public static List<Moment> filterByMood() {
        System.out.print("Seleccione una emoción: ");
        //¿Imprimir las emociones?
        
        for (Emotion e : Emotion.values()) {
            System.out.println(e.getNumberEmotion() + ". " + e.name());
        }

        int option = SCANNER.nextInt();
        SCANNER.nextLine();

        Emotion selectedEmotion = null;
        for (Emotion e : Emotion.values()) {
            if (e.getNumberEmotion() == option) {
                selectedEmotion = e;
                break;
            }
        }

        if (selectedEmotion == null) {
            System.out.println("Opción inválida");
            return Collections.emptyList();
        }

        List<Moment> filteredMoments = CONTROLLER.getMomentsByEmotion(selectedEmotion);
        
        
        if (filteredMoments.isEmpty()) {
            System.out.println("No hay momentos con esa emoción.");
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
