package de.hasait.eclipse.ccg.javag.application.model;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;

import de.hasait.eclipse.ccg.javag.application.Application;
import de.hasait.eclipse.common.StringUtil;
import de.hasait.eclipse.common.resource.XFolder;
import de.hasait.eclipse.common.xml.XElement;

/**
 * @author Sebastian Hasait (hasait at web.de)
 * @version $Revision: 1.2 $
 * @since 13.12.2006
 */
public class Model {
	private final Application _application;

	private final String _name;

	private final String _package;

	private final XFolder _targetFolder;

	private final java.util.List _bean = new java.util.ArrayList();

	private final Map _beanByName = new HashMap();

	/**
	 * Constructor.
	 */
	public Model(final Application pApplication, final XElement pConfigElement) {
		super();

		_application = pApplication;

		_name = pConfigElement.getRequiredAttribute("name");
		_package = pConfigElement.getRequiredAttribute("package");

		String vPackagePath = StringUtil.replace(_package, ".", "/");
		_targetFolder = _application.getTargetBaseFolder().getFolder(vPackagePath);

		XElement[] vBeanElements = pConfigElement.getChildElements("bean");
		for (int vBeanElementsI = 0; vBeanElementsI < vBeanElements.length; vBeanElementsI++) {
			XElement vBeanElement = vBeanElements[vBeanElementsI];
			Bean vBean = new Bean(this, vBeanElement);
			_bean.add(vBean);
			_beanByName.put(vBean.getName(), vBean);
		}
	}

	/**
	 * @return The value of property application.
	 */
	public final Application getApplication() {
		return _application;
	}

	/**
    * @return the name
    */
   public final String getName() {
   	return _name;
   }

	/**
	 * @return The value of property package.
	 */
	public final String getPackage() {
		return _package;
	}

	/**
	 * @return the targetFolder
	 */
	public final XFolder getTargetFolder() {
		return _targetFolder;
	}

	/**
	 * @return An {@link java.util.Iterator} for all values of property bean.
	 * @see java.util.List#iterator()
	 */
	public final java.util.Iterator beanIterator() {
		return _bean.iterator();
	}

	public final Bean findBean(final String pType) {
		if (pType.indexOf('.') >= 0) {
			return getApplication().findBean(pType);
		}
		return (Bean) _beanByName.get(pType);
	}

	public final void resolve(final IProgressMonitor pMonitor) {
		for (Iterator beanI = beanIterator(); beanI.hasNext();) {
			Bean bean = (Bean) beanI.next();
			bean.resolve(pMonitor);
		}
	}

	public final void validate(final IProgressMonitor pMonitor) {
		for (Iterator beanI = beanIterator(); beanI.hasNext();) {
			Bean bean = (Bean) beanI.next();
			bean.validate(pMonitor);
		}
	}

	public final void write(final IProgressMonitor pMonitor) throws CoreException {
		pMonitor.subTask("write Model " + getPackage());
		// Set files = new HashSet();
		for (Iterator beanI = beanIterator(); beanI.hasNext();) {
			Bean bean = (Bean) beanI.next();
			bean.write(pMonitor);
			// files.add(file);
		}
		// monitor.subTask("clean Package " + _package);
		// XResource[] members = _targetFolder.members();
		// for (int membersI = 0; membersI < members.length; membersI++) {
		// XResource member = members[membersI];
		// if (member.isFile() && member.isDerived() && !files.contains(member)) {
		// member.delete(false, monitor);
		// }
		// }
	}
}
