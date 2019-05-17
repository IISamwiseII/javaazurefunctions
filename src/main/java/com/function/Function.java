package com.function;

import java.util.*;
import com.microsoft.azure.functions.annotation.*;
import com.microsoft.azure.functions.*;

public class Function {

    @FunctionName("usingstring")
    public HttpResponseMessage run(
            @HttpTrigger(name = "req", methods = {HttpMethod.GET, HttpMethod.POST}, authLevel = AuthorizationLevel.FUNCTION) HttpRequestMessage<Optional<String>> request,
            final ExecutionContext context) {
        
		context.getLogger().info("Java HTTP trigger processed a request.");
		
        String recievedBody = request.getBody().orElse("");
        context.getLogger().info(recievedBody);

        return request.createResponseBuilder(HttpStatus.OK).body(recievedBody).build();

    }

    @FunctionName("usingbyte")
    public HttpResponseMessage httpHandler(
            @HttpTrigger(name = "req", methods = {HttpMethod.GET, HttpMethod.POST}, authLevel = AuthorizationLevel.ANONYMOUS) HttpRequestMessage<Optional<byte[]>> request,
            final ExecutionContext context) {
				
        context.getLogger().info("Java HTTP trigger processed a request.");
        
		byte[] emptyByteArray = new byte[0];
        byte[] recievedBody = request.getBody().orElse(emptyByteArray);
        context.getLogger().info(recievedBody.toString());
        
		return request.createResponseBuilder(HttpStatus.OK).body(request.getBody().orElse(emptyByteArray)).build();
    }
}
