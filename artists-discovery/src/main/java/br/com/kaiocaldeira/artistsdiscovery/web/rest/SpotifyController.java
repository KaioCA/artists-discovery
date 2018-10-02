package br.com.kaiocaldeira.artistsdiscovery.web.rest;

import br.com.kaiocaldeira.artistsdiscovery.service.dto.ObjectDto;
import br.com.kaiocaldeira.artistsdiscovery.service.dto.TokenDto;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("search")
public class SpotifyController {

    @GetMapping
    @ResponseBody
    public Object getArtistRelated(@RequestParam String name) {
        String url = "https://api.spotify.com/v1/search";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer " + getTokenApi());
        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(url)

                .queryParam("q", name)
                .queryParam("type", "artist")
                .queryParam("limit", "5");

        RestTemplate restTemplate = new RestTemplate();
        final HttpEntity<String> entity = new HttpEntity<String>(headers);
        ResponseEntity<ObjectDto> response = restTemplate.exchange(uriBuilder.toUriString(), HttpMethod.GET, entity, ObjectDto.class);
        return response.getBody();
    }



@PostMapping()
public  Object getTokenApi(){
    String url = "https://accounts.spotify.com/api/token";
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
    headers.set("Authorization", "Basic " + "M2ZiZGI2YjY1ZjQ3NDIxZDhhNzk1NTAwYmFmMDY2MjM6NjNiYjcyMjgyN2M0NGZlNTkxOTFkZjVhZGJjMTY1MTk=");

    MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
    map.add("grant_type", "client_credentials");
    RestTemplate restTemplate = new RestTemplate();
    HttpEntity<MultiValueMap<String, String>> entity =
            new HttpEntity<MultiValueMap<String, String>>(map, headers);


    ResponseEntity<TokenDto> response = restTemplate.exchange(url, HttpMethod.POST, entity, TokenDto.class);
    return response.getBody().getAccess_token();


}

}
