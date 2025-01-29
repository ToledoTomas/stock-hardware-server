package com.stock_hardware.stock_hardware.service;

import com.stock_hardware.stock_hardware.model.Categoria;
import com.stock_hardware.stock_hardware.model.Producto;
import com.stock_hardware.stock_hardware.repository.IProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService implements IProductoService {

    @Autowired
    private IProductoRepository productoRepo;

    @Override
    public Producto create(Producto producto) {
        return productoRepo.save(producto);
    }

    @Override
    public Producto update(Producto producto) {
        if (!productoRepo.existsById(producto.getIdProducto())) {
            throw new RuntimeException("Producto no encontrado con ID: " + producto.getIdProducto());
        }
        return productoRepo.save(producto);
    }

    @Override
    public Producto findById(Integer id) {
        Optional<Producto> productoOptional = productoRepo.findById(id);
        return productoOptional.orElse(null);
    }

    @Override
    public List<Producto> findAll() {
        return productoRepo.findAll();
    }

    @Override
    public void delete(Integer id) {
        productoRepo.deleteById(id);
    }

    @Override
    public List<Producto> filtrarPorCategoria(Categoria categoria) {
        return productoRepo.findByCategoria(categoria);
    }
}
