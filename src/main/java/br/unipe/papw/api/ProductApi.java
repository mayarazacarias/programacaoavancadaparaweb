package br.unipe.papw.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.unipe.papw.model.Product;
import br.unipe.papw.service.ProductService;

@RestController
@RequestMapping("/api")
public class ProductApi {

	@Autowired
	private ProductService productService;
	
	
	@GetMapping("/products")
	public List<Product> listar() {
		
		return productService.findAll();
				
	}
	
	
	
	
	
	
	
}
