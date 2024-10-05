package org.example.apitests.baseSpec.controller;

import io.restassured.response.Response;
import org.example.apitests.baseSpec.RestResource;
import org.example.model.Car;
import org.example.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.example.apitests.baseSpec.SpecBuilderPage.baseUrl;

public class UserApi {

    public static Response sendUserInfo(User request) {
        return RestResource.post(baseUrl() + "/users", request);
    }

    public static Response getUserInfo() {
        return RestResource.get(baseUrl()+"/users");
    }

    public User sendUser(String userName, String userEmail, List<Car> carDetails) {

        return User.builder()
                .name(userName)
                .email(userEmail)
                .cars(carDetails)
                .build();
    }


}
