package com.Ivsoft.productoAPI.service;


import com.Ivsoft.productoAPI.entity.Producto;

import java.util.List;

public interface IProducto {

Producto save (Producto p);

List<Producto> findAll();

Producto findById(Integer id);

void clearById(Integer id);

Producto put(Producto p);

Producto patch(Producto p);

}
