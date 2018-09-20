package br.com.kaiocaldeira.artistsdiscovery.web.rest;

import br.com.kaiocaldeira.artistsdiscovery.service.dto.ArtistsDto;
import br.com.kaiocaldeira.artistsdiscovery.service.dto.ObjectDto;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Map;

@RestController
@RequestMapping("/artistas")
public class SpotifyController {


    @GetMapping
    @ResponseBody
    public Object getArtistRelated(@RequestParam String name) {
        String url = "https://api.spotify.com/v1/search";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer " + "BQA7MHgOhzC3wcoIPAOWMncik2SOeg3xd7kV9xpLpQYysNEOMXTHz017jKRAOY2-Bmjx1f9rPX10_1EC9bt_8CoqPGrDRBkXbXzAhsM9cUJmO8duLtOarNC5jTtlS1LU_4q3mAZ371JjnPyGM4JSfiMVvpuB6u-z");
        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(url)

                .queryParam("q", name)
                .queryParam("type", "artist")
                .queryParam("limit", "5");

        RestTemplate restTemplate = new RestTemplate();
        final HttpEntity<String> entity = new HttpEntity<String>(headers);
        ResponseEntity<ObjectDto> response = restTemplate.exchange(uriBuilder.toUriString(), HttpMethod.GET, entity, ObjectDto.class);
        return response.getBody();
    }

}