package com.scratchy.rest;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import com.scratchy.entity.Practitioner;
import com.scratchy.utils.AbstractApiTest;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MvcResult;

public class PractitionerControllerTest extends AbstractApiTest {

  private static final String PATH = "/v1/practitioner";

  @Test
  @SneakyThrows
  void shouldGetAllPractitioners() {
    // when
    MvcResult result = performRequest(PATH);

    List<Practitioner> doctors = mapper.readValue(result.getResponse().getContentAsString(),
        List.class);

    // then
    assertThat(doctors)
        .isNotEmpty()
        .hasSize(3);
  }

  @Test
  @SneakyThrows
  void shouldGetPractitionerByLastName() {
    // when
    MvcResult result = performRequest(PATH + "/Clarkins");

    Practitioner practitioner = mapper.readValue(result.getResponse().getContentAsString(),
        Practitioner.class);

    // then
    assertThat(practitioner.getLastName()).isEqualTo("Clarkins");
  }

  @Test
  @SneakyThrows
  void shouldCreateNewPractitioner() {
    // when
    MvcResult result = performPostRequest(PATH, new Practitioner("Clark", "Token"));

    // then
    assertThat(result.getResponse().getStatus()).isEqualTo(201);
  }
}
