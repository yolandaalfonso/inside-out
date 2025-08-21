package dev.yolanda.controllers;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import dev.yolanda.dtos.MomentDTO;
import dev.yolanda.dtos.MomentDTOResponse;
import dev.yolanda.mappers.MomentMapper;
import dev.yolanda.models.Emotion;
import dev.yolanda.models.Moment;
import dev.yolanda.models.Mood;
import dev.yolanda.repositories.MomentRepository;
import dev.yolanda.services.MomentCSVService;
import dev.yolanda.singletons.MomentRepositorySingleton;
import dev.yolanda.views.MomentView;

public class MomentController {

    private MomentRepository repository;
    private final MomentCSVService csvService = new MomentCSVService();

    public MomentController() {
        this.repository = MomentRepositorySingleton.getInstance();
    }

    public void StoreMoment(MomentDTO momentDTO) {
        Moment momentToSave = MomentMapper.toEntity(momentDTO);
        repository.StoreMoment(momentToSave);
    }

    public  void GetAllMoments() {
        List<MomentDTOResponse> momentsDTO = new ArrayList<>();
        List<Moment> moments = repository.GetAllMoments();

        for (Moment moment : moments) {
            momentsDTO.add(new MomentDTOResponse(moment.getId(), moment.getMomentTitle(), moment.getDescription(), moment.getEmotion(),moment.getDate(), moment.getMood()));
        }

        MomentView.showAllMoments(momentsDTO);
    }

    public void deleteMoment(int id) {
        //Moment momentToDelete = MomentMapper.toEntity(momentDTO);
        repository.deleteMoment(id);
    }

    public List<Moment> getMomentsByEmotion(Emotion emotion) {
        return repository.filterByEmotion(emotion);
    }
    
    public List<Moment> getMomentsByDate(int month, int year) {
        return repository.filterByDate(month, year);
    }

    public List<Moment> getMomentsByMood(Mood mood) {
        return repository.filterByMood(mood);
    }

    /*public void exportMomentCsv(Path path) throws Exception {
        csvService.export(repository.GetAllMoments(), path);
    }*/

     public void exportMomentsCsv(Path path) throws IOException {
        List<Moment> moments = repository.GetAllMoments();
        csvService.export(moments, path);
    }


    

    /*public List<MomentDTO> GetAllMoments() {
        List<Moment> moments = repository.GetAllMoments();
        return MomentMapper.toDTOList(moments);
    }*/
    
    /*public static MomentDTO toDTO(Moment entity) {
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
    }*/
}
