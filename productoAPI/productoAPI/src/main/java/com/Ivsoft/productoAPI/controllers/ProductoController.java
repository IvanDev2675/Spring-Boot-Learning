package com.Ivsoft.productoAPI.controllers;


import com.Ivsoft.productoAPI.entity.Producto;
import com.Ivsoft.productoAPI.service.IProducto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductoController {


    private IProducto iProducto;

    public ProductoController(IProducto iProducto) {
        this.iProducto = iProducto;
    }


    @PostMapping
    public Producto save( @RequestBody Producto p) {
        return iProducto.save(p);


    }

@GetMapping
    public List<Producto> findAll(){
         return iProducto.findAll();

    }
@GetMapping("/{id}")
public Producto findById(@PathVariable int id){
        return iProducto.findById(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> clearById(@PathVariable int id){

        iProducto.clearById(id);
        return ResponseEntity.noContent().build();

    }


    @PutMapping("/{id}")
    public Producto put(@PathVariable Integer id, @RequestBody Producto p) {
        p.setId(id); // Asegurar que el ID del path coincide con el del body
        return iProducto.put(p);
    }

    @PatchMapping("/{id}")
    public Producto patch(@PathVariable Integer id, @RequestBody Producto p) {
        p.setId(id); // Asegurar que el ID del path coincide
        return iProducto.patch(p);
    }

}
