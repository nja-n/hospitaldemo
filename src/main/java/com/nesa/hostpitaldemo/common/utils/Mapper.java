package com.nesa.hostpitaldemo.common.utils;

public interface Mapper<D, E> {
    E toEntity(D domain);
    D toDomain(E entity);
}

