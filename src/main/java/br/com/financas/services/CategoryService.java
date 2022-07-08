package br.com.financas.services;

import br.com.financas.entity.Category;
import br.com.financas.repository.CategoryRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> list(){
        return categoryRepository.findAll();
    }

    public Optional<Category> searchById(Long id){
        return categoryRepository.findById(id);
    }

    public Category save (Category category){
        return categoryRepository.save(category);
    }


    public Category update (Long id, Category category){
        Category categoriaSalvar = validateCategory(id);
        BeanUtils.copyProperties(category, categoriaSalvar, "id");
        return categoryRepository.save(categoriaSalvar);
    }


    public void delete (Long id){
        categoryRepository.deleteById(id);
    }

    private Category validateCategory (Long id){
        Optional<Category> category = searchById(id);
        if (category.isEmpty()){
            throw new EmptyResultDataAccessException(1);
        }
        return category.get();
    }


}