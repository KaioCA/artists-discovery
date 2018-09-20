package br.com.kaiocaldeira.artistsdiscovery.service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class ObjectDto {

    private ArtistsDto artists;

    public ArtistsDto getArtists() {
        return artists;
    }

    public void setArtists(ArtistsDto artists) {
        this.artists = artists;
    }
}
