package dev.yolanda.movies.dtos;

public class movieDTO {
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
