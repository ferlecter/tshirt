package br.com.tshirt.repository;

import br.com.tshirt.entities.Tipo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoRepository extends CrudRepository<Tipo, Integer> {
    Tipo buscarTipoPorId(int id);
}

