package dev.yolanda.views;

import java.util.List;

import dev.yolanda.controllers.MomentController;
import dev.yolanda.dtos.MomentDTO;

public class MomentView extends View{
    MomentController controller = new MomentController();

    public void showAllMoments() {

        List<MomentDTO> dtos = controller.GetAllMoments();
        dtos.forEach(dto -> System.out.println(
            dto.id() + ". " +
            "Ocurrió el: " + dto.date() +
            "Título: " + dto.momentTitle() + ". " + 
            "Descripción: " + dto.description() + 
            "Emoción: " + dto.emotion()));
    }
}