package com.rendase.rendase.controller.endpoints;

import com.rendase.rendase.controller.dto.GetAllWithProduto;
import com.rendase.rendase.domain.Categoria;
import com.rendase.rendase.domain.Cliente;
import com.rendase.rendase.domain.Produto;
import com.rendase.rendase.services.CategoriaService;
import com.rendase.rendase.services.ProdutoService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("categoria")
public class CategoriaController {

    private final CategoriaService categoriaService;

    @PostMapping
    ResponseEntity<Produto> salvar(@RequestBody Categoria categoria) {
        categoriaService.save(categoria);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/{id}")
    ResponseEntity<Categoria> getById(@PathVariable Long id) {
        return ResponseEntity.ok(categoriaService.getById(id));
    }

    @GetMapping("/getAllCategorias")
    public ResponseEntity<List<Categoria>> getAllCategoria() {
        return ResponseEntity.ok(categoriaService.getAllCategorias());
    }
}
