package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.documentos.Producto;
import com.example.demo.interfaces.IProductoService;
import com.example.demo.repository.ProductoRepository;

@Service
public class ProductoService implements IProductoService {
	
	@Autowired
	ProductoRepository productoRepository;

	@Override
	public void add(Producto producto) {
		productoRepository.save(producto);
	}

	@Override
	public Producto busqueda_id(int productoId) {
		return productoRepository.findById(productoId).orElse(null);
	}

	@Override
	public void modificar_producto(Producto producto) {
		productoRepository.save(producto);
	}

	@Override
	public void eliminar_producto(int productoId) {
		productoRepository.deleteById(productoId);
	}

	@Override
	public List<Producto> list_all() {
		return productoRepository.findAll();
	}

}
