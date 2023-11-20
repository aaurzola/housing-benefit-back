package com.aaurzola.housingbenefit.controller;

import com.aaurzola.housingbenefit.dto.RequesterDetailDTO;
import com.aaurzola.housingbenefit.dto.RequestDTO;
import com.aaurzola.housingbenefit.exception.ResourceNotFoundException;
import com.aaurzola.housingbenefit.model.Request;
import com.aaurzola.housingbenefit.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("request")
public class RequestController {

    private final RequestService service;

    @Autowired
    public RequestController(RequestService service) {
        this.service = service;
    }

    @GetMapping()
    public ResponseEntity<List<Request>> getAllRequests() {
        return ResponseEntity.ok(service.getAllRequests());
    }

    //TODO: Refact method
    @GetMapping("{requestId}")
    public ResponseEntity<Request> getApplicationById(@PathVariable Long requestId) {
        Request request = service.getRequestById(requestId);
        if (request != null) {
            return ResponseEntity.status(HttpStatus.OK).body(request);
        } else {
            throw new ResourceNotFoundException("Solicitud", requestId);
        }
    }

    @GetMapping("requesterDetails/{requestId}")
    public ResponseEntity<List<RequesterDetailDTO>> getRequesterDetail(@PathVariable Long requestId) {
        return ResponseEntity.status(HttpStatus.OK).body(service.getRequester(requestId));
    }

    @PostMapping()
    public ResponseEntity<Long> submitApplication(@RequestBody RequestDTO request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.submitRequest(request));
    }
}
