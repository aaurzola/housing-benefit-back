package com.aaurzola.housingbenefit.controller;

import com.aaurzola.housingbenefit.dto.MessagePayload;
import com.aaurzola.housingbenefit.dto.RequesterDetailDTO;
import com.aaurzola.housingbenefit.dto.RequestDTO;
import com.aaurzola.housingbenefit.model.Request;
import com.aaurzola.housingbenefit.service.request.RequestService;
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

    @GetMapping("{requestId}")
    public ResponseEntity<Request> getApplicationById(@PathVariable Long requestId) {
        return ResponseEntity.status(HttpStatus.OK).body(service.getRequestById(requestId));
    }

    @GetMapping("requesterDetails/{requestId}")
    public ResponseEntity<List<RequesterDetailDTO>> getRequesterDetail(@PathVariable Long requestId) {
        return ResponseEntity.status(HttpStatus.OK).body(service.getRequester(requestId));
    }

    @PostMapping()
    public ResponseEntity<Long> submitApplication(@RequestBody RequestDTO request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.submitRequest(request));
    }

    @PostMapping("approvals/{requestId}")
    public ResponseEntity<MessagePayload> approveRequest(@PathVariable Long requestId) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(new MessagePayload(service.approveRequest(requestId)));
    }

    @PostMapping("rejections/{requestId}")
    public ResponseEntity<MessagePayload> rejectRequest(@PathVariable Long requestId) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(new MessagePayload(service.rejectRequest(requestId)));
    }

    @DeleteMapping("rejectedRequest")
    public ResponseEntity<MessagePayload> deleteAllRejectedRequests() {
        return ResponseEntity.status(HttpStatus.OK).body(new MessagePayload(service.deleteRejectedRequests()));
    }
}
