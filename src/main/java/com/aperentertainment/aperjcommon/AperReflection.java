/*
 * Copyright © 2017 AperEntertainment
 *
 * This file is part of AperReflection.
 *
 * AperReflection is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * AperReflection is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with AperReflection.  If not, see <http://www.gnu.org/licenses/>.
 */

//
//                  A               /XXXXXXXXXxxxx
//                AX                \XXXXXXXXXXXXXXxx_
//               AXX                              *XXXxx
//              AXXX              xxxxXXXXXXxxx       *XXx
//              XXXX          xXXXXXXXXXXXXXXXXXXXx     *XXx
//              XXXX        xXXXXXXXXXXXXXXXXXXXXXXXx     xXx
//              XXXX      xXXXXXXXXXXXX/********\XXXXXx     Xx
//       A      XXXX    xXXXXXXXXX**               *XXXXx    Xx
//      AX      XXXXx  xXXXXXXXX*       XXXXXXXx     *XXXx    X
//      XX       XXX* xXXXXXXXX*  xxx   *XXXXXXXXx    *XXXx   X
//      XXx       X  xXXXXXXXXX  xXXX          *XXx     *XXx  V
//      *XXx        xXXXXXXXXXX   **             *XXx   *XXx
//       *XXxx      XXXXXXXXXXXx                  XXx    XXx
//        *XXXXx    *XXXXXXXXXXXx                 XXx    XXX
//         *XXXXXXx  XXXXXXXXXXXX                xXX*    XX*
//           *XXXXXx *XXXXXXXXXX*                XX*    xXX
//               ***   *XXXXXXX*                xX*     XX*
//                                             X*      xX*
//                                           xX*      xX*
//                                         xX*       xX*
//                                       ***       xX*    __
//                                               xX*     xXXx
//                                             xXX*    xXXX*
//                                          xXX**     XXX
//                               *XXXXXXXX***       xXXX*
//                                                xXX*
//                                           __xXX*
//                                     xXXXXXX**
//

package com.aperentertainment.aperjcommon;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Optional;

/**
 * <h1>AperReflection</h1>
 * Reflection class made by AperEntertainment.
 *
 * @author AperEntertainment
 * @version 1.1.0
 * @since 1.0.0
 */
public class AperReflection
{
    /**
     * Gets the class at the specified path.
     *
     * @param name Path to the class.
     * @return An optional value as the Class.
     */
    public static Optional<Class<?>> getClass(String name)
    {
        try
        {
            Class<?> clazz = Class.forName(name);
            return Optional.of(clazz);
        }
        catch (ClassNotFoundException e)
        {
            return Optional.empty();
        }
    }

    /**
     * Gets the field of a class with it's name. (Note: the field is declared)
     *
     * @param clazz Class where is the field.
     * @param name  The field's name.
     * @return An optional value of the field.
     */
    public static Optional<Field> getField(Class<?> clazz, String name)
    {
        return getField(clazz, name, true);
    }

    /**
     * Gets the field of a class with it's name.
     *
     * @param clazz    Class where is the field.
     * @param name     The field's name.
     * @param declared Whether the field is declared or not.
     * @return An optional value of the field.
     */
    public static Optional<Field> getField(Class<?> clazz, String name, boolean declared)
    {
        try
        {
            Field field;
            if (declared)
                field = clazz.getDeclaredField(name);
            else
                field = clazz.getField(name);
            return Optional.of(field);
        }
        catch (NoSuchFieldException e)
        {
            return Optional.empty();
        }
    }

    /**
     * Gets the declared method of a class by the name and arguments.
     *
     * @param clazz     Class where is the method.
     * @param name      The name of the method.
     * @param arguments The classes of arguments.
     * @return An optional value as the method.
     */
    public static Optional<Method> getMethod(Class<?> clazz, String name, Class<?>... arguments)
    {
        return getMethod(clazz, name, true, arguments);
    }

    /**
     * Gets the method of a class by the name and arguments.
     *
     * @param clazz     Class where is the method.
     * @param name      The name of the method.
     * @param declared  Whether the method is declared or not.
     * @param arguments The classes of arguments.
     * @return An optional value as the method.
     */
    public static Optional<Method> getMethod(Class<?> clazz, String name, boolean declared, Class<?>... arguments)
    {
        try
        {
            Method method;
            if (declared)
                method = clazz.getDeclaredMethod(name, arguments);
            else method = clazz.getMethod(name, arguments);
            return Optional.of(method);
        }
        catch (NoSuchMethodException e)
        {
            return Optional.empty();
        }
    }
}
