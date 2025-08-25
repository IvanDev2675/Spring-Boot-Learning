package com.Ivsoft.productoAPI.repository;

import com.Ivsoft.productoAPI.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {



}
