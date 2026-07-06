package ar.edu.utn.frba.ddsi.clients;

import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MailClient {

  private final JavaMailSender javaMailSender;

  public MailClient(JavaMailSender javaMailSender) {
    this.javaMailSender = javaMailSender;
  }

  public void enviar(
      String[] destinatarios,
      String asunto,
      String cuerpo) {

    try {

      SimpleMailMessage mensaje = new SimpleMailMessage();

      mensaje.setTo(destinatarios);
      mensaje.setSubject(asunto);
      mensaje.setText(cuerpo);

      javaMailSender.send(mensaje);

      log.info("Correo enviado correctamente a {} destinatarios", destinatarios.length);

    } catch (Exception e) {

      log.error("Error al enviar el correo", e);

      throw new RuntimeException("Upsss! No fue posible enviar el correo", e);
    }
  }
}