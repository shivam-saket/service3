package com.centime.service3.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.centime.service3.annotation.LogMethodParam;
import com.centime.service3.dto.RequestJson;
import com.centime.service3.service.NameService;

@RestController
@RequestMapping(value = "/")
public class ServiceEndpoint {

   @Autowired
   private NameService nameService;
   
   @PostMapping
   @LogMethodParam
   public ResponseEntity<String> postJson(@RequestBody RequestJson request) {
      return ResponseEntity.ok(nameService.postJson(request));
   }
}