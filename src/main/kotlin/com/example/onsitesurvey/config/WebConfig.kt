package com.example.onsitesurvey.config

import com.example.onsitesurvey.model.enums.Role
import org.springframework.context.annotation.Configuration
import org.springframework.core.convert.converter.Converter
import org.springframework.format.FormatterRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@Configuration
class WebConfig : WebMvcConfigurer {
    override fun addFormatters(registry: FormatterRegistry) {
        registry.addConverter(StringToRoleConverter())
    }
}

class StringToRoleConverter : Converter<String, Role> {
    override fun convert(source: String): Role? {
        return Role.fromValue(source)
    }
}
