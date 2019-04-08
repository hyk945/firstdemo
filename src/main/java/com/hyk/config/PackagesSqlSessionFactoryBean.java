package com.hyk.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.core.type.classreading.CachingMetadataReaderFactory;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.util.ClassUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Description: mybatis 实体类包扫描
 * Author: ykhuang
 * Version: 1.0
 * Create Date Time: 2019/4/4 9:32.
 * Update Date Time: 2019/4/4 9:32.
 */
@Slf4j
public class PackagesSqlSessionFactoryBean extends SqlSessionFactoryBean {

    private static final String DEFAULT_RESOURCE_PATTERN = "**/*.class";

    @Override
    public void setTypeAliasesPackage(String typeAliasesPackage) {
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        MetadataReaderFactory metadataReaderFactory = new CachingMetadataReaderFactory(resolver);
        String[] typeHandlersPackageArray;
        String[] var4;
        int var5;
        int var6;
        String packageToScan;
        if (org.springframework.util.StringUtils.hasLength(typeAliasesPackage)) {
            typeHandlersPackageArray = org.springframework.util.StringUtils.tokenizeToStringArray(typeAliasesPackage, ",; \t\n");
            var4 = typeHandlersPackageArray;
            var5 = typeHandlersPackageArray.length;
            List<String> result = new ArrayList<>();
            for (var6 = 0; var6 < var5; ++var6) {
                packageToScan = var4[var6];

                typeAliasesPackage = ResourcePatternResolver.CLASSPATH_ALL_URL_PREFIX +
                        ClassUtils.convertClassNameToResourcePath(packageToScan) + "/" + DEFAULT_RESOURCE_PATTERN;

                //将加载多个绝对匹配的所有Resource
                //将首先通过ClassLoader.getResource("META-INF")加载非模式路径部分
                //然后进行遍历模式匹配
                try {
                    Resource[] resources = resolver.getResources(typeAliasesPackage);
                    if (resources.length > 0) {
                        MetadataReader metadataReader;
                        for (Resource resource : resources) {
                            if (resource.isReadable()) {
                                metadataReader = metadataReaderFactory.getMetadataReader(resource);
                                try {
                                    result.add(Class.forName(metadataReader.getClassMetadata().getClassName()).getPackage().getName());
                                } catch (ClassNotFoundException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    }
                } catch (IOException e) {
                    log.error("PackagesSqlSessionFactoryBean resolver.getResources IOException", e);
                }
            }
            if (result.size() > 0) {
                super.setTypeAliasesPackage(StringUtils.join(result.toArray(), ","));
            } else {
                log.warn("参数typeAliasesPackage:" + typeAliasesPackage + "，未找到任何包");
            }
        }
    }

}
