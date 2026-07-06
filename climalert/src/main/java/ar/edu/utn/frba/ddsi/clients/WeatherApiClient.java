package ar.edu.utn.frba.ddsi.clients;

import ar.edu.utn.frba.ddsi.dto.WeatherApiResponse;
import ar.edu.utn.frba.ddsi.mappers.ClimaMapper;
import ar.edu.utn.frba.ddsi.models.entities.Clima;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Component
public class WeatherApiClient {

  private final RestTemplate restTemplate;

  @Value("${weather.api.url}")
  private String url;

  @Value("${weather.api.key}")
  private String apiKey;

  @Value("${weather.api.location}")
  private String ubicacion;

  @Value("${weather.api.language}")
  private String idioma;

  public WeatherApiClient(RestTemplate restTemplate) {
    this.restTemplate = restTemplate;
  }

  public Clima obtenerClimaActual() {
   String endpoint = UriComponentsBuilder
        .fromUriString(url)
        .queryParam("key", apiKey)
        .queryParam("q", ubicacion)
        .queryParam("lang", idioma)
        .toUriString();

    WeatherApiResponse response =
        restTemplate.getForObject(endpoint, WeatherApiResponse.class);

    return ClimaMapper.toEntity(response);

  }
}
