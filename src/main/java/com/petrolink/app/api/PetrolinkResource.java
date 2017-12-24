package com.petrolink.app.api;

import com.google.common.base.Optional;
import com.petrolink.app.representation.DateQuantityResponse;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Path("/petrolink")
public class PetrolinkResource {

    public PetrolinkResource() {

    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String welcome() {
        return "Welcome to PetroLink. Interested in our apis ? \nPlease visit /data?startDate=2017-01-02&endDate=2017-01-06";
    }

    @GET
    @Path("/data")
    @Produces(MediaType.APPLICATION_JSON)
    public List<DateQuantityResponse> generateRandomData(@QueryParam("startDate") String startDateStr, @QueryParam("endDate") String endDateStr) {

        java.time.LocalDate startDate = java.time.LocalDate.parse(startDateStr);
        LocalDateTime startDateTime = LocalDateTime.of(startDate.getYear(), startDate.getMonth(), startDate.getDayOfMonth(), 0 , 0, 0);

        LocalDate endDate = LocalDate.parse(endDateStr);
        LocalDateTime endDateTime = LocalDateTime.of(endDate.getYear(), endDate.getMonth(), endDate.getDayOfMonth(), 0,0,0);

        LocalDateTime updatedEndDateTime = endDateTime.plusSeconds(1L);

        List<DateQuantityResponse> responseList = new ArrayList<DateQuantityResponse>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.0000000'Z'");

        while(startDateTime.isBefore(updatedEndDateTime)) {

            long quantity = ThreadLocalRandom.current().nextInt(0, 1000 + 1);
            DateQuantityResponse obj = new DateQuantityResponse(startDateTime.format(formatter), quantity);
            responseList.add(obj);

            startDateTime = startDateTime.plusSeconds(1);
        }
        return responseList;
    }
}
