package de.hasait.eclipse.ccg.javag.app.global;


/**
 * @author CCG /model/ccg/model.ccg.xml
 */
public final class ApplicationContext {
	private ApplicationContext() {
		super();
	}
	
	public static final ApplicationContext DEFAULT = new ApplicationContext();
	
	public final ModelEventDispatcher ED = new ModelEventDispatcher();
	
	
}
