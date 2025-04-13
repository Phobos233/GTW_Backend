package com.phobos.goldentrianglewebsitebackend.Config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "aliyun.oss")
public class AliOSSProp {
    private String endpoint;
    private String bucketName;
    private String region;
}
