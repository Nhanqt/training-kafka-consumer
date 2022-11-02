package com.example.item.api;


import com.example.item.entity.CartEntity;
import com.example.item.entity.ItemEntity;
import com.example.item.exception.exceptions.NotAllowException;
import com.example.item.repository.CartRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;
import org.webjars.NotFoundException;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static com.example.item.common.ConstantApi.ITEM_API;

@RestController
@RequestMapping("/api/cart")
@Transactional(readOnly = true)
public class CartController {
    @Autowired
    private RestTemplate restTemplate;
    private final CartRepository cartRepository;
    ObjectMapper objectMapper = new ObjectMapper();

    public CartController(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    @GetMapping()
    public List<CartEntity> getAll() {
        return cartRepository.findAll();
    }

    @PostMapping()
    @Transactional
    public CartEntity addItem(@RequestBody CartEntity cartEntity) throws JsonProcessingException {
        try {
            for (ItemEntity items: cartEntity.getItems()){
                //String item = restTemplate.exchange(ITEM_API + items.getId(), HttpMethod.POST,items, (String.class));
             //   System.out.println(item);
            }
            return cartRepository.save(cartEntity);
        }catch (RestClientResponseException e){
            throw new NotAllowException("ID NOT FOUND");
        }
    }

    @GetMapping("/items")
    public List<Object> getItems(@RequestParam(required = false, defaultValue = "0") int id) throws JsonProcessingException {
        String items = restTemplate.getForObject(ITEM_API + id, String.class);
        Object item = objectMapper.readValue(items, Object.class);
        return Arrays.asList(item);
    }
}
