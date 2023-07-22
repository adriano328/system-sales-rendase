package com.rendase.rendase.repositories;

import com.rendase.rendase.domain.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
