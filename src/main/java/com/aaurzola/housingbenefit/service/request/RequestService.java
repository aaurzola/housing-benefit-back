package com.aaurzola.housingbenefit.service.request;

import com.aaurzola.housingbenefit.dto.RequesterDetailDTO;
import com.aaurzola.housingbenefit.dto.RequestDTO;
import com.aaurzola.housingbenefit.model.Request;

import java.util.List;

public interface RequestService {

    List<Request> getAllRequests();
    Request getRequestById(Long requestId);
    Long submitRequest(RequestDTO requestDTO);
    List<RequesterDetailDTO> getRequester(Long requestId);
    String approveRequest(Long requestId);
    String rejectRequest(Long requestId);
    String deleteRejectedRequests();
}
