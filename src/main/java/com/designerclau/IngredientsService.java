package com.designerclau;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IngredientsService {
	
    @Autowired
	private IngredientsRepository repo;
    
    public List<Ingredients> listAll(){
    	return repo.findAll();
    }
    
    public void save(Ingredients ingredients) {
    	repo.save(ingredients);
    }
    
    public Ingredients get(Long id) {
    	return repo.findById(id).get();
    }
    
    public void delete(Long id) {
    	repo.deleteById(id);
    }
}
