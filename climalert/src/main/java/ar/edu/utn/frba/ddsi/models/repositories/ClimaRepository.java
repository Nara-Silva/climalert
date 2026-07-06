package ar.edu.utn.frba.ddsi.models.repositories;

import ar.edu.utn.frba.ddsi.models.entities.Clima;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ClimaRepository {

  private final List<Clima> historial = new ArrayList<>();

  public void guardar(Clima clima) {
    historial.add(clima);
  }

  public Optional<Clima> obtenerUltimo() {

    if (historial.isEmpty()) {
      return Optional.empty();
    }

    return Optional.of(historial.get(historial.size() - 1));
  }

  public List<Clima> obtenerTodos() {
    return List.copyOf(historial);
  }
}