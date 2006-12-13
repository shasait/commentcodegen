package de.hasait.eclipse.ccg.javag.application.model;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;

import de.hasait.eclipse.common.ContentBuffer;
import de.hasait.eclipse.common.StringUtil;
import de.hasait.eclipse.common.resource.XFile;
import de.hasait.eclipse.common.resource.XFolder;
import de.hasait.eclipse.common.resource.XResource;

/**
 * @author Sebastian Hasait (hasait at web.de)
 * @version $Revision: 1.1 $
 * @since 13.12.2006
 */
public class Model {
	private final Application _application;

	private final String _package;

	private final XFolder _targetFolder;

	private final java.util.List _bean = new java.util.ArrayList();

	private final Map _beanByName = new HashMap();

	/**
	 * Constructor.
	 */
	public Model(final Application application, final String packagej) {
		super();
		
		_application = application;
		_package = packagej;
		
		String packagePath = StringUtil.replace(_package, ".", "/");
		_targetFolder = _application.getTargetBaseFolder().getFolder(packagePath);
		
		_application.addModel(this);
	}

	/**
	 * Return the value of property application.
	 * 
	 * @return The value of property application.
	 */
	public final Application getApplication() {
		return _application;
	}

	/**
	 * Return the value of property package.
	 * 
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
	 * The value of property bean at the specified index.
	 * 
	 * @param index
	 *           The index, which must be valid.
	 * @return The value of property bean at the specified index.
	 * @see java.util.List#get(int)
	 */
	public final Bean getBean(int index) {
		return (Bean) _bean.get(index);
	}

	/**
	 * Returns an {@link java.util.Iterator} for all values of property bean.
	 * 
	 * @return An {@link java.util.Iterator} for all values of property bean.
	 * @see java.util.List#iterator()
	 */
	public final java.util.Iterator beanIterator() {
		return _bean.iterator();
	}

	/**
	 * Returns the number of values of property bean.
	 * 
	 * @return The number of values of property bean.
	 * @see java.util.List#size()
	 */
	public final int beanSize() {
		return _bean.size();
	}

	/**
	 * Add the specified value to property bean. Referred from
	 * {@link de.hasait.eclipse.ccg.javag.application.model.Bean#_model}, which will be updated by this method.
	 * 
	 * @param bean
	 *           The additional value for property bean.
	 * @see java.util.List#add(Object)
	 */
	final void addBean(final Bean bean) {
		if (_bean.contains(bean)) {
			return;
		}
		String beanName = bean.getName();
		if (_beanByName.containsKey(beanName)) {
			throw new IllegalArgumentException("Duplicate bean name: " + beanName);
		}
		_bean.add(bean);
		_beanByName.put(beanName, bean);
	}

	/**
	 * Remove the specified value of property bean. Referred from
	 * {@link de.hasait.eclipse.ccg.javag.application.model.Bean#_model}, which will be updated by this method.
	 * 
	 * @param bean
	 *           The value to remove from property bean.
	 * @see java.util.List#remove(Object)
	 */
	final void removeBean(final Bean bean) {
		if (!_bean.contains(bean)) {
			return;
		}
		_bean.remove(bean);
		_beanByName.remove(bean.getName());
	}

	public final Bean findBean(final String type) {
		if (type.indexOf('.') >= 0) {
			return _application.findBean(type);
		}
		return (Bean) _beanByName.get(type);
	}

	public final void resolve(final IProgressMonitor monitor) {
		for (Iterator beanI = _bean.iterator(); beanI.hasNext();) {
			Bean bean = (Bean) beanI.next();
			bean.resolve(monitor);
		}
	}

	public final void validate(final IProgressMonitor monitor) {
		for (Iterator beanI = _bean.iterator(); beanI.hasNext();) {
			Bean bean = (Bean) beanI.next();
			bean.validate(monitor);
		}
	}

	public final void write(final IProgressMonitor monitor) throws CoreException {
		monitor.subTask("write Package " + _package);
		Set files = new HashSet();
		for (Iterator beanI = _bean.iterator(); beanI.hasNext();) {
			Bean bean = (Bean) beanI.next();
			ContentBuffer content = new ContentBuffer();
			content.p("package " + _package + ";");
			content.p();
			bean.write(content, monitor);
			XFile file = bean.getTargetFile();
			file.write(content.getContent(), Boolean.TRUE, monitor);
			files.add(file);
		}
		monitor.subTask("clean Package " + _package);
		XResource[] members = _targetFolder.members();
		for (int membersI = 0; membersI < members.length; membersI++) {
			XResource member = members[membersI];
			if (member.isFile() && member.isDerived() && !files.contains(member)) {
				member.delete(false, monitor);
			}
		}
	}
}
