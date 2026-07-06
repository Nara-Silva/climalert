package ar.edu.utn.frba.ddsi.models.entities;

import lombok.Getter;
import java.time.LocalDateTime;

@Getter
public class Clima {

  private final String ciudad;
  private final Double temperatura;
  private final Integer humedad;
  private final String condicion;
  private final LocalDateTime fechaConsulta;

  private boolean alertaEnviada;


  public Clima(String ciudad, Double temperatura, Integer humedad, String condicion, LocalDateTime fechaConsulta) {
    this.ciudad = ciudad;
    this.temperatura = temperatura;
    this.humedad = humedad;
    this.condicion = condicion;
    this.fechaConsulta = fechaConsulta;
    this.alertaEnviada = false;
  }

  public void marcarAlertaEnviada() {
    this.alertaEnviada = true;
  }
}
