package com.devsuperior.dscatalog.resources;

import java.io.Serializable;
import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.devsuperior.dscatalog.dto.CategoryDTO;
import com.devsuperior.dscatalog.services.CategoryService;



@RestController
@RequestMapping("/categories") //rota rest do recurso
public class CategoryResource implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/* ResponseEntity encapsula uma resposta http (ele é do tipo generic, podemos 
	 * definir o dado que vai estar no payload(corpo da resposta)
	 */
	@Autowired
	private CategoryService service;
	
	@GetMapping
	public ResponseEntity<Page<CategoryDTO>> findAll(Pageable pageable){
		
		
		Page<CategoryDTO> list = service.findAllPaged(pageable);
		return ResponseEntity.ok().body(list); // .ok deixa responder uma resposta 200
		
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<CategoryDTO> findById(@PathVariable Long id) {
		CategoryDTO dto = service.findById(id);
		return ResponseEntity.ok().body(dto); // .ok deixa responder uma resposta 200
		
	}
	
	@PostMapping //RequestBody para reconhecer o objeto na requesicao
	public ResponseEntity<CategoryDTO> insert(@RequestBody CategoryDTO dto) {
		dto = service.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(dto.getId()).toUri(); //uri instanciada para mudar a resposta http
		return ResponseEntity.created(uri).body(dto);// colocar created no lugar de ok e passar o uri
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<CategoryDTO> update(@PathVariable Long id, @RequestBody CategoryDTO dto) {
		dto = service.update(id, dto);
		
		return ResponseEntity.ok().body(dto);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> update(@PathVariable Long id) {
		service.delete(id);
		
		return ResponseEntity.noContent().build();// vai dar uma resposta 204 e o corpo está vazio
	}
	
	
	
	

}
