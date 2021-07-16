package com.codewithemma.helper;

import com.codewithemma.constants.ConstantsUsed;
import com.codewithemma.dto.request.AccountRequest;
import com.codewithemma.dto.request.EmailRequest;
import com.codewithemma.dto.response.AccountMicroServiceResponse;
import com.codewithemma.enums.ResponseCode;
import java.time.LocalDateTime;

public class Helper {

    public static AccountMicroServiceResponse buildSuccessfulResponse(Object data) {
        return AccountMicroServiceResponse.builder()
                .statusCode(ResponseCode.OK.getCanonicalCode())
                .statusMessage(ResponseCode.OK.getDescription())
                .timestamp(LocalDateTime.now().toString())
                .data(data)
                .build();

    }

    public static AccountMicroServiceResponse buildFailureResponse(Object data) {
        return AccountMicroServiceResponse.builder()
                .statusCode(ResponseCode.INVALID_CREDENTIALS.getCanonicalCode())
                .statusMessage(ResponseCode.INVALID_CREDENTIALS.getDescription())
                .timestamp(LocalDateTime.now().toString())
                .data(data)
                .build();

    }

    public static EmailRequest buildEmailRequest(AccountRequest request) {
        String message = ConstantsUsed.ACCOUNT_CREATION_MESSAGE
                .replace("{username}", request.getEmail())
                .replace("{password}", request.getPassword());

        return EmailRequest.builder()
                .to(request.getEmail())
                .subject(ConstantsUsed.ACCOUNT_CREATION_SUBJECT)
                .message(message)
                .build();
    }
}
