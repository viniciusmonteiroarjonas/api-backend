package br.com.financas.services;
import br.com.financas.entity.Category;
import br.com.financas.entity.Entry;
import br.com.financas.repository.CategoryRepository;
import br.com.financas.repository.EntryRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EntryService {
    @Autowired
    private EntryRepository entryRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    Double totalAmount;
    String typeCategory;


    public List<Entry> list() {
        return entryRepository.findAll();
    }

    public Optional<Entry> searchById(Long id) {
        return entryRepository.findById(id);
    }

    public Optional<Category> searchIdCategory(Long id) {
        return categoryRepository.findById(id);
    }

    public Entry saveEntry(Entry entry, Category categoria) {
        Category category = validateCategoryById(categoria.getId());
        return entryRepository.save(entry);
    }

    public Entry update(Long id, Entry entry) {
        Entry entrySalvar = validateEntry(id);
        BeanUtils.copyProperties(entry, entrySalvar, "id");
        return entryRepository.save(entrySalvar);
    }


    public void delete(Long id) {
        entryRepository.deleteById(id);
    }

    private Entry validateEntry(Long id) {
        Optional<Entry> entry = searchById(id);
        if (entry.isEmpty()) {
            throw new EmptyResultDataAccessException(1);
        }
        return entry.get();
    }

    private Category validateCategoryById(Long id) {
        Optional<Category> categoria = searchIdCategory(id);
        if (categoria.isEmpty()) {
            throw new EmptyResultDataAccessException(1);
        }
        return categoria.get();
    }

}