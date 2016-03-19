package com.intheloop.intheloop;

import java.util.Map;

/**
 * Created by gbrett on 19/03/2016.
 */
public class HttpBinResponse {

    String url;

    // the requester ip
    String origin;

    // all headers that have been sent
    Map headers;

    // url arguments
    Map args;

    // post form parameters
    Map form;

    // post body json
    Map json;
}
