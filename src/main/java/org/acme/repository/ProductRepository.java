package org.acme.repository;

import javax.enterprise.context.ApplicationScoped;

import org.acme.entity.ProductEntity;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class ProductRepository implements PanacheRepository<ProductEntity> {
}
