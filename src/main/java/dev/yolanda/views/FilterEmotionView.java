package dev.yolanda.views;

import java.util.Collections;
import java.util.List;

import dev.yolanda.controllers.MomentController;
import dev.yolanda.models.Emotion;
import dev.yolanda.models.Moment;
import dev.yolanda.singletons.MomentControllerSingleton;

public class FilterEmotionView extends View{

    private static final MomentController CONTROLLER = MomentControllerSingleton.getInstance();

    public List<Moment> filterByEmotion() {
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
            System.out.println("Momentos encontrados:");
            for (Moment m : filteredMoments) {
                System.out.println("- " + m.getMomentTitle() + ": " + m.getDescription());
            }
        }
        
        return filteredMoments;
        

    }

}
