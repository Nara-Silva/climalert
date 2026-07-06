package ar.edu.utn.frba.ddsi.services;

import ar.edu.utn.frba.ddsi.models.entities.Alerta;
import ar.edu.utn.frba.ddsi.models.entities.Clima;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Slf4j
@Service
public class AlertaService {

  private static final String[] destinatarios = {
      "admin@clima.com",
      "emergencias@clima.com",
      "meteorologia@clima.com"
  };

  private final EmailService emailService;

  public AlertaService(EmailService emailService) {
    this.emailService = emailService;
  }

  public void procesar(Clima clima) {

    if (!esCondicionCritica(clima)) {
      log.info("No se detectaron condiciones críticas");
      return;
    }

    if (clima.isAlertaEnviada()) {
      log.info("La alerta correspondiente a este registro climático ya fue enviada");
      return;
    }

    Alerta alerta = new Alerta(clima, LocalDateTime.now());

    log.warn(
        "ALERTA GENERADA. Ciudad={}, Temp={}°C, Humedad={}%",
        clima.getCiudad(), clima.getTemperatura(), clima.getHumedad());

    try {
      emailService.enviarAlerta(destinatarios, alerta);

      clima.marcarAlertaEnviada();
    } catch (Exception e) {

      log.error("No fue posible enviar la alerta", e);
    }
  }

  private boolean esCondicionCritica(Clima clima) {
    return clima.getTemperatura() > 35 && clima.getHumedad() > 60;
  }
}