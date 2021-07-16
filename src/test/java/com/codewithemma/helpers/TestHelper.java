package com.codewithemma.helpers;

import com.codewithemma.auth.User;
import com.codewithemma.dto.request.AccountRequest;
import com.codewithemma.dto.request.AuthRequest;
import com.codewithemma.dto.response.AccountMicroServiceResponse;
import com.codewithemma.enums.Role;
import com.codewithemma.model.Account;
import com.github.javafaker.Faker;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.util.Arrays;

import static com.codewithemma.enums.ResponseCode.*;


public class TestHelper {

    public static String TEST_EMAIL = "unogwudan@gmail.com";

    public static Account getCreatedAccount() {
        Faker faker = Faker.instance();
        Account account = Account.builder()
                .email(faker.name().username().concat("@example.name"))
                .firstName(faker.name().firstName())
                .surname(faker.name().lastName())
                .otherName(faker.name().nameWithMiddle())
                .password("pass")
                .phoneNumber(faker.phoneNumber().phoneNumber())
                .build();
        account.setId(1l);

        return account;
    }

    public static Account createAccountRequest() {
        Faker faker = Faker.instance();
        Account account = Account.builder()
                .email(faker.name().username().concat("@example.name"))
                .firstName(faker.name().firstName())
                .surname(faker.name().lastName())
                .otherName(faker.name().nameWithMiddle())
                .password("pass")
                .phoneNumber(faker.phoneNumber().phoneNumber())
                .build();

        return account;
    }

    public static AccountRequest getAccountDto() {
        Faker faker = Faker.instance();
        AccountRequest account = AccountRequest.builder()
                .email(faker.name().username().concat("@example.name"))
                .firstName(faker.name().firstName())
                .surname(faker.name().lastName())
                .otherName(faker.name().nameWithMiddle())
                .password("pass")
                .phoneNumber(faker.phoneNumber().phoneNumber())
                .build();
        return account;
    }

    public static Mono<AccountMicroServiceResponse> getSuccessfulResponse() {
        AccountMicroServiceResponse response = AccountMicroServiceResponse
                .builder()
                .statusCode(OK.getCanonicalCode())
                .statusMessage(OK.getDescription())
                .timestamp(LocalDateTime.now().toString())
                .data(getCreatedAccount())
                .build();
        return Mono.just(response);
    }

    public static Mono<AccountMicroServiceResponse> getFailureResponse() {
        AccountMicroServiceResponse response = AccountMicroServiceResponse
                .builder()
                .statusCode(INTERNAL_SERVER_ERROR.getCanonicalCode())
                .statusMessage(INTERNAL_SERVER_ERROR.getDescription())
                .timestamp(LocalDateTime.now().toString())
                .data(getCreatedAccount())
                .build();
        return Mono.just(response);
    }

    public static AuthRequest authRequest() {
        return new AuthRequest("unogwudan@example.com", "password");
    }

    public static Mono<User> getUser() {
        return Mono.just(new User(1l, "unogwudan@example.com", "password", Arrays.asList(Role.ROLE_USER), "dan", "dan", "08037731178"));
    }
}
