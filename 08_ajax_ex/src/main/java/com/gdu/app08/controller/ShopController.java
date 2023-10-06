package com.gdu.app08.controller;

import org.springframework.web.bind.annotation.RestController;

import com.gdu.app08.service.ShopService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class ShopController {

  private final ShopService shopService;
  

}
