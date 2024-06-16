package br.edu.fema.infra.framework.domain;

import lombok.Data;

import java.util.List;

@Data
public final class ResponseCollectionDTO<T> {

    private final List<T> items;
    private final int size;
    private final boolean hasNext;

    private ResponseCollectionDTO(List<T> items) {
        this.items = items;
        this.size = items.size();
        this.hasNext = false;
    }

    public static <T> ResponseCollectionDTO<T> of(List<T> items) {
        return new ResponseCollectionDTO<>(items);
    }
}
