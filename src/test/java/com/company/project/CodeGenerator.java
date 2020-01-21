package com.company.project;

import com.baomidou.mybatisplus.core.enums.SqlLike;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.LikeTable;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.company.project.entity.BaseEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * MyBatis-Plus 代码生成类
 * <p>
 * AutoGenerator 是 MyBatis-Plus 的代码生成器，通过 AutoGenerator 可以快速生成
 * Entity、Mapper、Mapper XML、Service、Controller 等各个模块的代码，极大的提升了开发效率。
 * 参考文档：https://mp.baomidou.com/guide/generator.html
 * <p>
 *
 * @author caliven
 * @since 2020-01-21
 */
public class CodeGenerator {
    
    /**
     * 项目路径
     */
    public static final String PROJECT_PATH = "/Users/caliven/IdeaProjects/money/spring-boot-api-seed";
    /**
     * 类注释作者名称
     */
    public static final String AUTHOR = "caliven";
    /**
     * 父Package包名
     */
    public static final String PARENT_PACKAGE = "com.company.project";
    /**
     * MySQL 信息
     */
    public static final String MYSQL_URL = "jdbc:mysql://localhost:3306/dcb?useUnicode=true&useSSL=false&characterEncoding=utf8";
    public static final String MYSQL_USERNAME = "root";
    public static final String MYSQL_PASSWORD = "12345678";
    /**
     * 实体类父类中的公共字段（数据库字段）
     */
    public static final String[] SUPER_ENTITY_COLUMNS = {"id", "deleted", "create_by", "create_time", "update_by", "update_time"};
    /**
     * 生成代码的表名（不设置，默认为所有表）
     */
    public static final String[] TABLE_NAME = {};
    
    public static void main(String[] args) {
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();
        
        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        // 代码输出目录
        gc.setOutputDir(PROJECT_PATH + "/src/main/java");
        // 开发人员
        gc.setAuthor(AUTHOR);
        // 是否覆盖原有文件
        gc.setFileOverride(true);
        // xml文件中生成 ResultMap
        gc.setBaseResultMap(true);
        // xml文件中生成 columnList
        gc.setBaseColumnList(false);
        // 实体属性添加 Swagger2 注解
        gc.setSwagger2(true);
        // 是否打开输出文件目录
        gc.setOpen(false);
        mpg.setGlobalConfig(gc);
        
        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl(MYSQL_URL);
        dsc.setUsername(MYSQL_USERNAME);
        dsc.setPassword(MYSQL_PASSWORD);
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        mpg.setDataSource(dsc);
        
        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setParent(PARENT_PACKAGE);
        pc.setEntity("entity");
        pc.setMapper("mapper");
        pc.setService("service");
        pc.setServiceImpl("service.impl");
        pc.setController("controller");
        pc.setXml("mapper");
        mpg.setPackageInfo(pc);
        
        // 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
            }
        };
        
        // mapper xml文件生成模板引擎，默认模板文件在 mybatis-plus-generator-x.x.x.jar 中（默认模板引擎是 velocity）
        String mapperTemplatePath = "/templates/mapper.xml.vm";
        // 自定义输出配置
        List<FileOutConfig> focList = new ArrayList<>();
        // 自定义配置会被优先输出
        focList.add(new FileOutConfig(mapperTemplatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出 mapper xml 文件名，如果Entity设置了前后缀，此处注意 xml 的名称会跟着发生变化
                return PROJECT_PATH + "/src/main/resources/mapper/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });
        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);
        
        // 配置模板
        TemplateConfig templateConfig = new TemplateConfig();
        // 配置自定义输出模板
        // 指定自定义模板路径，注意不要带上.ftl/.vm, 会根据使用的模板引擎自动识别
        // templateConfig.setEntity("templates/entity2.java");
        // templateConfig.setService();
        // templateConfig.setXml(null);
        // controller 代码自定义增强模板，如果不用增强可以注释
        templateConfig.setController("generator/templates/controller.java");
        mpg.setTemplate(templateConfig);
        
        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        // 实体是否为lombok模型（默认 false）
        strategy.setEntityLombokModel(true);
        // 生成 @RestController
        strategy.setRestControllerStyle(true);
        // Controller公共父类
        // strategy.setSuperControllerClass("你自己的父类控制器,没有就不用设置!");
        // 实体类父类
        strategy.setSuperEntityClass(BaseEntity.class);
        // 写于父类中的公共字段
        strategy.setSuperEntityColumns(SUPER_ENTITY_COLUMNS);
        // 要生成代码的表名（不设置，默认为所有表）
        if (TABLE_NAME != null && TABLE_NAME.length > 0) {
            strategy.setInclude(TABLE_NAME);
        }
        // 不生成代码的表名（qrtz定时任务表）
        strategy.setNotLikeTable(new LikeTable("qrtz_", SqlLike.RIGHT));
        strategy.setControllerMappingHyphenStyle(true);
        strategy.setTablePrefix("_");
        mpg.setStrategy(strategy);
        mpg.execute();
    }
}