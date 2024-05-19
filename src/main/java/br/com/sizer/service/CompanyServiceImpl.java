package br.com.sizer.service;

import br.com.sizer.exception.ResourceNotFoundException;
import br.com.sizer.model.Company;
import br.com.sizer.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    CompanyRepository companyRepository;

    @Override
    public Company createCompany(Company company) {
        return companyRepository.save(company);
    }

    @Override
    public Page<Company> getAllCompany(int page, int limit) {
        Page<Company> resultPage = companyRepository.findAll(new PageRequest(page, limit));
        if (page > resultPage.getTotalPages())
            throw new ResourceNotFoundException("Company", "id", resultPage);
        return resultPage;
    }

    @Override
    public Company updateCompany(Long id, Company companyDetails) {
        Company company = companyRepository.findById(id);
        if (company == null)
            throw new ResourceNotFoundException("Company", "id", id);

        company.setName(companyDetails.getName());
        company.setMaxStores(companyDetails.getMaxStores());
        company.setCreatedBy(companyDetails.getCreatedBy());
        return companyRepository.save(company);
    }

    @Override
    public void deleteCompany(Long id) {
        Company company = companyRepository.findById(id);
        if (company == null)
            throw new ResourceNotFoundException("Company", "id", id);

        companyRepository.delete(company);
    }

    @Override
    public List<Company> searchCompany(Specification<Company> spec) {
        return companyRepository.findAll(spec);
    }
}
