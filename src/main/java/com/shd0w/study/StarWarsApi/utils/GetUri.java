package com.shd0w.study.StarWarsApi.utils;

import jakarta.annotation.Nullable;
import lombok.extern.slf4j.Slf4j;

import java.net.URI;

@Slf4j
public class GetUri {
    public static URI getUri(@Nullable Integer page, @Nullable String searchQuery, URI endpointUri, @Nullable Integer id) {
        URI uri = endpointUri;
        if ((page != null) && (page > 0)) {
            uri = URI.create(endpointUri + "?page=" + page);
        }
        if (searchQuery != null) {
            uri = URI.create(uri + ((page != null) && (page > 0) ? "&" : "?") + "search=" + searchQuery);
        }
        uri = id != null ? URI.create(uri + "/" + id) : uri;

        log.info("Endpoint URI final: " + uri);

        return uri;
    }
}
