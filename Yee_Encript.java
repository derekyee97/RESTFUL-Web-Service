package com.rest.jerseyclient;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class Yee_Encript {    
  protected String getTbstoCupsResponse(String retrievedText) {
    String output = null;
    String output2 = null;
    try {
      String value=retrievedText;
      Client client = Client.create();
      //updated with url
      WebResource webResource = client.resource("http://localhost:8080/UIBakerRESTJerseyServer/rest/encrypt/").path(value);
      ClientResponse response = webResource.accept("text/html").get(ClientResponse.class);
      if (response.getStatus() != 200) {
        throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
      }    
      output = response.getEntity(String.class);
      output2 = output.replace("@Produces(\"text/html\") Output: ","");
      System.out.println(output2);
      System.out.println("\n\n=");
    } catch (Exception e) {
      System.out.println("Serverck Again and enter a number");
    }
    return output2;
    }
}

