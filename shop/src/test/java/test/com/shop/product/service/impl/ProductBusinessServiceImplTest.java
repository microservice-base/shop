package test.com.shop.product.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.shop.ShopApplication;
import com.shop.product.dao.ProductDAO;
import com.shop.product.domain.Product;
import com.shop.product.service.impl.ProductBusinessServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductBusinessServiceImplTest {

  // Servisi test etmek için dao mock oldu

  @Autowired
  private ProductBusinessServiceImpl productBusinessService;

  @MockBean // nedeen mockbean bilmiyorum değişince çalışmıyor.
  private ProductDAO productDAO;

  @Before
  public void initTest() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  public void t0_contextLoads() {
    ShopApplication.main(new String[] { "--spring.main.web-environment=false",
        "--spring.autoconfigure.exclude=false" });
  }

  @Test
  public void t0_get_all_product() {
    Product product = new Product();
    product.setName("test");
    product.setCode("001");

    Product product2 = new Product();
    product2.setName("test2");
    product2.setCode("002");

    List<Product> list = new ArrayList<Product>();
    list.add(product);
    list.add(product2);

    Mockito.when(productDAO.findAll()).thenReturn(list);

    List<Product> resultProductList = productBusinessService.findAll();

    Mockito.verify(productDAO, Mockito.times(1)).findAll();
    Mockito.verifyNoMoreInteractions(productDAO);

    Assert.assertEquals(resultProductList, list);
  }

  @Test
  public void t1_save_product() {
    Product product = new Product();
    product.setName("test");

    Mockito.when(productDAO.save(product)).thenReturn(product);

    Product resultProduct = productBusinessService.save(product);

    Mockito.verify(productDAO, Mockito.times(1)).save(product);
    Mockito.verifyNoMoreInteractions(productDAO);

    Assert.assertEquals(resultProduct.getName(), product.getName());
  }

  @Test
  public void t2_find_by_code_product() {
    Product product = new Product();
    product.setName("test");
    product.setCode("001");

    Mockito.when(productDAO.findByCode(Mockito.anyString())).thenReturn(product);

    Product resultProduct = productBusinessService.findByCode(product.getCode());

    Mockito.verify(productDAO, Mockito.times(1)).findByCode(product.getCode());
    Mockito.verifyNoMoreInteractions(productDAO);

    Assert.assertEquals(resultProduct.getName(), product.getName());
  }

  @Test
  public void t3_find_by_id_product() {
    Product product = new Product();
    product.setId(1L);
    product.setName("test");
    product.setCode("001");

    Mockito.when(productDAO.findById(Mockito.anyLong())).thenReturn(Optional.of(product));

    Product resultProduct = productBusinessService.findById(product.getId());

    Mockito.verify(productDAO, Mockito.times(1)).findById(product.getId());
    Mockito.verifyNoMoreInteractions(productDAO);

    Assert.assertEquals(resultProduct.getCode(), product.getCode());
  }
}
