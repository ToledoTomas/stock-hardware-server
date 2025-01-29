package com.stock_hardware.stock_hardware.repository;

import com.stock_hardware.stock_hardware.model.Categoria;
import com.stock_hardware.stock_hardware.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IProductoRepository extends JpaRepository<Producto, Integer> {
    List<Producto> findByCategoria(Categoria categoria);
}
