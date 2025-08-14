package dev.yolanda.mappers;

import dev.yolanda.dtos.MomentDTO;
import dev.yolanda.models.Moment;

public class MomentMapper {
    public static Moment toEntity(MomentDTO dto){
        //Si esta mal es culpa de Iván
        Moment moment = new Moment(dto.id(), dto.momentTitle(),dto.description(),dto.emotion(),dto.date());

        return moment;
    }
}


