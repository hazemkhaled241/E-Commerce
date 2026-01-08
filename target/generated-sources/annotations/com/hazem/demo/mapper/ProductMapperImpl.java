package com.hazem.demo.mapper;

import com.hazem.demo.dtos.ProductDto;
import com.hazem.demo.entities.Category;
import com.hazem.demo.entities.Product;
import java.math.BigDecimal;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-01-07T23:34:51+0200",
    comments = "version: 1.6.3, compiler: javac, environment: Java 25.0.1 (Oracle Corporation)"
)
@Component
public class ProductMapperImpl implements ProductMapper {

    @Override
    public ProductDto toDto(Product product) {
        if ( product == null ) {
            return null;
        }

        Byte categoryId = null;
        Long id = null;
        String name = null;
        String description = null;
        BigDecimal price = null;

        categoryId = productCategoryId( product );
        id = product.getId();
        name = product.getName();
        description = product.getDescription();
        price = product.getPrice();

        ProductDto productDto = new ProductDto( id, name, description, price, categoryId );

        return productDto;
    }

    private Byte productCategoryId(Product product) {
        Category category = product.getCategory();
        if ( category == null ) {
            return null;
        }
        return category.getId();
    }
}
