package org.terasoluna.gfw.functionaltest.app.exceptionhandling;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.terasoluna.gfw.web.exception.ExceptionLoggingFilter;

public class ExceptionCodeExceptionLoggingFilter extends
                                                 ExceptionLoggingFilter {

    @Override
    protected void logIOException(IOException ex, ServletRequest request,
            ServletResponse response) {
        getExceptionLogger().log(ex);
    }

    @Override
    protected void logServletException(ServletException ex,
            ServletRequest request, ServletResponse response) {
        getExceptionLogger().log(ex);
    }

    @Override
    protected void logRuntimeException(RuntimeException ex,
            ServletRequest request, ServletResponse response) {
        getExceptionLogger().log(ex);
    }

}
