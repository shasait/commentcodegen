/*
 * $Id: BsfExceptionUtil.java,v 1.2 2007-06-22 08:36:20 concentus Exp $
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

package de.hasait.eclipse.common.bsf;

import org.apache.bsf.BSFException;

/**
 * 
 * @author Sebastian Hasait (hasait at web.de)
 * @version $Revision: 1.2 $
 * @since 02.12.2006
 */
public final class BsfExceptionUtil {
	private BsfExceptionUtil() {
		super();
	}

	public static Exception handleException(Exception exception) {
		try {
			throw exception;
			// } catch (RaiseException re) {
			// RubyException rubyException = re.getException();
			// ByteArrayOutputStream bos = new ByteArrayOutputStream();
			// PrintStream pos = new PrintStream(bos);
			// pos.println(StringUtil.toString(rubyException.message));
			// rubyException.printBacktrace(pos);
			// return new Exception(bos.toString(), re);
		} catch (BSFException e) {
			Throwable t = e.getTargetException();
			if (t instanceof Exception) {
				return handleException((Exception) t);
			}
			return e;
		} catch (Exception e) {
			return e;
		}
	}
}
