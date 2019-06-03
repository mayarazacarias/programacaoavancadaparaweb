package br.unipe.papw.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.unipe.papw.model.Product;
import br.unipe.papw.service.ProductService;
import br.unipe.papw.validator.ProductValidator;


@Controller
public class ProductController {
	
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private ProductValidator productValidator;
	
	/**
	 * Para você aluno melhorar.
	 * @param id
	 * @return
	 */
	@GetMapping("/product")
	public String listProduct(Model model) {
				
		List<Product> listProduct = productService.findAll();	
		model.addAttribute("listProduct",listProduct);		
		return "module/product/index";
	}
	
	/**
	 * Para você aluno melhorar.
	 * @param id
	 * @return
	 */
	@PostMapping("/product")
	public String save(@ModelAttribute("productForm") Product product, BindingResult bindingResult) {
		 if (bindingResult.hasErrors()) {
	            return "module/product/productForm";
	        }
		 productService.save(product);

		 
		return "module/product/index";
	}

	/**
	 */
	@GetMapping("/product/delete/{id}")
	public String delete(@PathVariable("id") Long id) {
				
		productService.delete(id);	
	
		return "redirect:/product";
	}
	
	
	@GetMapping("/product/update/{id}")
	public String update(@PathVariable("id") Long id, Model model) {
		
		Product product = productService.findById(id);
		model.addAttribute("productUpdate",product);
		 
		return "module/product/formUpdateProduct";
	}
	
	
	
	@PostMapping("/product/update")
	public String update(@ModelAttribute("productUpdate") Product product, BindingResult bindingResult) {
		 if (bindingResult.hasErrors()) {
	            return "module/product/productForm";
	        }
		 productService.update(product);

		 
		return "module/product/index";
	}

	
	
	
	@GetMapping("/product/form")
	public String prepareProductForm(Model model) {
		Product produto = new Product();
		model.addAttribute("productForm",produto);		
		return "module/product/formProduct";
	}


}
