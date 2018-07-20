package com.hu.demo.exception;
import com.hu.demo.common.exception.DAOException;
import com.hu.demo.common.exception.ServiceException;
import com.hu.demo.domain.bo.Result;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * @author hulichao
 * @date 2018/7/20
 */
@ControllerAdvice
public class GlobalCustomRestExceptionHandler extends ResponseEntityExceptionHandler {
    //处理自定义异常
    @ExceptionHandler(CustomException.class)
    public ResponseEntity<Object> handleCustomerException(CustomException ex) {

        final Result customeError = Result.fail(ex.getCode(), ex.getLocalizedMessage());

        return new ResponseEntity<Object>(customeError, new HttpHeaders(), ex.getHttpStatus());

    }

    //处理自定义异常
    @ExceptionHandler(ServiceException.class)
    public ResponseEntity<Object> handleServiceException(ServiceException ex) {

        final Result customeError = Result.fail(ex.getCode(), ex.getLocalizedMessage());

        return new ResponseEntity<Object>(customeError, new HttpHeaders(), ex.getHttpStatus());

    }

    //处理自定义异常
    @ExceptionHandler(DAOException.class)
    public ResponseEntity<Object> handleDAOException(DAOException ex) {

        final Result customeError = Result.fail(ex.getCode(), ex.getLocalizedMessage());

        return new ResponseEntity<Object>(customeError, new HttpHeaders(), ex.getHttpStatus());

    }

    //处理通用异常，这里举例说明如何覆盖处理 请求方法不支持的异常
    @Override
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
                                                                         HttpHeaders headers, HttpStatus status, WebRequest request) {
        final Result customeError = Result.fail(status.value(), "HttpRequestMethodNotSupported");
        return new ResponseEntity<Object>(customeError, new HttpHeaders(), status);
    }
}
