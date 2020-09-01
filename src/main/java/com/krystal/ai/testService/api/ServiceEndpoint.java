package com.krystal.ai.testService.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.krystal.ai.testService.annotation.LogMethodParam;
import com.krystal.ai.testService.service.CumlationService;

@RestController
@RequestMapping(value = "/")
public class ServiceEndpoint {

   @Autowired
   private CumlationService cumlationService;
   
   @GetMapping
   @LogMethodParam
   public ResponseEntity<List<Integer>> getNumbers(@RequestParam Integer lastMinute) {
      return ResponseEntity.ok(cumlationService.getNumbers(lastMinute));
   }
}