package com.shop.product.dao.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.shop.product.dao.ProductDAO;
import com.shop.product.domain.Product;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ProductDAOTest {

  // DAO yu test etmek için entitiymanager mock olmuş gibi oldu

  @Autowired
  private TestEntityManager testEntityManager;

  @Autowired
  private ProductDAO productDAO;

  @Before
  public void initTest() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  public void t1_should_store_a_product() {
    Product product = new Product();
    product.setName("test");
    testEntityManager.persist(product);

    Product resultProduct = productDAO.save(product);

    Assertions.assertThat(resultProduct).hasFieldOrPropertyWithValue("name", "test");

  }

  @Test
  public void t2_should_find_all_products() {
    List<Product> expectedList = new ArrayList<>();
    Product product = new Product();
    product.setName("test");
    Product result1 = testEntityManager.persist(product);
    expectedList.add(result1);

    Product product2 = new Product();
    product2.setName("test2");
    Product result2 = testEntityManager.persist(product2);
    expectedList.add(result2);

    Product product3 = new Product();
    product3.setName("test3");
    Product result3 = testEntityManager.persist(product3);
    expectedList.add(result3);

    Iterable<Product> resultProducts = productDAO.findAll();

    Assertions.assertThat(resultProducts).hasSize(3).contains(product, product2, product3);
  }

  @Test
  public void t3_should_findById_return_product() {
    Product product = new Product();
    product.setName("test");
    Long resultId = testEntityManager.persistAndGetId(product, Long.class);

    Optional<Product> resultProduct = productDAO.findById(resultId);

    if (resultProduct.isPresent()) {
      Assertions.assertThat(resultProduct.get().getName()).isEqualTo(product.getName());
    }
  }

}
