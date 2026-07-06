package ar.edu.utn.frba.ddsi.services;

import ar.edu.utn.frba.ddsi.clients.MailClient;
import ar.edu.utn.frba.ddsi.models.entities.Alerta;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

  private final MailClient mailClient;

  public EmailService(MailClient mailClient) {
    this.mailClient = mailClient;
  }

  public void enviarAlerta(String[] destinatarios, Alerta alerta) {

    String asunto = "🚨 Alerta Climática";

    String cuerpo = construirCuerpo(alerta);

    mailClient.enviar(destinatarios, asunto, cuerpo);
  }

  private String construirCuerpo(Alerta alerta) {

    return """
                Se detectaron condiciones climáticas críticas:

                Ciudad: %s
                Temperatura: %.1f°C
                Humedad: %d%%
                Condición: %s

                Fecha de consulta: %s
                Fecha de generación de la alerta: %s
                """
        .formatted(
            alerta.getClima().getCiudad(),
            alerta.getClima().getTemperatura(),
            alerta.getClima().getHumedad(),
            alerta.getClima().getCondicion(),
            alerta.getClima().getFechaConsulta(),
            alerta.getFechaGeneracion()
        );
  }
}