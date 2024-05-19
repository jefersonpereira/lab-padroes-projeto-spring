/*
package br.com.sizer;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.sizer.model.Company;
import br.com.sizer.repository.CompanyRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.willDoNothing;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class CompanyControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    void setup(){
        companyRepository.deleteAll();
    }

    // JUnit test for Get All companys REST API
    @Test
    public void givenListOfCompanys_whenGetAllCompanys_thenReturnCompanysList() throws Exception{
        // given - precondition or setup
        List<Company> listOfCompanys = new ArrayList<>();
        listOfCompanys.add(Company.builder().firstName("Ramesh").lastName("Fadatare").email("ramesh@gmail.com").build());
        listOfCompanys.add(Company.builder().firstName("Tony").lastName("Stark").email("tony@gmail.com").build());
        companyRepository.saveAll(listOfCompanys);
        // when -  action or the behaviour that we are going test
        ResultActions response = mockMvc.perform(get("/api/companys"));

        // then - verify the output
        response.andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$.size()",
                        is(listOfCompanys.size())));

    }

    // positive scenario - valid company id
    // JUnit test for GET company by id REST API
    @Test
    public void givenCompanyId_whenGetCompanyById_thenReturnCompanyObject() throws Exception{
        // given - precondition or setup
        Company company = Company.builder()
                .firstName("Ramesh")
                .lastName("Fadatare")
                .email("ramesh@gmail.com")
                .build();
        companyRepository.save(company);

        // when -  action or the behaviour that we are going test
        ResultActions response = mockMvc.perform(get("/api/companys/{id}", company.getId()));

        // then - verify the output
        response.andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$.firstName", is(company.getFirstName())))
                .andExpect(jsonPath("$.lastName", is(company.getLastName())))
                .andExpect(jsonPath("$.email", is(company.getEmail())));

    }

    // negative scenario - valid company id
    // JUnit test for GET company by id REST API
    @Test
    public void givenInvalidCompanyId_whenGetCompanyById_thenReturnEmpty() throws Exception{
        // given - precondition or setup
        long companyId = 1L;
        Company company = Company.builder()
                .firstName("Ramesh")
                .lastName("Fadatare")
                .email("ramesh@gmail.com")
                .build();
        companyRepository.save(company);

        // when -  action or the behaviour that we are going test
        ResultActions response = mockMvc.perform(get("/api/companys/{id}", companyId));

        // then - verify the output
        response.andExpect(status().isNotFound())
                .andDo(print());

    }

    // JUnit test for update company REST API - positive scenario
    @Test
    public void givenUpdatedCompany_whenUpdateCompany_thenReturnUpdateCompanyObject() throws Exception{
        // given - precondition or setup
        Company savedCompany = Company.builder()
                .firstName("Ramesh")
                .lastName("Fadatare")
                .email("ramesh@gmail.com")
                .build();
        companyRepository.save(savedCompany);

        Company updatedCompany = Company.builder()
                .firstName("Ram")
                .lastName("Jadhav")
                .email("ram@gmail.com")
                .build();

        // when -  action or the behaviour that we are going test
        ResultActions response = mockMvc.perform(put("/api/companys/{id}", savedCompany.getId())
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(updatedCompany)));


        // then - verify the output
        response.andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$.firstName", is(updatedCompany.getFirstName())))
                .andExpect(jsonPath("$.lastName", is(updatedCompany.getLastName())))
                .andExpect(jsonPath("$.email", is(updatedCompany.getEmail())));
    }

    // JUnit test for update company REST API - negative scenario
    @Test
    public void givenUpdatedCompany_whenUpdateCompany_thenReturn404() throws Exception{
        // given - precondition or setup
        long companyId = 1L;
        Company savedCompany = Company.builder()
                .firstName("Ramesh")
                .lastName("Fadatare")
                .email("ramesh@gmail.com")
                .build();
        companyRepository.save(savedCompany);

        Company updatedCompany = Company.builder()
                .firstName("Ram")
                .lastName("Jadhav")
                .email("ram@gmail.com")
                .build();

        // when -  action or the behaviour that we are going test
        ResultActions response = mockMvc.perform(put("/api/companys/{id}", companyId)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(updatedCompany)));

        // then - verify the output
        response.andExpect(status().isNotFound())
                .andDo(print());
    }

    // JUnit test for delete company REST API
    @Test
    public void givenCompanyId_whenDeleteCompany_thenReturn200() throws Exception{
        // given - precondition or setup
        Company savedCompany = Company.builder()
                .firstName("Ramesh")
                .lastName("Fadatare")
                .email("ramesh@gmail.com")
                .build();
        companyRepository.save(savedCompany);

        // when -  action or the behaviour that we are going test
        ResultActions response = mockMvc.perform(delete("/api/companys/{id}", savedCompany.getId()));

        // then - verify the output
        response.andExpect(status().isOk())
                .andDo(print());
    }
}
*/
