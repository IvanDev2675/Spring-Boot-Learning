package com.Ivsoft.productoAPI.service;

import com.Ivsoft.productoAPI.entity.Producto;
import com.Ivsoft.productoAPI.exception.ProductInvalidRequest;
import com.Ivsoft.productoAPI.exception.ProductoNotFoundException;
import com.Ivsoft.productoAPI.repository.ProductoRepository;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ProductoServiceImpl  implements IProducto{


    private ProductoRepository productoRepository;

    public ProductoServiceImpl(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    @Override
    public Producto save(Producto p) {
        return productoRepository.save(p);
    }

    @Override
    public List<Producto> findAll() {
        return productoRepository.findAll();
    }


    @Override
    public Producto findById(Integer id) {

        if(id==null){
            throw new ProductInvalidRequest("El campo no puede estar vacio");
        }

        if(id<0){
            throw new ProductInvalidRequest("EL valor ingresado no puede ser negativo");
        }

        return productoRepository.findById(id)
                .orElseThrow(()-> new ProductoNotFoundException("Prodcuto con ID "+ id + " no encontrado"));

    }

    @Override
    public void clearById(Integer id) {

        if(id<0){
            throw new ProductInvalidRequest("El valor ingreado no puede  ser negativo");
        }

      if (!productoRepository.existsById(id)) {
          throw new ProductoNotFoundException("Prodcuto con ID "+ id + " no existe");

      }
     productoRepository.deleteById(id);
    }



    @Override
    public Producto put(Producto p) {

        if(p.getId()==null){
            throw new ProductInvalidRequest("El campo no puede estar vacio");

        }

        if(p.getId()<0){
            throw new ProductInvalidRequest("El ID ingresado no puede ser negativo");
        }


        //VALIDARE LOS CAMPOS OBLIGATORIOS

        if(p.getNombre()==null || p.getNombre().trim().isEmpty()){
            throw new ProductInvalidRequest("EL campo nombre no puede estar vacio");
        }

        if(p.getPrecio()==null){
            throw new ProductInvalidRequest("El precio no puede estar vacio");
        }

        if (p.getPrecio().compareTo(BigDecimal.ZERO) <= 0) {
            throw new ProductInvalidRequest("El precio debe ser mayor a cero");
        }

        if(p.getDetalle()==null || p.getDetalle().trim().isEmpty()){
            throw new ProductInvalidRequest("El campo detalle no puede estar vacio");
        }

        Producto productbbd = productoRepository.findById(p.getId())
                .orElseThrow(()-> new ProductoNotFoundException("Producto con ID "+ p.getId()
                        + " no encontrado"));


        productbbd.setNombre(p.getNombre());
        productbbd.setPrecio(p.getPrecio());
        return productoRepository.save(productbbd);
    }

    @Override
    public Producto patch(Producto p) {
         if(p.getId()==null){
             throw new ProductInvalidRequest("El campo no puede estar vacio");
         }
          if(p.getId()<0){
              throw new ProductInvalidRequest("El ID ingresado no puede ser negativo");
          }

        Producto productobbd = productoRepository.findById(p.getId())
                .orElseThrow(()-> new ProductoNotFoundException("Producto con ID "+ p.getId()+ " no encontrado"));

        if(p.getNombre() !=null && !p.getNombre().trim().isEmpty()){
            productobbd.setNombre(p.getNombre());

        }

        if(p.getPrecio() != null && p.getPrecio().compareTo(BigDecimal.ZERO)>0){
            productobbd.setPrecio(p.getPrecio());
        }



        if(p.getDetalle()!=null && !p.getDetalle().trim().isEmpty()){
            productobbd.setDetalle(p.getDetalle());
        }

        return productoRepository.save(productobbd);

    }


}
