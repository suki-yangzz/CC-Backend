package com.project.cc.ccbackend.controller.user;

import com.datastax.driver.core.utils.UUIDs;
import com.google.common.collect.ImmutableMap;
import com.project.cc.ccbackend.cassandra.model.UserInfo;
import com.project.cc.ccbackend.cassandra.repository.UserInfoRepository;
import com.project.cc.ccbackend.cassandra.udt.Location;
import com.project.cc.ccbackend.config.ErrorCode;
import com.project.cc.ccbackend.config.ResponseCode;
import com.project.cc.ccbackend.model.BaseResponse;
import com.project.cc.ccbackend.model.User;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.core.CassandraTemplate;
import org.springframework.data.cassandra.core.InsertOptions;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/user")
@Log4j
public class UserController {

    @Autowired
    private UserInfoRepository userInfoRepository;

    @Autowired
    private CassandraTemplate cassandraTemplate;

    @GetMapping("/{id}")
    public UserInfo getUser(@PathVariable("id") final UUID id) {
        return userInfoRepository.getUserInfoById(id);
    }

    @PostMapping
    @ResponseBody
    public BaseResponse createUserInfo(@RequestBody User user) {
        final UUID uuid = UUIDs.timeBased();
        final UserInfo userInfo = new UserInfo(uuid, user.getUsername(),
                user.getAvatarUrl(), user.getGender(), user.getAge(),
                new Location(user.getCity(), user.getState(), user.getCountry(), user.getLanguage()));
        if (cassandraTemplate.insert(userInfo, InsertOptions.builder().ifNotExists(true).build()).wasApplied()) {
            return BaseResponse.builder()
                    .code(ResponseCode.SUCCESS.getCode())
                    .message(ResponseCode.SUCCESS.getMessage())
                    .result(
                            ImmutableMap.<String, UUID> builder()
                                    .put("uuid", uuid).build()
                    ).build();
        } else {
            return BaseResponse.builder().code(ErrorCode.DATABASE.getCode()).message(ErrorCode.DATABASE.getMessage()).build();
        }
    }
}
