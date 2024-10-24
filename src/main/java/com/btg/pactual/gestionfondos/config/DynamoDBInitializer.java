package com.btg.pactual.gestionfondos.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.CreateTableRequest;
import software.amazon.awssdk.services.dynamodb.model.AttributeDefinition;
import software.amazon.awssdk.services.dynamodb.model.KeySchemaElement;
import software.amazon.awssdk.services.dynamodb.model.KeyType;
import software.amazon.awssdk.services.dynamodb.model.ProvisionedThroughput;


@Service
public class DynamoDBInitializer {

    private final DynamoDbClient dynamoDbClient;

    @Autowired
    public DynamoDBInitializer(DynamoDbClient dynamoDbClient) {
        this.dynamoDbClient = dynamoDbClient;
        createTables();
    }

    private void createTables() {
        createFondosTable();
        createClientesTable();
        createSuscripcionTable();
        createTransaccionTable();
    }

    private void createFondosTable() {
        CreateTableRequest createTableRequest = CreateTableRequest.builder()
                .tableName("Fondos") // Nombre de la tabla
                .keySchema(KeySchemaElement.builder()
                        .attributeName("id") // Nombre de la clave primaria
                        .keyType(KeyType.HASH) // Tipo de clave: HASH
                        .build())
                .attributeDefinitions(AttributeDefinition.builder()
                        .attributeName("id")
                        .attributeType("S") // Tipo de dato de la clave primaria
                        .build())
                .provisionedThroughput(ProvisionedThroughput.builder()
                        .readCapacityUnits(5L) // Unidades de lectura
                        .writeCapacityUnits(5L) // Unidades de escritura
                        .build())
                .build();

        dynamoDbClient.createTable(createTableRequest);
        System.out.println("Tabla 'Fondos' creada.");
    }

    private void createClientesTable() {
        CreateTableRequest createTableRequest = CreateTableRequest.builder()
                .tableName("Clientes") // Nombre de la tabla
                .keySchema(KeySchemaElement.builder()
                        .attributeName("id") // Nombre de la clave primaria
                        .keyType(KeyType.HASH) // Tipo de clave: HASH
                        .build())
                .attributeDefinitions(AttributeDefinition.builder()
                        .attributeName("id")
                        .attributeType("S") // Tipo de dato de la clave primaria
                        .build())
                .provisionedThroughput(ProvisionedThroughput.builder()
                        .readCapacityUnits(5L) // Unidades de lectura
                        .writeCapacityUnits(5L) // Unidades de escritura
                        .build())
                .build();

        dynamoDbClient.createTable(createTableRequest);
        System.out.println("Tabla 'Clientes' creada.");
    }

    private void createSuscripcionTable() {
        CreateTableRequest createTableRequest = CreateTableRequest.builder()
                .tableName("Suscripcion") // Nombre de la tabla
                .keySchema(KeySchemaElement.builder()
                        .attributeName("id") // Nombre de la clave primaria
                        .keyType(KeyType.HASH) // Tipo de clave: HASH
                        .build())
                .attributeDefinitions(AttributeDefinition.builder()
                        .attributeName("id")
                        .attributeType("S") // Tipo de dato de la clave primaria
                        .build())
                .provisionedThroughput(ProvisionedThroughput.builder()
                        .readCapacityUnits(5L) // Unidades de lectura
                        .writeCapacityUnits(5L) // Unidades de escritura
                        .build())
                .build();

        dynamoDbClient.createTable(createTableRequest);
        System.out.println("Tabla 'Suscripcion' creada.");
    }

    private void createTransaccionTable() {
        CreateTableRequest createTableRequest = CreateTableRequest.builder()
                .tableName("Transaccion") // Nombre de la tabla
                .keySchema(KeySchemaElement.builder()
                        .attributeName("id") // Nombre de la clave primaria
                        .keyType(KeyType.HASH) // Tipo de clave: HASH
                        .build())
                .attributeDefinitions(AttributeDefinition.builder()
                        .attributeName("id")
                        .attributeType("S") // Tipo de dato de la clave primaria
                        .build())
                .provisionedThroughput(ProvisionedThroughput.builder()
                        .readCapacityUnits(5L) // Unidades de lectura
                        .writeCapacityUnits(5L) // Unidades de escritura
                        .build())
                .build();

        dynamoDbClient.createTable(createTableRequest);
        System.out.println("Tabla 'Transaccion' creada.");
    }
}
