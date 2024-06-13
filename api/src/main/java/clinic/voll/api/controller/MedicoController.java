package clinic.voll.api.controller;

import clinic.voll.api.medico.DatosListadoMedico;
import clinic.voll.api.medico.DatosRegistroMedico;
import clinic.voll.api.medico.Medico;

import clinic.voll.api.medico.MedicoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository medicoRepository;

    @PostMapping
    public void registrarMedico(@RequestBody @Valid DatosRegistroMedico datosRegistroMedico) {
        medicoRepository.save(new Medico(datosRegistroMedico));
    }

    @GetMapping
    public Page<DatosListadoMedico> listadoMedicos(Pageable paginacion) {
        return medicoRepository.findAll(paginacion).map(DatosListadoMedico::new);
    }
}
