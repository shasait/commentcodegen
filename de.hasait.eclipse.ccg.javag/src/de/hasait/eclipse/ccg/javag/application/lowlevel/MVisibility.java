/*
 * $Id: MVisibility.java,v 1.1 2006-12-19 15:06:02 concentus Exp $
 * 
 * Copyright 2006 Sebastian Hasait
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

package de.hasait.eclipse.ccg.javag.application.lowlevel;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author Sebastian Hasait (hasait at web.de)
 * @version $Revision: 1.1 $
 * @since 18.12.2006
 */
public final class MVisibility {
	private static final Map INSTANCES_BY_ID = new HashMap();

	private final String _id;

	private MVisibility(final String id) {
		super();
		_id = id;
		INSTANCES_BY_ID.put(_id, this);
	}

	public static final MVisibility PUBLIC = new MVisibility("public");

	public static final MVisibility PROTECTED = new MVisibility("protected");

	public static final MVisibility PRIVATE = new MVisibility("private");

	public static final MVisibility FRIEND = new MVisibility("");

	public static MVisibility get(String id) {
		if (INSTANCES_BY_ID.containsKey(id)) {
			return (MVisibility) INSTANCES_BY_ID.get(id);
		}
		throw new IllegalArgumentException("invalid id: " + id);
	}
}
