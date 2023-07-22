package com.rendase.rendase.controller.endpoints;

import com.rendase.rendase.domain.Cor;
import com.rendase.rendase.domain.Produto;
import com.rendase.rendase.domain.Tamanho;
import com.rendase.rendase.services.TamanhoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("tamanho")
public class TamanhoController {

    private final TamanhoService tamanhoService;

    @PostMapping
    ResponseEntity<Tamanho> salvar(@RequestBody Tamanho tamanho) {
        tamanhoService.save(tamanho);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/{id}")
    ResponseEntity<Tamanho> getById(@PathVariable Long id) {
        return ResponseEntity.ok(tamanhoService.getById(id));
    }

    @GetMapping("/getAllTamanho")
    public ResponseEntity<List<Tamanho>> getAllTamanho() {
        return ResponseEntity.ok(tamanhoService.getAllCor());
    }
}
