package org.example;

import io.restassured.response.Response;
import org.example.apitests.baseSpec.controller.UserApi;
import org.example.model.Car;
import org.example.model.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;

public class SimpleApiTests {

    @ParameterizedTest
    @MethodSource("org.example.apitests.baseSpec.controller.UserData#userData")
    @DisplayName("Simple test with get request")
    public void test(String userName, String userEmail, List<Car> carDetails) {

        var UserPojo = new UserApi().sendUser(userName, userEmail, carDetails);
        Response responseUserCreating = UserApi.sendUserInfo(UserPojo);
        assertThat(responseUserCreating.statusCode(), equalTo(200));

        Response responseGetUserInfo = UserApi.getUserInfo();
        List<User> users = responseGetUserInfo.jsonPath().getList("", User.class);
        assertThat(responseGetUserInfo.statusCode(), equalTo(200));
        assertThat(users, is(not(empty())));

    }
}
