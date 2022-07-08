package br.com.financas.controller;

import br.com.financas.dto.category.CategoryResponseDTO;
import br.com.financas.dto.category.CategoryResquestDTO;
import br.com.financas.entity.Category;
import br.com.financas.services.CategoryService;
import br.com.financas.services.EntryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Api(tags = "Categorias")
@RestController
@RequestMapping("/categorias")

public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private EntryService entryService;

    @ApiOperation(value = "Listar categorias")
    @GetMapping(name = "Listar categorias")
    public List<Category> list(){
        return categoryService.list();
    }

    @ApiOperation(value = "Listar categoria pelo ID")
    @GetMapping(name = "Listar categoria pelo ID", path = {"/{id}"})
    public ResponseEntity<CategoryResponseDTO> listCategoyById(@PathVariable Long id) {
        Optional<Category> category = categoryService.searchById(id);
        return category.isPresent() ? ResponseEntity.ok(CategoryResponseDTO.convertToCategoryDTO(category.get())) : ResponseEntity.notFound().build();
    }

    @ApiOperation(value = "Criar categoria")
    @PostMapping(name = "Criar categoria")
    public ResponseEntity<CategoryResponseDTO> save(@Valid @RequestBody CategoryResquestDTO categoryDto) {
        Category categorySave = categoryService.save(categoryDto.convertToEntity());
        return ResponseEntity.status(HttpStatus.CREATED).body(CategoryResponseDTO.convertToCategoryDTO(categorySave));
    }

    @ApiOperation(value = "Atualizar categoria")
    @PutMapping(name = "Atualizar categoria", path = {"/{id}"})
    public ResponseEntity<CategoryResponseDTO> update(@PathVariable Long id, @Valid @RequestBody CategoryResquestDTO categoryDto) {
        Category categoryUpdate = categoryService.update(id, categoryDto.convertToEntity(id));
        return ResponseEntity.ok(CategoryResponseDTO.convertToCategoryDTO(categoryUpdate));
    }

    @ApiOperation(value = "Deletar categoria")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(name = "Deletando Categoria", path = {"/{id}"})
    public void delete(@PathVariable Long id) {
        categoryService.delete(id);
    }



}