/*
 * $Id: IOUtil.java,v 1.2 2005-10-16 15:51:06 a-pi Exp $
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
package de.hasait.ccg.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.io.StringWriter;
import java.nio.ByteBuffer;

/**
 * @author Sebastian Hasait (hasait at web.de)
 * @version $Revision: 1.2 $
 */
public final class IOUtil {
    private IOUtil() {
        super();
    }

    private static final int LONG_LEN = 8;

    public static long readLong(InputStream input) throws IOException {
        byte[] longBytes = new byte[LONG_LEN];
        int r = input.read(longBytes, 0, LONG_LEN);
        if (r != LONG_LEN) {
            throw new IOException("Bytes missing: read " + r + ", expected "
                    + LONG_LEN);
        }
        return ByteBuffer.wrap(longBytes).getLong();
    }

    public static String readAll(Reader reader) throws IOException {
        StringWriter stringWriter = new StringWriter();
        char[] cbuf = new char[1024];
        int cread;
        do {
            cread = reader.read(cbuf);
            if (cread != -1) {
                stringWriter.write(cbuf, 0, cread);
            }
        } while (cread != -1);
        return stringWriter.getBuffer().toString();
    }
}