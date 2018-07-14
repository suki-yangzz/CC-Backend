CREATE KEYSPACE IF NOT EXISTS cc_keyspace
  WITH REPLICATION = {
   'class' : 'SimpleStrategy',
   'replication_factor' : 1
  };

USE cc_keyspace;

CREATE TYPE cc_keyspace.location (
  city text,
  state text,
  country text,
  language text
);

CREATE TABLE IF NOT EXISTS config (
  id uuid PRIMARY KEY,
  max_capacity int,
  grow_pace int
);

CREATE TABLE IF NOT EXISTS user_info (
  uuid uuid PRIMARY KEY,
  username text,
  avatar_url text,
  gender int,
  age int,
  location FROZEN<location>,
  deleted boolean,
  created_timestamp timestamp,
  modified_timestamp timestamp
);

CREATE TABLE IF NOT EXISTS element (
  cid uuid PRIMARY KEY,
  element_type text,
  elementname text,
  description text,
  difficulty int,
  picUrl text
);
