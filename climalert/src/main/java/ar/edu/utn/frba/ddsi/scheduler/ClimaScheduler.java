package ar.edu.utn.frba.ddsi.scheduler;

import ar.edu.utn.frba.ddsi.services.ClimaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ClimaScheduler {

  private final ClimaService climaService;

  public ClimaScheduler(ClimaService climaService) {
    this.climaService = climaService;
  }

  @Scheduled(fixedRate = 300000)
  public void actualizarClima() {

    log.info("Consultando WeatherAPI...");

    climaService.actualizarClima();
  }
}