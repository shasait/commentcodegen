package de.hasait.eclipse.ccg.javag.application.regelsprache;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;

import de.hasait.eclipse.ccg.javag.application.Application;
import de.hasait.eclipse.ccg.javag.application.model.Bean;
import de.hasait.eclipse.common.StringUtil;
import de.hasait.eclipse.common.resource.XFolder;
import de.hasait.eclipse.common.xml.XElement;

/**
 * @author Sebastian Hasait (hasait at web.de)
 * @version $Revision: 1.1 $
 * @since 13.12.2006
 */
public class Regelsprache {
	private final Application _application;

	private final String _beanName;

	private Bean _bean;

	private final String _package;

	private final XFolder _targetFolder;

	/**
	 * Constructor.
	 */
	public Regelsprache(final Application pApplication, final XElement pConfigElement) {
		super();

		_application = pApplication;

		_beanName = pConfigElement.getRequiredAttribute("bean");
		_package = pConfigElement.getRequiredAttribute("package");

		String vPackagePath = StringUtil.replace(_package, ".", "/");
		_targetFolder = _application.getTargetBaseFolder().getFolder(vPackagePath);
	}

	/**
	 * @return The value of property application.
	 */
	public final Application getApplication() {
		return _application;
	}

	/**
	 * @return the beanName
	 */
	public final String getBeanName() {
		return _beanName;
	}

	/**
	 * @return the bean
	 */
	public final Bean getBean() {
		return _bean;
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

	public final void resolve(final IProgressMonitor pMonitor) {
		_bean = getApplication().findBean(getBeanName());
		if (_bean == null) {
			throw new IllegalArgumentException("beanName " + getBeanName() + " does not exist");
		}
	}

	public final void validate(final IProgressMonitor pMonitor) {
	}

	public final void write(final IProgressMonitor pMonitor) throws CoreException {
		pMonitor.subTask("write Model " + getPackage());
	}
}
