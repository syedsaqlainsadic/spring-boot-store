package com.firstspringproject.store.repositories;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

//import com.firstspringproject.store.dtos.ProductSummary;
//import com.firstspringproject.store.dtos.ProductSummaryDto;
import com.firstspringproject.store.entities.Category;
import com.firstspringproject.store.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>, JpaSpecificationExecutor<Product> {

    List<Product> findByName(String name);

    List<Product> findByNameLike(String name);

    List<Product> findByNameNotLike(String name);

    List<Product> findByNameContaining(String name);

    List<Product> findByNameStartingWith(String name);

    List<Product> findByNameEndingWith(String name);

    List<Product> findByNameEndingWithIgnoreCase(String name);

    List<Product> findByPrice(BigDecimal price);

    List<Product> findByPriceGreaterThan(BigDecimal price);

    List<Product> findByPriceGreaterThanEqual(BigDecimal price);

    List<Product> findByPriceLessThan(BigDecimal price);

    List<Product> findByPriceLessThanEqual(BigDecimal price);

    List<Product> findByPriceBetween(BigDecimal min, BigDecimal max);

    List<Product> findByDescriptionNull();

    List<Product> findByDescriptionNotNull();

    List<Product> findByDescriptionNullAndNameNull();

    List<Product> findByNameOrderByPrice(String name);

    List<Product> findFirst5ByNameOrderByPrice(String name);

    List<Product> findTop5ByNameOrderByPrice(String name);

    @EntityGraph(attributePaths = "category")
    @Query("SELECT p FROM Product p WHERE p.category.id = :cid")
    List<Product> findProductsByCategoryId(@Param("cid") byte cid);

    
    List<Product> findProductById(Long id);

    @Procedure("findProductsByPrice")
    List<Product> findProducts(BigDecimal min, BigDecimal max);

    @Query("SELECT COUNT(p) FROM Product p WHERE p.price BETWEEN :min AND :max")
    long countProducts(@Param("min") BigDecimal min, @Param("max") BigDecimal max);

    @Modifying
    @Query("UPDATE Product p SET p.price = :newPrice WHERE p.category.id = :categoryId")
    void updatePriceByCategoryId(@Param("categoryId") Byte categoryId, @Param("newPrice") BigDecimal newPrice);

    // @Query(value = "SELECT new
    // com.firstspringproject.store.dtos.ProductSummaryDto(p.id, p.name) FROM
    // Product p WHERE p.category = :category", nativeQuery = false)
    // List<ProductSummaryDto> findByCategory(@Param("category") Category category);
}
