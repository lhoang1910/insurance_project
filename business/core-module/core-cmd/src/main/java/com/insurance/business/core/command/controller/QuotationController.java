package com.insurance.business.core.command.controller;

import com.insurance.business.core.command.service.QuotationService;
import com.insurance.infrastructure.shared.request.quotation.CreateQuotationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/core/quotation")
public class QuotationController {

    @Autowired
    private QuotationService quotationService;

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody CreateQuotationRequest request, @RequestHeader(value = "loggedInUser", defaultValue = "Anonymous") String username) {
        return ResponseEntity.ok(quotationService.createQuotation(request, username));
    }
}
