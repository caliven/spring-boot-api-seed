package com.caliven.huai.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 实体公共字段类
 *
 * @author caliven
 * @since 2020-01-21
 */
@Data
@ApiModel
public class BaseEntity {
    
    @ApiModelProperty(value = "主键ID")
    private Integer id;
    
    @JsonIgnore
    @ApiModelProperty(hidden = true)
    @TableField(fill = FieldFill.INSERT)
    @TableLogic
    private Integer deleted;
    
    @JsonIgnore
    @ApiModelProperty(hidden = true)
    @TableField(fill = FieldFill.INSERT)
    private Integer createBy;
    
    @JsonIgnore
    @ApiModelProperty(hidden = true)
    @TableField(fill = FieldFill.UPDATE)
    private Integer updateBy;
    
    @JsonIgnore
    @ApiModelProperty(hidden = true)
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;
    
    @JsonIgnore
    @ApiModelProperty(hidden = true)
    @TableField(fill = FieldFill.UPDATE)
    private LocalDateTime updateTime;
}