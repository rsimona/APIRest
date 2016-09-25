/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.koushik.javabrains.messenger.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import org.koushik.javabrains.messenger.model.ErrorMessage;

/**
 *
 * @author Ramon
 */
// @Provider Deshabilito el mapper
public class GenericExceptionMapper implements ExceptionMapper<Throwable>{

    @Override
    public Response toResponse(Throwable e) {
        
        ErrorMessage errorMessage = new ErrorMessage(e.getMessage(), 500, "http://google.cat");
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                .entity(errorMessage)
                .build();
    }

}