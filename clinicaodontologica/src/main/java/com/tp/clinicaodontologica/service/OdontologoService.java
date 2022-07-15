package com.tp.clinicaodontologica.service;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tp.clinicaodontologica.exceptions.InvalidDataResource;
import com.tp.clinicaodontologica.exceptions.ResourceNotFoundException;
import com.tp.clinicaodontologica.model.Odontologo;
import com.tp.clinicaodontologica.model.OdontologoDTO;
import com.tp.clinicaodontologica.repository.IOdontologoRepository;
import org.springframework.stereotype.Service;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class OdontologoService implements IOdontologoService{

    private final IOdontologoRepository odontologoRepository;
    private final ObjectMapper mapper;

    public OdontologoService(IOdontologoRepository odontologoRepository, ObjectMapper mapper) {
        this.odontologoRepository = odontologoRepository;
        this.mapper = mapper;
    }


    @Override
    public void crearOdontologo(OdontologoDTO odontologoDTO) {
        Odontologo odontologo = mapper.convertValue(odontologoDTO, Odontologo.class);
        odontologoRepository.save(odontologo);
    }

    @Override
    public Optional<OdontologoDTO> buscarPorId(Long id) throws ResourceNotFoundException {
        Optional<Odontologo> odontologo = odontologoRepository.findById(id);
        OdontologoDTO odontologoDTO = null;
        if(odontologo.isPresent()){
            odontologoDTO = mapper.convertValue(odontologo, OdontologoDTO.class);
        }else{
            throw new ResourceNotFoundException(String.format("odontologo no encontrado"));
        }
        return Optional.ofNullable(odontologoDTO);
    }

    @Override
    public void modificarOdontologo(OdontologoDTO odontologoDTO) {
        Odontologo odontologo = mapper.convertValue(odontologoDTO, Odontologo.class);
        odontologoRepository.save(odontologo);

    }

    @Override
    public void eliminarPorId(Long id) {
        odontologoRepository.deleteById(id);

    }

    @Override
    public Set<OdontologoDTO> listarTodos() {
        List<Odontologo> odontologos  =odontologoRepository.findAll();
        Set<OdontologoDTO> odontologosDTO = new HashSet<>();
        for (Odontologo odontologo: odontologos ) {
            odontologosDTO.add(mapper.convertValue(odontologo, OdontologoDTO.class));
        }
        return odontologosDTO;

    }


    // ------------SIN ORM---------------

    /*@Autowired
    private IDao<Odontologo> odontologoDao;

    @Autowired
    private IOdontologoRepository IOdontologoRepository;

   /* public String registrarOdontologo(Odontologo odontologo){
        if(odontologoRepository.save(odontologo) !=null){
            return "ok";
        }else {
            return null;
        }
    }*/


    /*public Odontologo registrarOdontologo(Odontologo odontologo) {
        return odontologoDao.guardar(odontologo);

    }

    public void eliminar(Long id) {
        odontologoDao.eliminar(id);
    }

    public Optional<Odontologo> buscar(Long id) {
        return Optional.ofNullable(odontologoDao.buscar(id));
    }

    public List<Odontologo> buscarTodos() {
        return odontologoDao.buscarTodos();
    }

    public Optional<Odontologo> modificar(Odontologo odontologo) {
        return Optional.ofNullable(odontologoDao.actualizar(odontologo));
    }

*/
}
