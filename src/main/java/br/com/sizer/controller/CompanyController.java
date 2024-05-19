package br.com.sizer.controller;

import br.com.sizer.utill.CompanySpecificationsBuilder;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;

import br.com.sizer.model.Company;
import br.com.sizer.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController
@RequestMapping("/api")
public class CompanyController {

    @Autowired
    CompanyService companyService;

    // -------------------create company -------------------
    @ApiOperation(value = "Criar Empresa")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Retorna a empresa criada"),
        @ApiResponse(code = 403, message = "Você não tem permissão para criar uma empresa"),
        @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @PostMapping("/company")
    ResponseEntity<?> createCompany(@RequestBody Company request) {
        Company response = companyService.createCompany(request);
        return new ResponseEntity<Object>(response, HttpStatus.OK);
    }

    // -------read the company in json format with pagination----------
    @ApiOperation(value = "List Companies")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Listar Empresas"),
        @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
        @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    
    @RequestMapping(value = "/companies", method = RequestMethod.GET, produces = { "application/json" })
    ResponseEntity<?> getAllCompany(@RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "limit", defaultValue = "5") int limit) {
        Page<Company> response = companyService.getAllCompany(page, limit);
        return new ResponseEntity<Object>(response, HttpStatus.OK);
    }

    // --------------------update the company --------------------
    @RequestMapping(value = "/company/{id}", method = RequestMethod.PUT, consumes = { "application/json" }, produces = {
            "application/json" })
    public ResponseEntity<?> updateCompany(@PathVariable(value = "id") Long companyId,
            @RequestBody Company companyDetails) {
        Company response = companyService.updateCompany(companyId, companyDetails);
        return new ResponseEntity<Object>(response, HttpStatus.OK);
    }

    // ---------------------delete the company ---------------------
    @DeleteMapping("/company/{id}")
    public ResponseEntity<?> deleteCompany(@PathVariable(value = "id") Long companyId) {
        companyService.deleteCompany(companyId);
        return ResponseEntity.ok().build();
    }

    // ------------------------search company ------------------------
    @RequestMapping(method = RequestMethod.GET, value = "/company")
    public ResponseEntity<?> search(@RequestParam(value = "search") String search) {
        CompanySpecificationsBuilder builder = new CompanySpecificationsBuilder();
        Pattern pattern = Pattern.compile("(\\w+?)(:|<|>)(\\w+?),");
        Matcher matcher = pattern.matcher(search + ",");
        while (matcher.find()) {
            builder.with(matcher.group(1), matcher.group(2), matcher.group(3));
        }
        Specification<Company> spec = builder.build();
        List<Company> response = companyService.searchCompany(spec);
        return new ResponseEntity<Object>(response, HttpStatus.OK);
    }
}
