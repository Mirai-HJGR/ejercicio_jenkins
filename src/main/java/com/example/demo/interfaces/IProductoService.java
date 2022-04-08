package com.example.demo.interfaces;

import java.util.List;

import com.example.demo.documentos.Producto;

public interface IProductoService {
	
	public void add(Producto producto);
	public Producto busqueda_id(int productoId);
	public void modificar_producto(Producto producto);
	public void eliminar_producto(int productoId);
	public List<Producto> list_all();

}
