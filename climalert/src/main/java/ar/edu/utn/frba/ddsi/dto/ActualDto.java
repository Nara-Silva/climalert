package ar.edu.utn.frba.ddsi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ActualDto {

  @JsonProperty("temp_c")
  private Double temperatura;

  @JsonProperty("humidity")
  private Integer humedad;

  @JsonProperty("condition")
  private CondicionDto condicion;
}
