package ar.edu.utn.frba.ddsi.services;

import ar.edu.utn.frba.ddsi.clients.WeatherApiClient;
import ar.edu.utn.frba.ddsi.models.entities.Clima;
import ar.edu.utn.frba.ddsi.models.repositories.ClimaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class ClimaService {

  private final WeatherApiClient weatherApiClient;
  private final ClimaRepository repository;

  public ClimaService(WeatherApiClient weatherApiClient, ClimaRepository repository) {
    this.weatherApiClient = weatherApiClient;
    this.repository = repository;
  }

  public Clima actualizarClima() {

    try {

      Clima clima = weatherApiClient.obtenerClimaActual();

      repository.guardar(clima);

      log.info(
          "Clima registrado. Ciudad={}, Temp={}°C, Humedad={}%",
          clima.getCiudad(), clima.getTemperatura(), clima.getHumedad());

      return clima;

    } catch (Exception e) {

      log.error("Error consultando WeatherAPI", e);

      throw new RuntimeException("Oh no! No fue posible obtener el clima", e);
    }
  }

  public Optional<Clima> obtenerUltimoClima() {
    return repository.obtenerUltimo();
  }

  public List<Clima> obtenerHistorial() {
    return repository.obtenerTodos();
  }
}

