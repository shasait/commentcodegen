package de.hasait.eclipse.ccg.javag.application;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;

import de.hasait.eclipse.ccg.javag.application.model.Bean;
import de.hasait.eclipse.ccg.javag.application.model.Model;
import de.hasait.eclipse.ccg.javag.application.view.Dialog;
import de.hasait.eclipse.ccg.javag.application.view.View;
import de.hasait.eclipse.common.resource.XFile;
import de.hasait.eclipse.common.resource.XFolder;
import de.hasait.eclipse.common.xml.XElement;

/**
 * @author Sebastian Hasait (hasait at web.de)
 * @version $Revision: 1.2 $
 * @since 13.12.2006
 */
public class Application {
	private final XFile _sourceFile;

	private final XFolder _targetBaseFolder;

	private final String _package;

	private final List _models = new ArrayList();

	private final List _views = new ArrayList();

	private final Map _objectByPackage = new HashMap();

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
			String vModelPackage = vModel.getPackage();
			if (_objectByPackage.containsKey(vModelPackage)) {
				throw new IllegalArgumentException("duplicate package: " + vModelPackage);
			}
			_models.add(vModel);
			_objectByPackage.put(vModelPackage, vModel);
		}

		XElement[] vViewElements = pConfigElement.getChildElements("view");
		for (int vViewElementsI = 0; vViewElementsI < vViewElements.length; vViewElementsI++) {
			XElement vViewElement = vViewElements[vViewElementsI];
			View vView = new View(this, vViewElement);
			String vViewPackage = vView.getPackage();
			if (_objectByPackage.containsKey(vViewPackage)) {
				throw new IllegalArgumentException("duplicate package: " + vViewPackage);
			}
			_views.add(vView);
			_objectByPackage.put(vViewPackage, vView);
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

	public final Iterator modelIterator() {
		return _models.iterator();
	}

	public final Iterator viewIterator() {
		return _views.iterator();
	}

	public final Bean findBean(final String pQualifiedBeanName) {
		int vDotIndex = pQualifiedBeanName.lastIndexOf('.');
		if (vDotIndex < 0) {
			return null;
		}
		String vPackage = pQualifiedBeanName.substring(0, vDotIndex);
		Object vObject = _objectByPackage.get(vPackage);
		if (vObject != null && vObject instanceof Model) {
			String vBeanName = pQualifiedBeanName.substring(vDotIndex + 1);
			return ((Model) vObject).findBean(vBeanName);
		}
		return null;
	}

	public final Dialog findDialog(final String pQualifiedDialogName) {
		int vDotIndex = pQualifiedDialogName.lastIndexOf('.');
		if (vDotIndex < 0) {
			return null;
		}
		String vPackage = pQualifiedDialogName.substring(0, vDotIndex);
		Object vObject = _objectByPackage.get(vPackage);
		if (vObject != null && vObject instanceof View) {
			String vDialogName = pQualifiedDialogName.substring(vDotIndex + 1);
			return ((View) vObject).findDialog(vDialogName);
		}
		return null;
	}

	public final void resolve(final IProgressMonitor pMonitor) {
		for (Iterator vModelI = modelIterator(); vModelI.hasNext();) {
			Model vModel = (Model) vModelI.next();
			vModel.resolve(pMonitor);
		}

		for (Iterator vViewI = viewIterator(); vViewI.hasNext();) {
			View vView = (View) vViewI.next();
			vView.resolve(pMonitor);
		}
	}

	public final void validate(final IProgressMonitor pMonitor) {
		for (Iterator vModelI = modelIterator(); vModelI.hasNext();) {
			Model vModel = (Model) vModelI.next();
			vModel.validate(pMonitor);
		}

		for (Iterator vViewI = viewIterator(); vViewI.hasNext();) {
			View vView = (View) vViewI.next();
			vView.validate(pMonitor);
		}
	}

	public final void write(final IProgressMonitor pMonitor) throws CoreException {
		for (Iterator vModelI = modelIterator(); vModelI.hasNext();) {
			Model vModel = (Model) vModelI.next();
			vModel.write(pMonitor);
		}

		for (Iterator vViewI = viewIterator(); vViewI.hasNext();) {
			View vView = (View) vViewI.next();
			vView.write(pMonitor);
		}
	}
}
