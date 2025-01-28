package com.stock_hardware.stock_hardware.controller;

import com.stock_hardware.stock_hardware.exception.ModelNotFoundException;
import com.stock_hardware.stock_hardware.model.Producto;
import com.stock_hardware.stock_hardware.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @GetMapping
    public ResponseEntity<List<Producto>> findAll(){
        return new ResponseEntity<>(productoService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Producto> create(@RequestBody Producto producto){
        return new ResponseEntity<>(productoService.create(producto), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Object> update(@RequestBody Producto producto){
        productoService.update(producto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Producto> findById(@PathVariable("id") Integer idProducto){
        Producto producto = productoService.findById(idProducto);
        if(producto == null){
            throw new ModelNotFoundException("Producto no encontrado");
        }
        return new ResponseEntity<>(producto, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable("id") Integer idProducto){
        Producto producto = productoService.findById(idProducto);
        if(producto == null){
            throw new ModelNotFoundException("Producto no encontrado");
        }
        productoService.delete(idProducto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
