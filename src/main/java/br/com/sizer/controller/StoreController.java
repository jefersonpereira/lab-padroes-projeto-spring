package br.com.sizer.controller;

import br.com.sizer.utill.StoreSpecificationsBuilder;
import br.com.sizer.model.Store;
import br.com.sizer.service.StoreService;
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
public class StoreController {

    @Autowired
    StoreService storeService;

    // -------------------create store -------------------
    @PostMapping("/store")
    ResponseEntity<?> createStore(@RequestBody Store request) {
        Store response = storeService.createStore(request);
        return new ResponseEntity<Object>(response, HttpStatus.OK);
    }

    // -------read the company in json format with pagination----------
    @RequestMapping(value = "/stores", method = RequestMethod.GET, produces = { "application/json" })
    ResponseEntity<?> getAllStore(@RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "limit", defaultValue = "5") int limit) {
        Page<Store> response = storeService.getAllStore(page, limit);
        return new ResponseEntity<Object>(response, HttpStatus.OK);
    }

    // --------------------update the store --------------------
    @RequestMapping(value = "/store/{id}", method = RequestMethod.PUT, consumes = { "application/json" }, produces = {
            "application/json" })
    public ResponseEntity<?> updateStore(@PathVariable(value = "id") Long storeId,
            @RequestBody Store storeDetails) {
        Store response = storeService.updateStore(storeId, storeDetails);
        return new ResponseEntity<Object>(response, HttpStatus.OK);
    }

    // ---------------------delete the store ---------------------
    @DeleteMapping("/store/{id}")
    public ResponseEntity<?> deleteStore(@PathVariable(value = "id") Long storeId) {
        storeService.deleteStore(storeId);
        return ResponseEntity.ok().build();
    }

    // ------------------------search store ------------------------
    @RequestMapping(method = RequestMethod.GET, value = "/store")
    public ResponseEntity<?> search(@RequestParam(value = "search") String search) {
        StoreSpecificationsBuilder builder = new StoreSpecificationsBuilder();
        Pattern pattern = Pattern.compile("(\\w+?)(:|<|>)(\\w+?),");
        Matcher matcher = pattern.matcher(search + ",");
        while (matcher.find()) {
            builder.with(matcher.group(1), matcher.group(2), matcher.group(3));
        }
        Specification<Store> spec = builder.build();
        List<Store> response = storeService.searchStore(spec);
        return new ResponseEntity<Object>(response, HttpStatus.OK);
    }
}
