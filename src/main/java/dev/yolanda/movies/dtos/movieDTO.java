package dev.yolanda.movies.dtos;

import com.google.gson.annotations.SerializedName;

import dev.yolanda.movies.VO.ShortInfoVO;

public class MovieDTO {
    // imdbId property
    private String imdbId;

    @SerializedName("short")
    private ShortInfoVO shortInfo;

    public String getImdbId() {
        return imdbId;
    }

    public ShortInfoVO getShortInfo() {
        return shortInfo;
    }
}
