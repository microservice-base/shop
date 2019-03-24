package test.com.shop.product.api.integration;

import org.assertj.core.api.Assertions;
import org.json.JSONException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.shop.ShopApplication;
import com.shop.product.domain.Product;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ShopApplication.class, webEnvironment = WebEnvironment.DEFINED_PORT)
public class ProductApiIntegrationTest {

  @Autowired
  private TestRestTemplate testRestTemplate;

  @LocalServerPort
  private int port;

  private String createURLWithPort(final String uri) {
    StringBuilder builder = new StringBuilder();
    builder.append("http://localhost:");
    builder.append(this.port);
    builder.append(uri);
    return builder.toString();
  }

  @Test
  public void t1_findByCode() throws JSONException {
    Product product = new Product();
    product.setName("test");
    product.setCode("001");

    /** Temp Data */
    String url = createURLWithPort("/shop/productapi/save");
    ResponseEntity<Product> entitySave = testRestTemplate.postForEntity(url, product,
        Product.class);

    String inputNotEntity = entitySave.getBody().getCode();
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);
    HttpEntity<String> requestEntity = new HttpEntity<String>(inputNotEntity, headers);

    String url2 = createURLWithPort("/shop/productapi/findByCode");

    ResponseEntity<Product> entity = testRestTemplate.postForEntity(url2, requestEntity,
        Product.class);

    Assertions.assertThat(HttpStatus.OK).isEqualTo(entity.getStatusCode());
    Assertions.assertThat(entity.getBody().getId()).isNotNull();
    Assertions.assertThat(product.getName()).isEqualTo(entity.getBody().getName());

  }

}
