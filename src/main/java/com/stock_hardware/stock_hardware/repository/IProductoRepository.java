package com.stock_hardware.stock_hardware.repository;

import com.stock_hardware.stock_hardware.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductoRepository extends JpaRepository<Producto, Integer> {
}
