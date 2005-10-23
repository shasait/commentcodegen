/*
 * $Id: OgnlGenerator.java,v 1.1 2005-10-23 22:21:00 a-pi Exp $
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

import java.util.HashMap;
import java.util.Map;

import ognl.Ognl;

import org.apache.bsf.BSFManager;
import org.eclipse.core.resources.IFile;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.w3c.dom.Element;

import de.hasait.ccg.generator.ICcgGenerator;
import de.hasait.ccg.generator.ICcgGeneratorLookup;
import de.hasait.ccg.parser.ICcgComment;
import de.hasait.ccg.util.ResourceUtil;
import de.hasait.ccg.util.StringUtil;
import de.hasait.ccg.util.Util;
import de.hasait.ccg.util.XmlUtil;

/**
 * @author Sebastian Hasait (hasait at web.de)
 * @version $Revision: 1.1 $
 */
public class OgnlGenerator implements ICcgGenerator {
    private final String[] KEYWORDS = new String[] { "JavaOgnl" };

    public String getDescription() {
        return "Delegates the generation to Ognl";
    }

    public String[] getTagnames() {
        return KEYWORDS;
    }

    public String generate(final Element element,
            final ICcgGeneratorLookup ccgGeneratorLookup, final Map context,
            final ICcgComment ccgComment, final IFile file) throws Exception {
        String ognlScriptFilePathS = XmlUtil.getAttributeString(element,
                "file", null);
        String ognlScript;
        if (ognlScriptFilePathS != null) {
            // read script from file
            IFile bsfScriptFile = ResourceUtil.getRelativeFile(file,
                    ognlScriptFilePathS);
            ognlScript = ResourceUtil.readFile(bsfScriptFile);
        } else {
            // get script from element's body
            ognlScript = element.getTextContent();
        }
        // parse source file
        IJavaElement javaElement = JavaCore.create(file);
        if (javaElement == null || !(javaElement instanceof ICompilationUnit)) {
            throw new IllegalArgumentException("Not a Java source file");
        }
        CompilationUnit compilationUnit = AST.parseCompilationUnit(
                (ICompilationUnit) javaElement, true);
        // run script
        Map ognlContext = new HashMap();
        ognlContext.put("e", element);
        ognlContext.put("cu", compilationUnit);
        String result = StringUtil.toString(Ognl.getValue(ognlScript,
                ognlContext, compilationUnit), "");
        return "\n\t" + result + "\n\t";
    }
}
