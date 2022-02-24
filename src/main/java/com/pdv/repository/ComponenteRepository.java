package com.pdv.repository;

import com.pdv.model.Componente;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComponenteRepository extends JpaRepository<Componente, Long> {
    List<Componente> produtoId(long produtoId);
}
