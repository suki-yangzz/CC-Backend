package com.project.cc.ccbackend.cassandra.udt;

import com.datastax.driver.core.DataType;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.cassandra.core.mapping.CassandraType;
import org.springframework.data.cassandra.core.mapping.UserDefinedType;

@Data
@UserDefinedType("location")
@AllArgsConstructor
public class Location {

    @CassandraType(type = DataType.Name.TEXT)
    String city, state, country, language;
}
