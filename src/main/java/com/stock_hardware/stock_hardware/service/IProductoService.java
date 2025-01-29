package com.stock_hardware.stock_hardware.service;

import com.stock_hardware.stock_hardware.model.Categoria;
import com.stock_hardware.stock_hardware.model.Producto;

import java.util.List;

public interface IProductoService {
    Producto create(Producto producto);

    Producto update(Producto producto);

    Producto findById(Integer id);

    List<Producto> findAll();

    void delete(Integer id);

    List<Producto> filtrarPorCategoria(Categoria categoria);
}
