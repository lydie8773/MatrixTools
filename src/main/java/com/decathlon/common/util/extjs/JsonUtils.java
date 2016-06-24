package com.decathlon.common.util.extjs;


import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DengYuanqin on 3/23/2016.
 */
public class JsonUtils {
    Logger logger = Logger.getLogger(JsonUtils.class);
    public static List<FilterRequest> getListFromJsonArray(String data){
        List<FilterRequest> values = new ArrayList<FilterRequest>();
        try {
            ObjectMapper mapper = new ObjectMapper();
            values = mapper.readValue(data,
                    new TypeReference<List<FilterRequest>>() {
                    });
        }catch (Exception e){
            e.printStackTrace();
        }

        return values;
    }
}
