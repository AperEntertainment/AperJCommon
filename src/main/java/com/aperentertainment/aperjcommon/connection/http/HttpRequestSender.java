/*
 * Copyright © 2017 AperEntertainment <aper.entertainment@gmail.com>
 *
 * This file is part of aperjcommon.
 *
 * Licensed under the MIT license. For more information,
 * see the LICENSE file.
 */

package com.aperentertainment.aperjcommon.connection.http;

import com.aperentertainment.aperjcommon.connection.RequestSender;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * <h1>HttpRequestSender</h1>
 * A HttpRequestSender is able to send a HTTP request. After processing the HTTP request a HTTP response is returned.
 *
 * @author AperEntertainment
 * @version 1.0.0
 */
public class HttpRequestSender extends RequestSender<HttpResponse, HttpRequest>
{
    private String sendMethod;
    private int timeout;

    public HttpRequestSender()
    {
        this("GET", 10000);
    }

    public HttpRequestSender(String sendMethod, int timeout)
    {
        this.sendMethod = sendMethod;
        this.timeout = timeout;
    }

    @Override
    public HttpResponse sendRequest(HttpRequest request) throws IOException
    {
        HttpURLConnection connection = createConnection(request);
        return send(connection);
    }

    private HttpURLConnection createConnection(HttpRequest request) throws IOException
    {
        URL url = new URL(request.getUrl());
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        connection.setConnectTimeout(timeout);
        connection.setReadTimeout(timeout);

        connection.setRequestMethod(sendMethod);

        return connection;
    }

    private HttpResponse send(HttpURLConnection connection) throws IOException
    {
        connection.connect();

        if (connection.getResponseCode() != 200)
            return new HttpResponse(connection.getResponseCode());

        Map<String, String> headers = new HashMap<>();
        connection.getHeaderFields().forEach((key, value) -> headers.put(key, value.get(0)));

        String body;
        InputStream iStream = null;
        try
        {
            iStream = connection.getInputStream();

            String encoding = connection.getContentEncoding();
            encoding = encoding == null ? "UTF-8" : encoding;

            body = IOUtils.toString(iStream, encoding);
        }
        finally
        {
            if (iStream != null)
            {
                iStream.close();
            }
        }

        if (body == null) {
            throw new IOException("Unparseable response body! \n {" + body + "}");
        }

        return new HttpResponse(connection.getResponseCode(), headers, body);
    }
}
