/*
 * $Id: ResourceUtil.java,v 1.1 2005-10-16 15:51:06 a-pi Exp $
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

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;

/**
 * @author Sebastian Hasait (hasait at web.de)
 * @version $Revision: 1.1 $
 */
public final class ResourceUtil {
    private ResourceUtil() {
        super();
    }

    public static String readFile(IFile file) throws IOException, CoreException {
        InputStream fileContents = file.getContents();
        Reader fileContentsReader = new InputStreamReader(fileContents, file
                .getCharset());
        String contents = IOUtil.readAll(fileContentsReader);
        fileContentsReader.close();
        fileContents.close();
        return contents;
    }

    public static void writeFile(IFile file, String contents)
            throws CoreException {
        InputStream source = new ByteArrayInputStream(contents.getBytes());
        file.setContents(source, false, true, null);
    }

    public static IFile getRelativeFile(IContainer relativeBase, IPath path) {
        if (path.isAbsolute()) {
            return ResourcesPlugin.getWorkspace().getRoot().getFile(path);
        }
        return ResourcesPlugin.getWorkspace().getRoot().getFile(
                relativeBase.getFullPath().append(path));

    }

    public static IFile getRelativeFile(IContainer relativeBase, String path) {
        return getRelativeFile(relativeBase, new Path(path));
    }

    public static IFile getRelativeFile(IFile relativeBase, String path) {
        return getRelativeFile(relativeBase.getParent(), new Path(path));
    }

    public static IFile getRelativeFile(IFile relativeBase, IPath path) {
        return getRelativeFile(relativeBase.getParent(), path);
    }
}