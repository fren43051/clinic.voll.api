package clinic.voll.api.medico;

import clinic.voll.api.direccion.DatosDireccion;
import jakarta.validation.constraints.NotNull;

public record DatosActualizarMedico(@NotNull long id, String nombre, String documento, DatosDireccion direccion) {
}
