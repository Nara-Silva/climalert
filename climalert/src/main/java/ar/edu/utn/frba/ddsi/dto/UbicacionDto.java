package ar.edu.utn.frba.ddsi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
public class UbicacionDto {

  @JsonProperty("name")
  private String nombre;

  @JsonProperty("country")
  private String pais;
}
