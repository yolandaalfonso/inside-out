package dev.yolanda.dtos;

import java.time.LocalDate;

import dev.yolanda.models.Emotion;

public record MomentDTO(int id, String momentTitle, String description, Emotion emotion, LocalDate date) {

}
