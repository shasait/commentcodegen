/*
 * $Id: NatureUtil.java,v 1.1 2005-10-06 19:28:49 a-pi Exp $
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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.runtime.CoreException;

/**
 * @author Sebastian Hasait (hasait at web.de)
 * @version $Revision: 1.1 $
 */
public final class NatureUtil {
    private NatureUtil() {
        super();
    }

    public static boolean addNature(IProject project, String nature)
            throws CoreException {
        // check for nature
        List natures = getNatures(project);
        if (natures.contains(nature)) {
            return false;
        }
        // add nature
        List newNatures = new ArrayList(natures);
        newNatures.add(nature);
        setNatures(project, newNatures);
        return true;
    }

    public static boolean removeNature(IProject project, String nature)
            throws CoreException {
        // check for nature
        List natures = getNatures(project);
        if (!natures.contains(nature)) {
            return false;
        }
        // remove nature
        List newNatures = new ArrayList(natures);
        newNatures.remove(nature);
        setNatures(project, newNatures);
        return true;
    }

    public static List getNatures(IProject project) throws CoreException {
        IProjectDescription description = project.getDescription();
        String[] naturesArray = description.getNatureIds();
        return Arrays.asList(naturesArray);
    }

    public static void setNatures(IProject project, List natures)
            throws CoreException {
        IProjectDescription description = project.getDescription();
        String[] naturesArray = (String[]) natures.toArray(new String[natures
                .size()]);
        description.setNatureIds(naturesArray);
        project.setDescription(description, null);
    }
}