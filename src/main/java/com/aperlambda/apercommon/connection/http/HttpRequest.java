/*
 * Copyright © 2017 AperEntertainment <aper.entertainment@gmail.com>
 *
 * This file is part of aperjcommon.
 *
 * Licensed under the MIT license. For more information,
 * see the LICENSE file.
 */

package com.aperlambda.apercommon.connection.http;

import com.aperlambda.apercommon.connection.Request;

/**
 * <h1>HttpRequest</h1>
 * This class represents a HTTP request.
 *
 * @author AperLambda
 * @version 1.1.1
 * @since 1.1.0
 */
public class HttpRequest implements Request
{
    private String url;

    /**
     * Constructs a new HTTP request object.
     *
     * @param url The URL.
     */
    public HttpRequest(String url)
    {
        this.url = url;
    }

    /**
     * Returns the URL.
     *
     * @return The URL.
     */
    public String getUrl()
    {
        return url;
    }
}
