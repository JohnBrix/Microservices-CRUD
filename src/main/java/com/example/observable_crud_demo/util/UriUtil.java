package com.example.observable_crud_demo.util;

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

public class UriUtil {

    public static URI path() {
        return ServletUriComponentsBuilder.fromCurrentRequestUri()
                .buildAndExpand()
                .toUri();
    }
    //path mo
    public static URI path(Object... uriVariableValues) {
        return ServletUriComponentsBuilder.fromCurrentRequestUri()
                .buildAndExpand(uriVariableValues)
                .toUri();
    }
    //uri
    public static URI uri(String path, Object... uriVariableValues) {
        return ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path(path)
                .buildAndExpand(uriVariableValues)
                .toUri();
    }
}
