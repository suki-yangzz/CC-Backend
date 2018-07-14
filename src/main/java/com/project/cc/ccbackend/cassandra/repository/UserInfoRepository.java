package com.project.cc.ccbackend.cassandra.repository;

import com.project.cc.ccbackend.cassandra.model.UserInfo;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserInfoRepository extends CassandraRepository<UserInfo, UUID> {

    @Query("select * from user_info where uuid = ?0")
    UserInfo getUserInfoById(UUID id);
}
