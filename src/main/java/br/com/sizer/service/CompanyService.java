package br.com.sizer.service;

import br.com.sizer.model.Company;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public interface CompanyService {
    Company createCompany(Company company);

    Page<Company> getAllCompany(int page, int limit);

    Company updateCompany(Long id, Company companyDetails);

    void deleteCompany(Long id);

    List<Company> searchCompany(Specification<Company> spec);
}
