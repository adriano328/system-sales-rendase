package com.rendase.rendase.repositories;

import com.rendase.rendase.controller.dto.GetAllWithName;
import com.rendase.rendase.domain.Cliente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    @Query("select new com.rendase.rendase.controller.dto.GetAllWithName("
            + "c.id, c.nome) from Cliente c "
            + "where (:nome IS null OR c.nome LIKE %:nome%)")
    Page<GetAllWithName> getAllWithName(String nome, Pageable pageable);

}