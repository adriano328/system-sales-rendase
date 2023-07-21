package com.rendase.rendase.controller.endpoints;

import com.rendase.rendase.controller.dto.GetAllWithProduto;
import com.rendase.rendase.domain.Cliente;
import com.rendase.rendase.domain.Produto;
import com.rendase.rendase.services.ProdutoService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("produto")
public class ProdutoController {

    public static final int PAGE_SIZE = 5;

    private final ProdutoService produtoService;

    @PostMapping
    ResponseEntity<Produto> salvar(@RequestBody Produto produto) {
        produtoService.save(produto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/{id}")
    ResponseEntity<Produto> getById(@PathVariable Long id) {
       return ResponseEntity.ok(produtoService.getById(id));
    }

    @GetMapping("/getAllProdutoWithFilter")
    public ResponseEntity<Page<GetAllWithProduto>> getAllProduto(
            @RequestParam(name = "descricao", required = false) String descricao,
            @RequestParam(name = "categoria", required = false) String categoria,
            @RequestParam(name = "cor", required = false) String cor,
            @RequestParam(name = "tamanho", required = false) String tamanho,
            @RequestParam(name = "sexo", required = false) String sexo,
            @PageableDefault(value = PAGE_SIZE, sort = "descricao") Pageable pageable
    ) {
        return ResponseEntity.ok(produtoService.getAllWithName(descricao, categoria, tamanho, cor, sexo, pageable));
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> delete(@PathVariable Long id) {
        produtoService.delete(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

    @PutMapping
    ResponseEntity<Cliente> alterar(@RequestBody Produto produto) {
        produtoService.alterar(produto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }


}
