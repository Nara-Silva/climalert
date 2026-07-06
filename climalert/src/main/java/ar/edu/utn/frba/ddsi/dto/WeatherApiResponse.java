package ar.edu.utn.frba.ddsi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
public class WeatherApiResponse {

  @JsonProperty("location")
  private UbicacionDto ubicacion;

  @JsonProperty("current")
  private ActualDto actual;
}
