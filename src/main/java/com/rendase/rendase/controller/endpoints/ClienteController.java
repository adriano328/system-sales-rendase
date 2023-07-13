package com.rendase.rendase.controller.endpoints;

import com.rendase.rendase.controller.dto.ClienteDTO;
import com.rendase.rendase.controller.dto.GetAllWithName;
import com.rendase.rendase.domain.Cliente;
import com.rendase.rendase.services.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("cliente")
public class ClienteController {

    private final ClienteService clienteService;
    public static final int PAGE_SIZE = 5;
    @PostMapping
    ResponseEntity<Cliente> salvar(@RequestBody ClienteDTO clienteDTO) {
        clienteService.salvar(clienteDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PatchMapping
    ResponseEntity<Void> alterar(final @RequestBody ClienteDTO clienteDTO) {
        clienteService.alterar(clienteDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/{id}")
    ResponseEntity<Cliente> getById(@PathVariable Long id) {
        return ResponseEntity.ok(clienteService.getById(id));
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> delete(@PathVariable Long id) {
        clienteService.delete(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

    @GetMapping("/getAllWithName")
    ResponseEntity<Page<GetAllWithName>> getAllWithFilter(
            @RequestParam(name = "nome", required = false) String nome,
            @PageableDefault(value = PAGE_SIZE, sort = "nome") Pageable pageable
    ) {
        return ResponseEntity.ok(clienteService.getAllWithName(nome, pageable));
    }

}
