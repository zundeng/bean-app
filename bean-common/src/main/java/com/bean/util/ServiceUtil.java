package com.bean.util;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

/**
 * Created by Daniel on 14-8-17.
 */
public class ServiceUtil {
    public static ObjectMapper getObjectMapper(){
        ObjectMapper mapper = new ObjectMapper();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        df.setTimeZone(TimeZone.getTimeZone("UTC"));
        mapper.setDateFormat(df);
        mapper.setSerializationInclusion(JsonSerialize.Inclusion.NON_NULL);
        return mapper;
    }
    public static Response buildResponse(Object object) throws IOException {
        return Response.ok(ServiceUtil.getObjectMapper().writeValueAsString(object)).header("Content-type", MediaType.APPLICATION_JSON).build();
    }
}
