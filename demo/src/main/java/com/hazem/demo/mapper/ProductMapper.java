package com.hazem.demo.mapper;

import com.hazem.demo.dtos.ProductDto;
import com.hazem.demo.entities.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductMapper {
   @Mapping(target = "categoryId" ,source ="category.id")
   ProductDto toDto(Product product);
}
