/*
 * $Id: EventSupportGenerator.java,v 1.2 2005-09-02 14:20:45 a-pi Exp $
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
package de.hasait.ccg.javag.pattern;

import de.hasait.ccg.generator.CcgJetGeneratorAdapter;

/**
 * @author Sebastian Hasait (hasait at web.de)
 * @version $Revision: 1.2 $
 */
public class EventSupportGenerator extends CcgJetGeneratorAdapter {
    public EventSupportGenerator() {
        super("EventSupport", new String[] { "eventsupport" },
                new EventSupportJetGenerator());
    }
}
