package com.mongo.multitenancy.config;

import com.mongo.multitenancy.util.ConnectionStorage;
import com.mongodb.ConnectionString;
import com.mongodb.client.MongoDatabase;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;

import java.util.Objects;

public class DatabaseConfig extends SimpleMongoClientDatabaseFactory {

	public DatabaseConfig(ConnectionString connectionString) {
		super(connectionString);

	}

	@Override
	protected MongoDatabase doGetMongoDatabase(String dbName) {

		ConnectionString connectionString = new ConnectionString(ConnectionStorage.getConnection());
		return super.doGetMongoDatabase(Objects.requireNonNull(connectionString.getDatabase()));
	}
}