/*
 * $Id: ObjectUtil.java,v 1.1 2007-01-06 00:45:04 concentus Exp $
 * 
 * Copyright 2005 Sebastian Hasait
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package de.hasait.eclipse.common;

/**
 * @author Sebastian Hasait (hasait at web.de)
 * @version $Revision: 1.1 $
 */
public final class ObjectUtil {
    private ObjectUtil() {
        super();
    }

    /**
     * Compare objects with null-handling.
     */
    public static boolean equals(Object a, Object b) {
        if (a == b) {
            return true;
        }
        // a!=b
        if (a != null) {
            if (b != null) {
                return a.equals(b);
            }
        }
        // a==null || b==null => the other cannot be also null because of a!=b
        return false;
    }
}