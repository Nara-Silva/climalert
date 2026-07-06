package ar.edu.utn.frba.ddsi.mappers;

import ar.edu.utn.frba.ddsi.dto.WeatherApiResponse;
import ar.edu.utn.frba.ddsi.models.entities.Clima;

import java.time.LocalDateTime;

public class ClimaMapper {

  public static Clima toEntity(WeatherApiResponse response) {

    return new Clima(
        response.getUbicacion().getNombre(),
        response.getActual().getTemperatura(),
        response.getActual().getHumedad(),
        response.getActual().getCondicion().getDescripcion(),
        LocalDateTime.now()
    );
  }

}