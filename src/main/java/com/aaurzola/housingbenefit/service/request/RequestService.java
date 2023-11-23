package com.aaurzola.housingbenefit.service.request;

import com.aaurzola.housingbenefit.dto.RequesterDetailDTO;
import com.aaurzola.housingbenefit.dto.RequestDTO;
import com.aaurzola.housingbenefit.model.Request;

import java.util.List;

public interface RequestService {

    /**
     * Finds all the requests avalible on the database
     * @return a list of all request
     */
    List<Request> getAllRequests();

    /**
     *
     * @param requestId
     * @return The desirable Request
     */
    Request getRequestById(Long requestId);

    /**
     * Submits a new request using a DTO
     * @param requestDTO
     * @return the id of the newly created request
     */
    Long submitRequest(RequestDTO requestDTO);

    /**
     * Finds the requesters individuals associated to a request
     * @param requestId
     * @return the list of requesters
     */
    List<RequesterDetailDTO> getRequester(Long requestId);

    /**
     * Triggers a Stored Procedure that approves a request by id
     * @param requestId
     * @return a message with the outcome of the process
     */
    String approveRequest(Long requestId);

    /**
     * Triggers a Stored Procedure that rejects a request by id
     * @param requestId
     * @return a message with the outcome of the process
     */
    String rejectRequest(Long requestId);

    /**
     * Triggers a Store Procedure that removes all the information associated with requests that has 'N' as a value in the
     * column 'IS_APPROVED'
     * @return a mesasge with the outcome of the process
     */
    String deleteRejectedRequests();
}
