package com.Ivsoft.productoAPI.exception;

import java.time.LocalDateTime;

public class ErrorResponse {
private String codigo;
private String mensaje;
private LocalDateTime timestamp;



    public ErrorResponse(String codigo, String mensaje) {
        this.codigo = codigo;
        this.mensaje = mensaje;
        this.timestamp = LocalDateTime.now();
    }


        public String getCodigo() {
            return codigo;
        }

        public String getMensaje() {
            return mensaje;
        }

        public LocalDateTime getTimestamp() {
            return timestamp;
        }


    }

