package ar.edu.utn.frba.ddsi.models.entities;

import lombok.Getter;
import java.time.LocalDateTime;

@Getter
public class Alerta {
  private final Clima clima;
  private final LocalDateTime fechaGeneracion;

  public Alerta(Clima clima, LocalDateTime fechaGeneracion) {
    this.clima = clima;
    this.fechaGeneracion = fechaGeneracion;
  }
}
