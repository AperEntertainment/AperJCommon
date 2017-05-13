/*
 * Copyright © 2017 AperEntertainment <aper.entertainment@gmail.com>
 *
 * This file is part of aperjcommon.
 *
 * Licensed under the MIT license. For more information,
 * see the LICENSE file.
 */

package com.aperentertainment.aperjcommon.connection;

import java.io.IOException;
import java.util.function.Consumer;

/**
 * <h1>RequestSender</h1>
 * An RequestSender is able to send a request. After processing the request a response is returned.
 *
 * @author AperEntertainment
 * @version 1.1.0
 * @since 1.1.0
 */
public abstract class RequestSender<S extends Response, Q extends Request>
{
    /**
     * Sends the request and returns the received response.
     *
     * @param request The request which will be send.
     * @return The received response.
     * @throws IOException If an error occurred.
     */
    public abstract S sendRequest(Q request) throws IOException;

    /**
     * Sends the request and returns the received response and execute different consumers.
     *
     * @param request The request which will be send.
     * @param success The consumer which will be execute if it succeed.
     * @param error   The consumer which will be execute if it failed.
     * @return The received response.
     */
    public S sendRequest(Q request, Consumer<S> success, Consumer<IOException> error)
    {
        S response = null;
        try
        {
            response = sendRequest(request);
            success.accept(response);
        }
        catch (IOException e)
        {
            error.accept(e);
        }
        return response;
    }
}
