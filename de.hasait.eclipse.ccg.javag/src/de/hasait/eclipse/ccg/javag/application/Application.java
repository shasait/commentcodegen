package de.hasait.eclipse.ccg.javag.application;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;

import de.hasait.eclipse.ccg.javag.application.model.Model;
import de.hasait.eclipse.ccg.javag.application.view.View;
import de.hasait.eclipse.common.resource.XFile;
import de.hasait.eclipse.common.resource.XFolder;
import de.hasait.eclipse.common.xml.XElement;

/**
 * @author Sebastian Hasait (hasait at web.de)
 * @version $Revision: 1.3 $
 * @since 13.12.2006
 */
public class Application {
	private final XFile _sourceFile;

	private final XFolder _targetBaseFolder;

	private final String _package;

	private final List _cuContainers = new ArrayList();

	private final Map _cuContainersByPackage = new HashMap();

	/**
	 * Constructor.
	 */
	public Application(final XFile pSourceFile, final XFolder pTargetBaseFolder, final XElement pConfigElement) {
		super();

		_sourceFile = pSourceFile;
		_targetBaseFolder = pTargetBaseFolder;

		_package = pConfigElement.getRequiredAttribute("package");

		XElement[] vModelElements = pConfigElement.getChildElements("model");
		for (int vModelElementsI = 0; vModelElementsI < vModelElements.length; vModelElementsI++) {
			XElement vModelElement = vModelElements[vModelElementsI];
			Model vModel = new Model(this, vModelElement);
			addCuContainer(vModel);
		}

		XElement[] vViewElements = pConfigElement.getChildElements("view");
		for (int vViewElementsI = 0; vViewElementsI < vViewElements.length; vViewElementsI++) {
			XElement vViewElement = vViewElements[vViewElementsI];
			View vView = new View(this, vViewElement);
			addCuContainer(vView);
		}
	}

	/**
	 * @return The value of property sourceFile.
	 */
	public final XFile getSourceFile() {
		return _sourceFile;
	}

	/**
	 * @return The value of property targetBaseFolder.
	 */
	public final XFolder getTargetBaseFolder() {
		return _targetBaseFolder;
	}

	/**
	 * @return the package
	 */
	public final String getPackage() {
		return _package;
	}

	protected final void addCuContainer(final AbstractCuContainer pCuContainer) {
		if (_cuContainersByPackage.containsKey(pCuContainer.getPackage())) {
			throw new IllegalArgumentException("duplicate package " + pCuContainer.getPackage());
		}
		_cuContainers.add(pCuContainer);
		_cuContainersByPackage.put(pCuContainer.getPackage(), pCuContainer);
	}

	public final Iterator cuContainerIterator() {
		return _cuContainers.iterator();
	}

	public final AbstractCompilationUnit findCompilationUnit(final String pQualifiedName) {
		int vDotIndex = pQualifiedName.lastIndexOf('.');
		if (vDotIndex < 1) {
			throw new IllegalArgumentException("Not a qualified name: " + pQualifiedName);
		}
		String vPackage = pQualifiedName.substring(0, vDotIndex);
		AbstractCuContainer vCuContainer = (AbstractCuContainer) _cuContainersByPackage.get(vPackage);
		if (vCuContainer != null) {
			String vName = pQualifiedName.substring(vDotIndex + 1);
			return vCuContainer.findCompilationUnitByName(vName);
		}
		return null;
	}

	public final void resolve(final IProgressMonitor pMonitor) {
		for (Iterator vCuContainerI = cuContainerIterator(); vCuContainerI.hasNext();) {
			AbstractCuContainer vCuContainer = (AbstractCuContainer) vCuContainerI.next();
			vCuContainer.resolve(pMonitor);
		}
	}

	public final void validate(final IProgressMonitor pMonitor) {
		for (Iterator vCuContainerI = cuContainerIterator(); vCuContainerI.hasNext();) {
			AbstractCuContainer vCuContainer = (AbstractCuContainer) vCuContainerI.next();
			vCuContainer.validate(pMonitor);
		}
	}

	public final void write(final IProgressMonitor pMonitor) throws CoreException {
		for (Iterator vCuContainerI = cuContainerIterator(); vCuContainerI.hasNext();) {
			AbstractCuContainer vCuContainer = (AbstractCuContainer) vCuContainerI.next();
			vCuContainer.write(pMonitor);
		}
	}
}
