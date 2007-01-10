package de.hasait.eclipse.ccg.javag.application;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;

import de.hasait.eclipse.ccg.javag.application.model.AModel;
import de.hasait.eclipse.ccg.javag.application.view.View;
import de.hasait.eclipse.common.ContentBuffer;
import de.hasait.eclipse.common.IOUtil;
import de.hasait.eclipse.common.resource.XFile;
import de.hasait.eclipse.common.resource.XFolder;
import de.hasait.eclipse.common.xml.XElement;

/**
 * @author Sebastian Hasait (hasait at web.de)
 * @version $Revision: 1.4 $
 * @since 13.12.2006
 */
public class Application {
	private final XFile _sourceFile;

	private final XFolder _targetBaseFolder;

	private final String _package;

	private final List _cuContainers = new ArrayList();

	private final Map _cuContainersByPackage = new HashMap();

	public final AbstractCuContainer _appGlobalCuContainer;

	public final AbstractCompilationUnit _applicationContextCu;

	public final AbstractCompilationUnit _modelEventDispatcherCu;

	/**
	 * Constructor.
	 */
	public Application(final XFile pSourceFile, final XFolder pTargetBaseFolder, final XElement pConfigElement) {
		super();

		_sourceFile = pSourceFile;
		_targetBaseFolder = pTargetBaseFolder;

		_package = pConfigElement.getRequiredAttribute("package");

		_appGlobalCuContainer = new AbstractCuContainer(this, "app", "global");
		addCuContainer(_appGlobalCuContainer);

		_applicationContextCu = new AbstractCompilationUnit(_appGlobalCuContainer, null, "ApplicationContext", null, null) {
			protected void writeTypes(ContentBuffer pContent, Map pUserBlockContentByName, IProgressMonitor pMonitor) {
				pContent.pi("public final class ApplicationContext {");
				pContent.pi("private ApplicationContext() {");
				pContent.p("super();");
				pContent.pu("}");
				pContent.p();
				pContent.p("public static final ApplicationContext DEFAULT = new ApplicationContext();");
				pContent.p();
				pContent.p("public final ModelEventDispatcher ED = new ModelEventDispatcher();");
				pContent.p();
				pContent.p();
				pContent.pu("}");
			}
		};
		_appGlobalCuContainer.addCompilationUnit(_applicationContextCu);

		_modelEventDispatcherCu = new AbstractCompilationUnit(_appGlobalCuContainer, null, "ModelEventDispatcher", null,
		      null) {
			protected void writeTypes(ContentBuffer pContent, Map pUserBlockContentByName, IProgressMonitor pMonitor) throws CoreException {
				InputStream vSourceIn = Application.class.getResourceAsStream("ModelEventDispatcher.javainc");
				if (vSourceIn != null) {
					Reader vSourceReader = new InputStreamReader(vSourceIn);
					String vSource;
					try {
						vSource = IOUtil.readAll(vSourceReader);
						vSourceReader.close();
					} catch (IOException e) {
						throw new CoreException(new Status(IStatus.ERROR, null, IStatus.ERROR, e.getLocalizedMessage(), e));
					}
					pContent.p(vSource);
				}
			}
		};
		_appGlobalCuContainer.addCompilationUnit(_modelEventDispatcherCu);

		XElement[] vModelElements = pConfigElement.getChildElements("model");
		for (int vModelElementsI = 0; vModelElementsI < vModelElements.length; vModelElementsI++) {
			XElement vModelElement = vModelElements[vModelElementsI];
			AModel vModel = new AModel(this, vModelElement);
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
