package com.china.config;

import com.china.anno.TimeInterval;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import java.util.Date;

public class TimeValidator implements ConstraintValidator<TimeInterval,Object> {

    private String startTime;

    private String endTime;

    @Override
    public void initialize(TimeInterval constraintAnnotation) {
        startTime = constraintAnnotation.startTime();
        endTime = constraintAnnotation.endTime();
    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        //获取需要比较的时间值
        BeanWrapper beanWrapper = new BeanWrapperImpl(o);
        Object start = beanWrapper.getPropertyValue(startTime);
        Object end = beanWrapper.getPropertyValue(endTime);
        if(null == start || null == end){
            return true;
        }

        //进行比较
        int result = ((String) end).compareTo((String) start);
        if(result >= 0){
            return true;
        }

        return false;
    }
}
