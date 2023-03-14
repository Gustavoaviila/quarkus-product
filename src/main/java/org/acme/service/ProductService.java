package org.acme.service;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

import org.acme.dto.ProductDTO;
import org.acme.entity.ProductEntity;
import org.acme.repository.ProductRepository;

@ApplicationScoped
public class ProductService {

  @Inject
  private ProductRepository repository;

  public List<ProductDTO> findAll(){
    List<ProductDTO> products = new ArrayList<>();

    repository.findAll().stream().forEach(item -> {
      products.add(mapProductEntityToDTO(item));
    });

    return products;
  }

  public ProductDTO getProductById(Long id){
    return mapProductEntityToDTO(repository.findById(id));
  }

  public void create(ProductDTO dto){
    repository.persist(mapProductDTOToEntity(dto));
  }

  public void update(Long id, ProductDTO dto){
    ProductEntity productEntity = repository.findById(id);

    productEntity.setName(dto.getName());
    productEntity.setCategory(dto.getCategory());
    productEntity.setDescription(dto.getDescription());
    productEntity.setModel(dto.getModel());
    productEntity.setPrice(dto.getPrice());

    repository.persist(productEntity);
  }

  public void delete(Long id){
    repository.deleteById(id);
  }

  private ProductDTO mapProductEntityToDTO(ProductEntity entity){

    ProductDTO dto = new ProductDTO();
    dto.setCategory(entity.getCategory());
    dto.setDescription(entity.getDescription());
    dto.setModel(entity.getModel());
    dto.setName(entity.getName());
    dto.setPrice(entity.getPrice());
    return dto;
  }

  private ProductEntity mapProductDTOToEntity(ProductDTO dto){

    ProductEntity entity = new ProductEntity();
    entity.setCategory(dto.getCategory());
    entity.setDescription(dto.getDescription());
    entity.setModel(dto.getModel());
    entity.setName(dto.getName());
    entity.setPrice(dto.getPrice());
    return entity;
  }
}
