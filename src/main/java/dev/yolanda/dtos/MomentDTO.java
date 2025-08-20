package dev.yolanda.dtos;

import java.time.LocalDate;

import dev.yolanda.models.Emotion;
import dev.yolanda.models.Mood;

public record MomentDTO(int id, String momentTitle, String description, Emotion emotion, LocalDate date, Mood mood) {

}
