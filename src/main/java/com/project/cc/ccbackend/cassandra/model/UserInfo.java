package com.project.cc.ccbackend.cassandra.model;

import com.datastax.driver.core.DataType;
import com.project.cc.ccbackend.cassandra.udt.Location;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.cassandra.core.mapping.CassandraType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.Date;
import java.util.UUID;

@Data
@Table(value = "user_info")
@Getter @Setter @NoArgsConstructor
public class UserInfo {

    @PrimaryKey("uuid")
    private UUID uuid;

    @Column("username")
    private String userName;

    @Column("avatar_url")
    private String avatarUrl;

    @Column("gender")
    private int gender; //1 male, 2 female, 0 unknown

    @Column("age")
    private int age;

    @CassandraType(type = DataType.Name.UDT, userTypeName = "location")
    private Location location;

    @Column("deleted")
    private boolean deleted;

    @Column("created_timestamp")
    private Date createdTimestamp;

    @Column("modified_timestamp")
    private Date modifiedTimestamp;

    public UserInfo(final UUID uuid, final String userName, final String avatarUrl, final int gender,
                    final int age, final Location location) {
        this.uuid = uuid;
        this.userName = userName;
        this.avatarUrl = avatarUrl;
        this.gender = gender;
        this.age = age;
        this.location = location;
        this.deleted = false;
        this.createdTimestamp = new Date();
        this.modifiedTimestamp = new Date();
    }
}
