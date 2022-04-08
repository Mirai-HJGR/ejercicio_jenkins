package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.documentos.Producto;
import com.example.demo.interfaces.IProductoService;

@RestController
@RequestMapping("/productos")
public class ProductoController {
	
	@Autowired
	IProductoService productoservice;
	
	@PostMapping("/add")
	public int add(@RequestBody Producto producto) {
		productoservice.add(producto);
		return 0;
	}
	
	@GetMapping("/find_by_id/{productoId}")
	public Producto find_by_id(@PathVariable("productoId") int productoId) {
		Producto productoaux=productoservice.busqueda_id(productoId);
		if(productoaux==null) {
			return new Producto();
		}else {
			return productoaux;
		}
	}
	
	@PutMapping("/update")
	public Integer update_producto(@RequestBody Producto producto) {
		Producto productoaux=productoservice.busqueda_id(producto.getId());
		if(productoaux==null) {
			return 1;
		}else {
			productoservice.modificar_producto(producto);
			return 0;
		}
	}
	
	@DeleteMapping("/delete_by_id/{productoId}")
	public Integer delete_producto_by_id(@PathVariable("productoId")int productoId) {
		Producto productoaux=productoservice.busqueda_id(productoId);
		if(productoaux==null) {
			return 1;
		}else {
			productoservice.eliminar_producto(productoId);
			return 0;
		}
	}
	
	@GetMapping("/list_all")
	public List<Producto> list_all() {
		return productoservice.list_all();
	}

}
