package br.com.sizer.service;

import br.com.sizer.exception.ResourceNotFoundException;
import br.com.sizer.model.Store;
import br.com.sizer.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreServiceImpl implements StoreService {

    @Autowired
    StoreRepository storeRepository;

    @Override
    public Store createStore(Store store) {
        return storeRepository.save(store);
    }

    @Override
    public Page<Store> getAllStore(int page, int limit) {
        Page<Store> resultPage = storeRepository.findAll(new PageRequest(page, limit));
        if (page > resultPage.getTotalPages())
            throw new ResourceNotFoundException("Store", "id", resultPage);
        return resultPage;
    }

    @Override
    public Store updateStore(Long id, Store storeDetails) {
        Store store = storeRepository.findById(id);
        if (store == null)
            throw new ResourceNotFoundException("Store", "id", id);

        store.setName(storeDetails.getName());
        store.setUrl(storeDetails.getUrl());
        store.setMaxProducts(storeDetails.getMaxProducts());
        store.setCompany(storeDetails.getCompany());
        store.setCreatedBy(storeDetails.getCreatedBy());
        return storeRepository.save(store);
    }

    @Override
    public void deleteStore(Long id) {
        Store store = storeRepository.findById(id);
        if (store == null)
            throw new ResourceNotFoundException("Store", "id", id);

        storeRepository.delete(store);
    }

    @Override
    public List<Store> searchStore(Specification<Store> spec) {
        return storeRepository.findAll(spec);
    }
}
