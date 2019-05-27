package br.unipe.papw.service;

import java.util.List;

import br.unipe.papw.model.Product;

public interface ProductService {

	Product save(Product produto);
	Product findByName(String nome);
	Product findById(Long id);
	List<Product> findAll();
	void update(Product produto);
	void delete(Long id);
	
}
