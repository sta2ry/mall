package org.featx.sta2ry.mall.config

import org.springframework.beans.BeanUtils
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.client.ClientHttpRequestFactory
import org.springframework.http.client.OkHttp3ClientHttpRequestFactory

@Configuration
open class WebConfiguration {
    @Bean
    open fun requestFactory(): ClientHttpRequestFactory {
        return BeanUtils.instantiateClass(
            OkHttp3ClientHttpRequestFactory::class.java
        )
    }
}