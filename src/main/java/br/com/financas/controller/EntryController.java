package br.com.financas.controller;

import br.com.financas.dto.entry.EntryResponseDTO;
import br.com.financas.entity.Entry;
import br.com.financas.services.EntryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Api(tags = "lancamentos")
@RestController
@RequestMapping("/lancamentos")

public class EntryController {
    @Autowired
    private EntryService entryService;


    @ApiOperation(value = "Listar Lançamentos")
    @GetMapping(name = "Listar Lançamentos")
    public List<EntryResponseDTO> list () {
        return entryService.list().stream().map(entry -> EntryResponseDTO.convertEntryDTO(entry)).collect(Collectors.toList());
    }

//    @ApiOperation(value = "Listar por ID")
//    @GetMapping("/{id}")
//    public ResponseEntity<Optional<Entry>> searchIdEntry(@PathVariable Long id) {
//        Optional<Entry> entry = entryService.searchIdEntry(id);
//        return entry.isPresent() ? ResponseEntity.ok(entry) : ResponseEntity.notFound().build();
//    }
//
//    @ApiOperation(value = "Criar")
//    @PostMapping
//    public ResponseEntity<Entry> save(@RequestBody Entry entry) {
//        Entry entrySave = entryService.saveEntry(entry, entry.getCategoryId());
//        return ResponseEntity.status(HttpStatus.CREATED).body(entrySave);
//    }
//
//    @ApiOperation(value = "Atualizar")
//    @PutMapping("/{id}")
//    public ResponseEntity<Entry> update(@PathVariable Long id, @RequestBody Entry entry) {
//        return ResponseEntity.ok(entryService.update(id, entry));
//    }
//
//    @ApiOperation(value = "Deletar")
//    @DeleteMapping("/{id}")
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    public void delete(@PathVariable Long id) {
//        entryService.delete(id);
//    }


}
