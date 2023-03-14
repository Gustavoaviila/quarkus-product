package org.acme.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.jackson.Jacksonized;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Jacksonized
public class ProductDTO {

  private Long id;
  private String name;

  private String description;

  private String category;

  private String model;

  private BigDecimal price;
}
