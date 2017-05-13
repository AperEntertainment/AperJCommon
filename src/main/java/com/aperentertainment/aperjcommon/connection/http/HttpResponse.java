/*
 * Copyright © 2017 AperEntertainment <aper.entertainment@gmail.com>
 *
 * This file is part of aperjcommon.
 *
 * Licensed under the MIT license. For more information,
 * see the LICENSE file.
 */

package com.aperentertainment.aperjcommon.connection.http;

import com.aperentertainment.aperjcommon.connection.Response;

import java.util.Map;

/**
 * <h1>HttpResponse</h1>
 * This class represents a HTTP response.
 *
 * @author AperEntertainment
 * @version 1.1.0
 * @since 1.1.0
 */
public class HttpResponse implements Response
{
    private int responseCode;
    private Map<String, String> headers;
    private String body;

    /**
     * Constructs a new HTTP response.
     *
     * @param responseCode The response code.
     */
    public HttpResponse(int responseCode)
    {
        this.responseCode = responseCode;
    }

    /**
     * Constructs a new HTTP response.
     *
     * @param responseCode The response code.
     * @param headers      The header map
     * @param body         The body.
     */
    public HttpResponse(int responseCode, Map<String, String> headers, String body)
    {
        this.responseCode = responseCode;
        this.headers = headers;
        this.body = body;
    }

    /**
     * Returns the response code.
     *
     * @return The response code.
     */
    public int getResponseCode()
    {
        return responseCode;
    }

    /**
     * Returns the header map.
     *
     * @return The header map
     */
    public Map<String, String> getHeaders()
    {
        return headers;
    }

    /**
     * Returns the body.
     *
     * @return The body.
     */
    public String getBody()
    {
        return body;
    }
}
