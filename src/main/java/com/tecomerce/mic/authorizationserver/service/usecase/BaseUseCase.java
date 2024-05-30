package com.tecomerce.mic.authorizationserver.service.usecase;

import java.util.List;

public interface BaseUseCase<T, K> {

    default T create(T entity) { return null; }

    default List<T> createAll(List<T> entities) { return List.of(); }

    default T update(T entity, K id){ return null; }

    default List<T> updateAll(List<T> entities){ return List.of(); }

    default T findById(K id) { return null; }

    default List<T> findByIds(List<K> id) { return List.of(); }

    default void delete(K id) {}

    default void delete(K id, boolean deleteChildren) {}

    default void deleteAll(List<K> ids) {}

    default List<T> findAllPaginated(int page, int size, String sort, String direction) { return List.of(); }

    default List<T> filters(String filterProperties, int page, int size, String direction, String... sortProperties){return  List.of(); }

}
