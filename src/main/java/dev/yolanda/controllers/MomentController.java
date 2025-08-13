package dev.yolanda.controllers;

import java.util.List;

import dev.yolanda.dtos.MomentDTO;
import dev.yolanda.mappers.MomentMapper;
import dev.yolanda.models.Moment;
import dev.yolanda.repositories.MomentRepository;
import dev.yolanda.singletons.MomentRepositorySingleton;

public class MomentController {

    private MomentRepository repository;

    public MomentController() {
        this.repository = MomentRepositorySingleton.getInstance();
    }

    public void StoreMoment(MomentDTO momentDTO) {
        Moment momentToSave = MomentMapper.toEntity(momentDTO);
        repository.StoreMoment(momentToSave);
    }

    public List<MomentDTO> GetAllMoments() {
        List<Moment> moments = repository.GetAllMoments();
        return MomentMapper.toDTOList(moments);
    }
    
}
