package br.com.sizer.repository;

import br.com.sizer.model.Company;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends PagingAndSortingRepository<Company, Long>, JpaSpecificationExecutor<Company> {
    Company findById(Long id);
}
