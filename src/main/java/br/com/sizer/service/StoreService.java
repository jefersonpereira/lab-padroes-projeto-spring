package br.com.sizer.service;

import br.com.sizer.model.Store;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public interface StoreService {
    Store createStore(Store store);

    Page<Store> getAllStore(int page, int limit);

    Store updateStore(Long id, Store storeDetails);

    void deleteStore(Long id);

    List<Store> searchStore(Specification<Store> spec);
}
