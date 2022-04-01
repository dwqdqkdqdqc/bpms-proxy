package ru.sitronics.tn.camundaproxyrestapi.process_definition;

public final class ProcessDefinitionConstants {

    public static final String KEY = "id";
    public static final String START_PROCESS_URI = "/process-definition/key/{key}/start";
    public static final String REQUEST_JSON = """
                "variables": {
               "aVariable": {
                 "value": "aStringValue",
                 "type": "String"
               },
               "anotherVariable": {
                 "value": true,
                 "type": "Boolean"
               }
             },
             "businessKey": "myBusinessKey"
            """;
    public static final String RESPONSE_JSON = """
               links": [
             {
               "method": "GET",
               "href": "http://localhost:8080/rest-test/process-instance/anId",
               "rel": "self"
             }
            ,
            id": "anId",
            definitionId": "aProcessDefinitionId",
            businessKey": "myBusinessKey",
            ended": false,
            suspended": false
            """;
}