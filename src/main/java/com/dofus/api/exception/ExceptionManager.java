package com.dofus.api.exception;

import com.dofus.api.controller.SuccessController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.time.ZoneId;

@ControllerAdvice
public class ExceptionManager {

    Logger log = LoggerFactory.getLogger(ExceptionManager.class);


    @ExceptionHandler(HttpClientErrorException.class)
    public ResponseEntity<Error> httpClientErrorException(HttpClientErrorException httpClientErrorException, WebRequest request){
        log.info("[HttpClientErrorException]", httpClientErrorException);
        return new ResponseEntity<Error>(generateError(httpClientErrorException.getRawStatusCode() + "",request,ExceptionConstantes.codeMessage.get(httpClientErrorException.getRawStatusCode() + "")),httpClientErrorException.getStatusCode());
    }

    @ExceptionHandler(RestClientException.class)
    public ResponseEntity<Error> restClientException(final RestClientException restClientException,WebRequest request) {
        log.error("[RestClientException]",restClientException);
        return new ResponseEntity<Error>(internalError(ExceptionConstantes.INTERNAL_EXCEPTION_CODE,request), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<Error> notFoundException(final NullPointerException exception,WebRequest request) {
        log.error("[NullPointerException]",exception);
        return new ResponseEntity<Error>(notFoundError(ExceptionConstantes.NOT_FOUND_EXCEPTION_CODE,request),HttpStatus.NOT_FOUND);
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

    private Error notFoundError(String codeError,WebRequest request){
        return generateError(codeError,request,ExceptionConstantes.NOT_FOUND_ERREUR_MESSAGE);
    }
}
