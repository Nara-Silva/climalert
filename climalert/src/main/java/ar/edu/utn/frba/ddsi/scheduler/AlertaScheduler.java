package ar.edu.utn.frba.ddsi.scheduler;

import ar.edu.utn.frba.ddsi.services.AlertaService;
import ar.edu.utn.frba.ddsi.services.ClimaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class AlertaScheduler {

  private final ClimaService climaService;
  private final AlertaService alertaService;

  public AlertaScheduler(ClimaService climaService, AlertaService alertaService) {

    this.climaService = climaService;
    this.alertaService = alertaService;
  }

  @Scheduled(fixedRate = 60000)
  public void analizarClima() {
    climaService.obtenerUltimoClima().ifPresent(alertaService::procesar);
  }

}