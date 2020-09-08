package com.albusxing.reader.common.exception;
import com.albusxing.reader.common.base.BaseResult;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 请求参数异常处理
 * @author liguoqing
 */
@Order(Ordered.HIGHEST_PRECEDENCE)
@RestControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public BaseResult<?> methodArgumentNotValidException(MethodArgumentNotValidException validException) {
        BindingResult result = validException.getBindingResult();
        List<FieldError> fieldErrors = result.getFieldErrors();
        if (!CollectionUtils.isEmpty(fieldErrors)) {
            Set<String> errorSet = fieldErrors.stream().map(ObjectError::getDefaultMessage).collect(Collectors.toSet());
            return BaseResult.fail(errorSet.toString());
        }
        return BaseResult.success();
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public BaseResult<?> constraintViolationException(ConstraintViolationException violationException) {
        Set<ConstraintViolation<?>> constraintViolations = violationException.getConstraintViolations();
        if (!CollectionUtils.isEmpty(constraintViolations)) {
            Set<String> errorSet = constraintViolations.stream().map(ConstraintViolation::getMessage).collect(Collectors.toSet());
            return BaseResult.fail(errorSet.toString());
        }
        return BaseResult.fail();
    }

}
