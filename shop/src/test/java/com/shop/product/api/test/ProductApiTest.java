package com.shop.product.api.test;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.shop.product.api.ProductApi;
import com.shop.product.domain.Product;
import com.shop.product.service.impl.ProductBusinessServiceImpl;

@WebMvcTest(value = ProductApi.class)
@RunWith(SpringRunner.class)
public class ProductApiTest {

  /// controler katmanını test etmek için servis katmanın mock yaptık
  // servis içinde dao var ama onun ne döndüğü bizim için önemli değil
  // biz sadece test etmek istediğimiz katmana odaklanıyoruz.

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private ProductBusinessServiceImpl productBusinessService;

  @Test
  public void t1_product_save() throws Exception {
    Product product = new Product();
    product.setName("test");
    product.setCode("001");

    String inputInJson = this.mapToJson(product);

    String URI = "/productapi/save";

    Mockito.when(productBusinessService.save(Mockito.any(Product.class))).thenReturn(product);

    RequestBuilder requestBuilder = MockMvcRequestBuilders.post(URI).content(inputInJson)
        .accept(MediaType.APPLICATION_JSON_UTF8_VALUE)
        .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE);

    MvcResult result = mockMvc.perform(requestBuilder).andReturn();
    MockHttpServletResponse response = result.getResponse();

    String outputInJson = response.getContentAsString();

    Assertions.assertThat(inputInJson).isEqualTo(outputInJson);
    Assertions.assertThat(HttpStatus.OK.value()).isEqualTo(response.getStatus());

  }

  @Test
  public void t2_product_findByCode() throws Exception {
    Product product = new Product();
    product.setName("test");
    product.setCode("001");

    String inputInJson = this.mapToJson(product);

    String URI = "/productapi/findByCode";

    Mockito.when(productBusinessService.findByCode(Mockito.anyString())).thenReturn(product);

    RequestBuilder requestBuilder = MockMvcRequestBuilders.post(URI).content(inputInJson)
        .accept(MediaType.APPLICATION_JSON_UTF8_VALUE)
        .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE);

    MvcResult result = mockMvc.perform(requestBuilder).andReturn();
    MockHttpServletResponse response = result.getResponse();

    String outputInJson = response.getContentAsString();

    Assertions.assertThat(outputInJson).isEqualTo(inputInJson);
  }

  @Test
  public void t3_product_findAll() throws Exception {
    Product product = new Product();
    product.setName("test");
    product.setCode("001");

    Product product2 = new Product();
    product2.setName("test2");
    product2.setCode("002");

    List<Product> productList = new ArrayList<>();
    productList.add(product);
    productList.add(product2);

    String inputInJson = this.mapToJson(productList);

    String URI = "/productapi/products";

    Mockito.when(productBusinessService.findAll()).thenReturn(productList);

    RequestBuilder requestBuilder = MockMvcRequestBuilders.get(URI)
        .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE);

    MvcResult result = mockMvc.perform(requestBuilder).andReturn();
    MockHttpServletResponse response = result.getResponse();

    String outputInJson = response.getContentAsString();

    Assertions.assertThat(outputInJson).isEqualTo(inputInJson);
  }

  private String mapToJson(Object object) throws JsonProcessingException {
    ObjectMapper objectMapper = new ObjectMapper();
    return objectMapper.writeValueAsString(object);
  }

}
