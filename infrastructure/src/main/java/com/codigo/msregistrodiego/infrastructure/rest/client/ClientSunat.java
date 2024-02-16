package com.codigo.msregistrodiego.infrastructure.rest.client;

import com.codigo.msregistrodiego.domain.aggregates.response.ResponseReniec;
import com.codigo.msregistrodiego.domain.aggregates.response.ResponseSunat;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "client-sunat",url = "https://api.apis.net.pe/v2/sunat/")
public interface ClientSunat {

    @GetMapping("/ruc")
    ResponseSunat getInfoSunat(@RequestParam("numero") String numero,
                               @RequestHeader("Authorization") String authorizationHeader);
}
