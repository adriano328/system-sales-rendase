package com.rendase.rendase.controller.endpoints;

import com.rendase.rendase.domain.Categoria;
import com.rendase.rendase.domain.Cor;
import com.rendase.rendase.domain.Produto;
import com.rendase.rendase.services.CorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("cor")
public class CorController {

    private final CorService corService;

    @PostMapping
    ResponseEntity<Produto> salvar(@RequestBody Cor cor) {
        corService.save(cor);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/{id}")
    ResponseEntity<Cor> getById(@PathVariable Long id) {
        return ResponseEntity.ok(corService.getById(id));
    }

    @GetMapping("/getAllCor")
    public ResponseEntity<List<Cor>> getAllCor() {
        return ResponseEntity.ok(corService.getAllCor());
    }
}
