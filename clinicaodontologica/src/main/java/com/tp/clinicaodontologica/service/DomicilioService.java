package com.tp.clinicaodontologica.service;

import com.tp.clinicaodontologica.model.Domicilio;
import com.tp.clinicaodontologica.repository.IDomicilioRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class DomicilioService implements IDomicilioService{


    private final IDomicilioRepository domicilioRepository;

    public DomicilioService(IDomicilioRepository domicilioRepository) {
        this.domicilioRepository = domicilioRepository;
    }


    @Override
    public void crearDomicilio(Domicilio domicilio) {
        domicilioRepository.save(domicilio);

    }

    @Override
    public Optional<Domicilio> buscarPorId(Long id) {
        return domicilioRepository.findById(id);
    }

    @Override
    public void modificarDomicilio(Domicilio domicilio) {
        domicilioRepository.save(domicilio);

    }

    @Override
    public void eliminarPorId(Long id) {
        domicilioRepository.deleteById(id);

    }

    @Override
    public Set<Domicilio> listarTodos() {

        return (Set<Domicilio>) domicilioRepository.findAll();
    }


    // ------------SIN ORM---------------

    /*@Autowired
    private IDao<Domicilio> domicilioDao;

    public DomicilioService(IDao<Domicilio> domicilioDao) {
        this.domicilioDao = domicilioDao;
    }
    public Domicilio guardar(Domicilio d){
        domicilioDao.guardar(d);
        return d;
    }
    public Domicilio buscar(Long id){
        return domicilioDao.buscar(id);
    }
    public List<Domicilio> buscarTodos(){
        return domicilioDao.buscarTodos();
    }
    public void eliminar(Long id){
        domicilioDao.eliminar(id);
    }*/

}
