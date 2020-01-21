package com.company.project.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * 自定义实体类的某个属性必须验证为指定值（注意：参数为null时通过，只有参数有值时才验证）
 *
 * @author caliven
 * @since 2020-01-21
 */
@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER})
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = {EnumValueValidator.class})
public @interface EnumValue {
    
    /**
     * 默认错误消息
     *
     * @return
     */
    String message() default "必须为指定值";
    
    String[] strValues() default {};
    
    int[] intValues() default {};
    
    /**
     * 分组
     *
     * @return
     */
    Class<?>[] groups() default {};
    
    /**
     * 负载
     *
     * @return
     */
    Class<? extends Payload>[] payload() default {};
    
    /**
     * 指定多个时使用
     */
    @Target({FIELD, METHOD, PARAMETER, ANNOTATION_TYPE})
    @Retention(RUNTIME)
    @Documented
    @interface List {
        
        EnumValue[] value();
    }
}
