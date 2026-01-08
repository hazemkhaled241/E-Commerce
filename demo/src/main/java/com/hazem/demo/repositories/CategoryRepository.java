package com.hazem.demo.repositories;

import com.hazem.demo.entities.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Byte> {
}
