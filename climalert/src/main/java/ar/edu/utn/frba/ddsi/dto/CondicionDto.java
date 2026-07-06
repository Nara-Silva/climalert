package ar.edu.utn.frba.ddsi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CondicionDto {

  @JsonProperty("text")
  private String descripcion;
}
