package com.example.demo.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.interfaces.ICategoriaService;
import com.example.demo.model.Categoria;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {
	
	@Autowired
	ICategoriaService categoriaservice;
		
	@GetMapping("/list_all")
	public ArrayList<Categoria> get_libros(){
		System.out.println("entra");
		return categoriaservice.listado_categorias();
	}

	@PostMapping("/add")
	public Integer add_categoria(@RequestBody Categoria categoria) {
		Categoria categoriaaux=categoriaservice.busqueda_id_categoria(categoria.getId_categoria());
		if(categoriaaux==null) {
			categoriaservice.alta_categoria(categoria);
			return 0;
		}else {
			return 1;
		}
	}
	
	@GetMapping("/find_by_id/{idCategoria}")
	public Categoria get_categoria_by_id(@PathVariable("idCategoria") int idCategoria){
		Categoria categoriaaux=categoriaservice.busqueda_id_categoria(idCategoria);
		if(categoriaaux==null) {
			return new Categoria();
		}else {
			return categoriaaux;
		}
	}
	
	@DeleteMapping("/delete_by_id/{idCategoria}")
	public Integer delete_categoria_by_id(@PathVariable("idCategoria")int idCategoria) {
		Categoria categoriaaux=categoriaservice.busqueda_id_categoria(idCategoria);
		if(categoriaaux==null) {
			return 1;
		}else {
			categoriaservice.eliminar_categoria_by_id(idCategoria);
			return 0;
		}
	}
	
	@PutMapping("/update")
	public Integer update_categoria(@RequestBody Categoria categoria) {
		Categoria categoriaaux=categoriaservice.busqueda_id_categoria(categoria.getId_categoria());
		if(categoriaaux==null) {
			return 1;
		}else {
			categoriaservice.modificar_categoria(categoria);
			return 0;
		}
	}

}
