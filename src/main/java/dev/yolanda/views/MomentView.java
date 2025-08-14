package dev.yolanda.views;

import java.util.List;

import dev.yolanda.dtos.MomentDTOResponse;

public class MomentView extends View{
    //MomentController controller = new MomentController();

    /*public static void showAllMoments(List<MomentDTOResponse> moments) {
        
        //if (List<CharacterDTOResponse>)
        }else{
        //List<MomentDTO> dtos = controller.GetAllMoments();
        dtos.forEach(dto -> System.out.println(
            dto.id() + ". " +
            "Ocurrió el: " + dto.date() +
            "Título: " + dto.momentTitle() + ". " + 
            "Descripción: " + dto.description() + 
            "Emoción: " + dto.emotion()));
        }
    }*/

    public static void showAllMoments(List<MomentDTOResponse> moments) {
        System.out.println("Lista de momentos vividos:");
        for (MomentDTOResponse moment : moments) {
            System.out.println(moment.id() + "Ocurrió el: " + moment.date() + ". Título:" + moment.momentTitle() + ". Descripción: " + moment.description() + ". Emocion:" + moment.emotion());
        }
    }
}