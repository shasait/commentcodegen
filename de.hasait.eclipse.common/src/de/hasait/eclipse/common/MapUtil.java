/*
 * $Id: MapUtil.java,v 1.1 2007-01-06 00:44:42 concentus Exp $
 * 
 * Copyright 2007 Sebastian Hasait
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

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 
 * @author Sebastian Hasait (hasait at web.de)
 * @version $Revision: 1.1 $
 * @since 05.01.2007
 */
public final class MapUtil {
	private MapUtil() {
		super();
	}

	public static void mapSetAdd(final Map pMap, final Object pKey, final Object pValue) {
		Set vSet;
		if (!pMap.containsKey(pKey)) {
			vSet = new HashSet();
			pMap.put(pKey, vSet);
		} else {
			vSet = (Set) pMap.get(pKey);
		}
		vSet.add(pValue);
	}

	public static void mapSetRemove(final Map pMap, final Object pKey, final Object pValue) {
		if (!pMap.containsKey(pKey)) {
			return;
		}
		Set vSet = (Set) pMap.get(pKey);
		vSet.remove(pValue);
	}

	public static void mapListAdd(final Map pMap, final Object pKey, final Object pValue) {
		List vList;
		if (!pMap.containsKey(pKey)) {
			vList = new ArrayList();
			pMap.put(pKey, vList);
		} else {
			vList = (List) pMap.get(pKey);
		}
		vList.add(pValue);
	}

	public static void mapListRemove(final Map pMap, final Object pKey, final Object pValue) {
		if (!pMap.containsKey(pKey)) {
			return;
		}
		List vList = (List) pMap.get(pKey);
		vList.remove(pValue);
	}
}
