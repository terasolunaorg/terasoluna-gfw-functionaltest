package org.terasoluna.gfw.functionaltest.app.exceptionhandling;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.terasoluna.gfw.web.exception.ExceptionLoggingFilter;

public class VariationExceptionLoggingFilter extends ExceptionLoggingFilter {

    /**
     * Logs IOException.
     * @param ex Exception
     * @param request HTTP servlet request
     * @param response HTTP servlet response
     */
    @Override
    protected void logIOException(IOException ex, ServletRequest request,
            ServletResponse response) {
        getExceptionLogger().log(ex);
    }

    /**
     * Logs ServletException
     * @param ex Exception
     * @param request HTTP servlet request
     * @param response HTTP servlet response
     */
    @Override
    protected void logServletException(ServletException ex,
            ServletRequest request, ServletResponse response) {
        getExceptionLogger().log(ex);
    }

    /**
     * Logs RuntimeException
     * @param ex Exception
     * @param request HTTP servlet request
     * @param response HTTP servlet response
     */
    @Override
    protected void logRuntimeException(RuntimeException ex,
            ServletRequest request, ServletResponse response) {
        getExceptionLogger().log(ex);
    }

}
