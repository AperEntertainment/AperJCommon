/*
 * Copyright © 2017 AperEntertainment
 *
 * This file is part of aperjcommon.
 *
 * aperjcommon is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * aperjcommon is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with aperjcommon.  If not, see <http://www.gnu.org/licenses/>.
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
