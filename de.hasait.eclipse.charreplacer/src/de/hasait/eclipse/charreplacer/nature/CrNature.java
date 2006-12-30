/*
 * $Id: CrNature.java,v 1.1 2006-12-30 16:51:00 concentus Exp $
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
package de.hasait.eclipse.charreplacer.nature;

import org.eclipse.core.resources.ICommand;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IProjectNature;
import org.eclipse.core.runtime.CoreException;

import de.hasait.eclipse.charreplacer.builder.CrBuilder;

/**
 * @author Sebastian Hasait (hasait at web.de)
 * @version $Revision: 1.1 $
 */
public class CrNature implements IProjectNature {

    /**
     * ID of this project nature
     */
    public static final String NATURE_ID = "de.hasait.eclipse.charreplacer.crNature";

    private IProject _project;

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.core.resources.IProjectNature#configure()
     */
    public void configure() throws CoreException {
        IProjectDescription desc = _project.getDescription();
        ICommand[] commands = desc.getBuildSpec();

        for (int i = 0; i < commands.length; ++i) {
            if (commands[i].getBuilderName().equals(CrBuilder.BUILDER_ID)) {
                //If exists nothing to do
                return;
            }
        }

        // Add the builder at first
        ICommand[] newCommands = new ICommand[commands.length + 1];
        System.arraycopy(commands, 0, newCommands, 1, commands.length);
        ICommand command = desc.newCommand();
        command.setBuilderName(CrBuilder.BUILDER_ID);
        newCommands[0] = command;
        desc.setBuildSpec(newCommands);
        _project.setDescription(desc, null);
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.core.resources.IProjectNature#deconfigure()
     */
    public void deconfigure() throws CoreException {
        IProjectDescription description = getProject().getDescription();
        ICommand[] commands = description.getBuildSpec();
        for (int i = 0; i < commands.length; ++i) {
            if (commands[i].getBuilderName().equals(CrBuilder.BUILDER_ID)) {
                ICommand[] newCommands = new ICommand[commands.length - 1];
                System.arraycopy(commands, 0, newCommands, 0, i);
                System.arraycopy(commands, i + 1, newCommands, i,
                        commands.length - i - 1);
                description.setBuildSpec(newCommands);
                return;
            }
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.core.resources.IProjectNature#getProject()
     */
    public IProject getProject() {
        return _project;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.core.resources.IProjectNature#setProject(org.eclipse.core.resources.IProject)
     */
    public void setProject(IProject project) {
        _project = project;
    }
}
