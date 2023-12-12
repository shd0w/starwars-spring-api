package com.shd0w.study.StarWarsApi.utils;

import jakarta.annotation.Nullable;

import java.net.URI;

public class GetUri {
    public static URI getUri(@Nullable Integer page, @Nullable String searchQuery, URI endpointUri) {
        URI uri = endpointUri;
        if ((page != null) && (page > 0)) {
            uri = URI.create(endpointUri + "?page=" + page);
        }
        if (searchQuery != null) {
            uri = URI.create(uri + ((page != null) && (page > 0) ? "&" : "?") +"search=" + searchQuery);
        }
        return uri;
    }
}
