package com.aaurzola.housingbenefit.service;

import com.aaurzola.housingbenefit.dto.RequesterDetailDTO;
import com.aaurzola.housingbenefit.dto.RequestDTO;
import com.aaurzola.housingbenefit.model.Request;

import java.util.List;

public interface RequestService {

    List<Request> getAllRequests();
    Request getRequestById(Long requestId);
    Long submitRequest(RequestDTO requestDTO);
    List<RequesterDetailDTO> getRequester(Long requestId);

}
