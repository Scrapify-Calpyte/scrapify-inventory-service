package com.scrapify.inventoryservice.controller;

import com.scrapify.inventoryservice.entity.Inventory;
import com.scrapify.inventoryservice.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    @PostMapping("/save")
    public ResponseEntity<Inventory> save(@RequestBody Inventory inventory){
        return new ResponseEntity<>(inventoryService.save(inventory), HttpStatus.CREATED);
    }

    @GetMapping("/by-id")
    public ResponseEntity<Inventory> findByUserId(@RequestParam("product") String productId , @RequestParam("address") String addressId){
        return new ResponseEntity<>(inventoryService.findByUserIdAndProductIdAndUserAddressId(productId, addressId),HttpStatus.OK);
    }

}