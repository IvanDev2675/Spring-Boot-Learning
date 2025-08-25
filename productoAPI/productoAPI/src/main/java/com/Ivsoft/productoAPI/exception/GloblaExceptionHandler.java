package com.Ivsoft.productoAPI.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;


@ControllerAdvice
public class GloblaExceptionHandler {

    // Maneja excepciones cuando un producto no se encuentra
    @ExceptionHandler(ProductoNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleProductoNotFoundException(ProductoNotFoundException ex, WebRequest request) {
        ErrorResponse errorResponse = new ErrorResponse(
                "PRODUCTO_NO_ENCONTRADO",
                ex.getMessage()
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

@ExceptionHandler(ProductInvalidRequest.class)

    public ResponseEntity<ErrorResponse> handleProductInvalidRequest(ProductInvalidRequest req, WebRequest request) {
        ErrorResponse errorResponse = new ErrorResponse(
                "PETICION_INVALIDA", req.getMessage()
        );

        return new ResponseEntity<>((errorResponse), HttpStatus.BAD_REQUEST);
}


}
