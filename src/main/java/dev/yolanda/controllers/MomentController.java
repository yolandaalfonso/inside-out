package dev.yolanda.controllers;

import dev.yolanda.mappers.MomentMapper;
import dev.yolanda.models.Moment;
import dev.yolanda.repositories.MomentRepository;

public class MomentController {

    private MomentRepository repository;

    public MomentController() {
        this.repository = MomentRepositorySingleton.getInstance();
    }

    public void StoreMoment(MomentDTO momentDTO) {
        Moment momentToSave = MomentMapper.toEntity(momentDTO);
        repository.StoreMoment(momentToSave);
    }
    
}
