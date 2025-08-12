package dev.yolanda.dtos;

import java.util.Date;

import dev.yolanda.models.Emotion;

public record MomentDTO(int id, String momentTitle, String description, Emotion emotion, Date date) {

}
