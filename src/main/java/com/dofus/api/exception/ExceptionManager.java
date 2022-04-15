package com.dofus.api.exception;

import com.dofus.api.controller.SuccessController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.time.ZoneId;

@ControllerAdvice
public class ExceptionManager {

    Logger log = LoggerFactory.getLogger(ExceptionManager.class);


    @ExceptionHandler
    public ResponseEntity<Error> httpClientErrorException(HttpClientErrorException httpClientErrorException, WebRequest request){
        log.info("[HttpClientErrorException]", httpClientErrorException);
        return new ResponseEntity<Error>(generateError(httpClientErrorException.getRawStatusCode() + "",request,ExceptionConstantes.codeMessage.get(httpClientErrorException.getRawStatusCode() + "")),httpClientErrorException.getStatusCode());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Error> httpClientErrorException(Exception exception, WebRequest request){
        log.info("[Exception]", exception);
        return new ResponseEntity<Error>(internalError(ExceptionConstantes.INTERNAL_EXCEPTION_CODE,request), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private Error generateError(String codeError, WebRequest request,String message){
        Error error = new Error();
        error.setMsg(message);
        error.setTimestamp(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant().toString());
        error.setCode(codeError);
        return error;
    }

    private Error internalError(String codeError,WebRequest request){
        return generateError(codeError,request,ExceptionConstantes.INTERNAL_ERREUR_MESSAGE);
    }
}
