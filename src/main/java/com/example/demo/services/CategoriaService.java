package com.example.demo.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.interfaces.ICategoriaService;
import com.example.demo.model.Categoria;
import com.example.demo.repository.CategoriaRepository;

@Service
public class CategoriaService implements ICategoriaService {
	
	@Autowired
	CategoriaRepository categoriaRepository;

	@Override
	public void alta_categoria(Categoria categoria) {
		categoriaRepository.save(categoria);
	}

	@Override
	public Categoria busqueda_id_categoria(int idCategoria) {
		return categoriaRepository.findById(idCategoria).orElse(null);
	}

	@Override
	public void modificar_categoria(Categoria categoria) {
		categoriaRepository.save(categoria);
	}

	@Override
	public void eliminar_categoria_by_id(int idCategoria) {
		categoriaRepository.deleteById(idCategoria);
	}

	@Override
	public ArrayList<Categoria> listado_categorias() {
		return (ArrayList<Categoria>)categoriaRepository.findAll();
	}

}
