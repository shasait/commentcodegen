package de.hasait.eclipse.ccg.javag.application.model;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;

import de.hasait.eclipse.common.resource.XFile;
import de.hasait.eclipse.common.resource.XFolder;

/**
 * @author Sebastian Hasait (hasait at web.de)
 * @version $Revision: 1.1 $
 * @since 13.12.2006
 */
public class Application {
	/**
	 * Constructor.
	 */
	public Application(final XFile sourceFile, final XFolder targetBaseFolder) {
		super();
		
		_sourceFile = sourceFile;
		_targetBaseFolder = targetBaseFolder;
	}

	/** Value of property sourceFile. */
	private final de.hasait.eclipse.common.resource.XFile _sourceFile;

	/**
	 * Return the value of property sourceFile.
	 * 
	 * @return The value of property sourceFile.
	 */
	public final de.hasait.eclipse.common.resource.XFile getSourceFile() {
		return _sourceFile;
	}

	/** Value of property targetBaseFolder. */
	private final de.hasait.eclipse.common.resource.XFolder _targetBaseFolder;

	/**
	 * Return the value of property targetBaseFolder.
	 * 
	 * @return The value of property targetBaseFolder.
	 */
	public final de.hasait.eclipse.common.resource.XFolder getTargetBaseFolder() {
		return _targetBaseFolder;
	}

	/** Value of property model. */
	private final java.util.List _model = new java.util.ArrayList();

	private final Map _modelByPackage = new HashMap();

	/**
	 * The value of property model at the specified index.
	 * 
	 * @param index
	 *           The index, which must be valid.
	 * @return The value of property model at the specified index.
	 * @see java.util.List#get(int)
	 */
	public final Model getModel(int index) {
		return (Model) _model.get(index);
	}

	/**
	 * Returns an {@link java.util.Iterator} for all values of property model.
	 * 
	 * @return An {@link java.util.Iterator} for all values of property model.
	 * @see java.util.List#iterator()
	 */
	public final java.util.Iterator modelIterator() {
		return _model.iterator();
	}

	/**
	 * Returns the number of values of property model.
	 * 
	 * @return The number of values of property model.
	 * @see java.util.List#size()
	 */
	public final int modelSize() {
		return _model.size();
	}

	/**
	 * Add the specified value to property model. Referred from
	 * {@link de.hasait.eclipse.ccg.javag.application.model.Model#_application}, which will be updated by this method.
	 * 
	 * @param model
	 *           The additional value for property model.
	 * @see java.util.List#add(Object)
	 */
	final void addModel(final Model model) {
		if (_model.contains(model)) {
			return;
		}
		String modelPackage = model.getPackage();
		if (_modelByPackage.containsKey(modelPackage)) {
			throw new IllegalArgumentException("Duplicate model package: " + modelPackage);
		}
		_model.add(model);
		_modelByPackage.put(modelPackage, model);
	}

	/**
	 * Remove the specified value of property model. Referred from
	 * {@link de.hasait.eclipse.ccg.javag.application.model.Model#_application}, which will be updated by this method.
	 * 
	 * @param model
	 *           The value to remove from property model.
	 * @see java.util.List#remove(Object)
	 */
	final void removeModel(final Model model) {
		if (!_model.contains(model)) {
			return;
		}
		_model.remove(model);
		_modelByPackage.remove(model.getPackage());
	}

	public final Bean findBean(final String type) {
		int dotIndex = type.lastIndexOf('.');
		if (dotIndex < 0) {
			return null;
		}
		String packagej = type.substring(0, dotIndex);
		Model model = (Model) _modelByPackage.get(packagej);
		if (model == null) {
			return null;
		}
		String beanName = type.substring(dotIndex + 1);
		return model.findBean(beanName);
	}

	public final void resolve(final IProgressMonitor monitor) {
		for (Iterator modelI = _model.iterator(); modelI.hasNext();) {
			Model model = (Model) modelI.next();
			model.resolve(monitor);
		}
	}

	public final void validate(final IProgressMonitor monitor) {
		for (Iterator modelI = _model.iterator(); modelI.hasNext();) {
			Model model = (Model) modelI.next();
			model.validate(monitor);
		}
	}

	public final void write(final IProgressMonitor monitor) throws CoreException {
		for (Iterator modelI = _model.iterator(); modelI.hasNext();) {
			Model model = (Model) modelI.next();
			model.write(monitor);
		}
	}
}
