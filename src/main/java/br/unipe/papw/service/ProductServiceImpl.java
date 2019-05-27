package br.unipe.papw.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.unipe.papw.model.Product;
import br.unipe.papw.repository.ProductRepository;

@Service
public class ProductServiceImpl 
                     implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	
	/**
	 * Para você aluno melhorar.
	 * @param id
	 * @return
	 */
	public Product save(Product produto) {
		return productRepository.save(produto);
	}
	
	/**
	 * Para você aluno melhorar.
	 * @param id
	 * @return
	 */
	public void update(Product produto) {
		
		 productRepository.save(produto);
	}
	
	
	/**
	 * Para você aluno melhorar.
	 * @param id
	 * @return
	 */
	public void delete(Long id) {
		//Ex: Prezado aluno localize o problema desse ponto e faça alteração.
		Product productDelete = productRepository.
				findById(id).get();
		
		 productRepository.delete(productDelete);
	}

	/**
	 * Para você aluno melhorar.
	 * @param id
	 * @return
	 */
	public Product findByName(String nome) {
		return productRepository.findByName(nome);
	}

	/**
	 * Para você aluno melhorar.
	 * @param id
	 * @return
	 */
	public Product findById(Long id) {
		return productRepository.findById(id).get();
	}
	
	
	/**
	 * Para você aluno melhorar.
	 * @param id
	 * @return
	 */
	public List<Product> findAll(){
		return productRepository.findAll();
	}

}
