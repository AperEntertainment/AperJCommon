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

package com.aperentertainment.aperjcommon.connection.http;

import com.aperentertainment.aperjcommon.connection.Request;

/**
 * <h1>HttpRequest</h1>
 * This class represents a HTTP request.
 *
 * @author AperEntertainment
 * @version 1.1.0
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
