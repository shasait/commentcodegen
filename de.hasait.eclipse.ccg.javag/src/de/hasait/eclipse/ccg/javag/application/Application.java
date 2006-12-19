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
import de.hasait.eclipse.ccg.javag.application.regelsprache.Regelsprache;
import de.hasait.eclipse.common.resource.XFile;
import de.hasait.eclipse.common.resource.XFolder;
import de.hasait.eclipse.common.xml.XElement;

/**
 * @author Sebastian Hasait (hasait at web.de)
 * @version $Revision: 1.1 $
 * @since 13.12.2006
 */
public class Application {
	private final XFile _sourceFile;

	private final XFolder _targetBaseFolder;

	private final List _model = new ArrayList();

	private final Map _modelByPackage = new HashMap();

	private final List _regelsprache = new ArrayList();

	private final Map _regelspracheByPackage = new HashMap();

	/**
	 * Constructor.
	 */
	public Application(final XFile pSourceFile, final XFolder pTargetBaseFolder, final XElement pConfigElement) {
		super();

		_sourceFile = pSourceFile;
		_targetBaseFolder = pTargetBaseFolder;

		XElement[] vModelElements = pConfigElement.getChildElements("model");
		for (int vModelElementsI = 0; vModelElementsI < vModelElements.length; vModelElementsI++) {
			XElement vModelElement = vModelElements[vModelElementsI];
			Model vModel = new Model(this, vModelElement);
			String vModelPackage = vModel.getPackage();
			if (_modelByPackage.containsKey(vModelPackage)) {
				throw new IllegalArgumentException("duplicate package: " + vModelPackage);
			}
			if (_regelspracheByPackage.containsKey(vModelPackage)) {
				throw new IllegalArgumentException("duplicate package: " + vModelPackage);
			}
			_model.add(vModel);
			_modelByPackage.put(vModelPackage, vModel);
		}

		XElement[] vRegelspracheElements = pConfigElement.getChildElements("regelsprache");
		for (int vRegelspracheElementsI = 0; vRegelspracheElementsI < vRegelspracheElements.length; vRegelspracheElementsI++) {
			XElement vRegelspracheElement = vRegelspracheElements[vRegelspracheElementsI];
			Regelsprache vRegelsprache = new Regelsprache(this, vRegelspracheElement);
			String vRegelsprachePackage = vRegelsprache.getPackage();
			if (_modelByPackage.containsKey(vRegelsprachePackage)) {
				throw new IllegalArgumentException("duplicate package: " + vRegelsprachePackage);
			}
			if (_regelspracheByPackage.containsKey(vRegelsprachePackage)) {
				throw new IllegalArgumentException("duplicate package: " + vRegelsprachePackage);
			}
			_regelsprache.add(vRegelsprache);
			_regelspracheByPackage.put(vRegelsprachePackage, vRegelsprache);
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
	 * @return An {@link java.util.Iterator} for all values of property model.
	 * @see java.util.List#iterator()
	 */
	public final Iterator modelIterator() {
		return _model.iterator();
	}

	public final Bean findBean(final String pType) {
		int vDotIndex = pType.lastIndexOf('.');
		if (vDotIndex < 0) {
			return null;
		}
		String vPackage = pType.substring(0, vDotIndex);
		Model vModel = (Model) _modelByPackage.get(vPackage);
		if (vModel == null) {
			return null;
		}
		String vBeanName = pType.substring(vDotIndex + 1);
		return vModel.findBean(vBeanName);
	}

	public final void resolve(final IProgressMonitor pMonitor) {
		for (Iterator vModelI = modelIterator(); vModelI.hasNext();) {
			Model vModel = (Model) vModelI.next();
			vModel.resolve(pMonitor);
		}
	}

	public final void validate(final IProgressMonitor pMonitor) {
		for (Iterator vModelI = modelIterator(); vModelI.hasNext();) {
			Model vModel = (Model) vModelI.next();
			vModel.validate(pMonitor);
		}
	}

	public final void write(final IProgressMonitor pMonitor) throws CoreException {
		for (Iterator vModelI = modelIterator(); vModelI.hasNext();) {
			Model vModel = (Model) vModelI.next();
			vModel.write(pMonitor);
		}
	}
}
