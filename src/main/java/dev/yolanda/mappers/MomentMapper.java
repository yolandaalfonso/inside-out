package dev.yolanda.mappers;

import java.util.ArrayList;
import java.util.List;

import dev.yolanda.dtos.MomentDTO;
import dev.yolanda.models.Moment;

public class MomentMapper {
    public static Moment toEntity(MomentDTO dto){
        //Si esta mal es culpa de Iván
        Moment moment = new Moment(dto.id(), dto.momentTitle(),dto.description(),dto.emotion(),dto.date());

        return moment;
    }

    public static MomentDTO toDTO(Moment entity) {
        return new MomentDTO(
            entity.getId(),
            entity.getMomentTitle(),
            entity.getDescription(),
            entity.getEmotion(),
            entity.getDate()
            //entity.getCreationDate(),
            //entity.getModificationDate()
        );
    } 

    public static List<MomentDTO> toDTOList(List<Moment> moments) {
        List<MomentDTO> dtos = new ArrayList<>();
        for (Moment moment : moments) {
            dtos.add(MomentMapper.toDTO(moment));
        }
        return dtos;
    }
}


