package com.example.demo.interfaces;

import java.util.ArrayList;

import com.example.demo.model.Categoria;

public interface ICategoriaService {
	
	public void alta_categoria(Categoria categoria);
	public Categoria busqueda_id_categoria(int idCategoria);
	public void modificar_categoria(Categoria categoria);
	public void eliminar_categoria_by_id(int idCategoria);
	public ArrayList<Categoria> listado_categorias();

}
