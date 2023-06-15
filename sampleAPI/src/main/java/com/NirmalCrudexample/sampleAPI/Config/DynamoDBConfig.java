package com.NirmalCrudexample.sampleAPI.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DynamoDBConfig {
    String awsSecretKey = "wqKbkwoBGB5rZZuhFc1ak09fmtZ5ECICzTkeEgGO";
    String awsAccessKey = "AKIA3UUB6FCQWTMCHZBB";
    String awsRegion = "ap-south-1";

    @Bean
    public DynamoDBMapper dynamoDBMapper(){return new DynamoDBMapper(amazonDynamoDb());
    }

    private AmazonDynamoDB amazonDynamoDb() {
        String dynamoDbEndpoint = "https://dynamodb.ap-south-1.amazonaws.com";
        return AmazonDynamoDBClientBuilder.standard()
                .withEndpointConfiguration(
                        new AwsClientBuilder.EndpointConfiguration(dynamoDbEndpoint, awsRegion))
                .withCredentials(amazonDynamoDBCredentials()).build();
    }

    private AWSCredentialsProvider amazonDynamoDBCredentials() {
        return new AWSStaticCredentialsProvider(new BasicAWSCredentials(awsAccessKey, awsSecretKey));
    }

    @Bean
    public SesClient sesClient() {
        return SesClient.builder()
                .region(Region.of(awsRegion)).credentialsProvider(StaticCredentialsProvider.create(AwsBasicCredentials.create(awsAccessKey, awsSecretKey)))
                .build();
    }

}
