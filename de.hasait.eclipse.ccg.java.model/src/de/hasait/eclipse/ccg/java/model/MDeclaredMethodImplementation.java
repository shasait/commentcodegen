/**
 * <copyright>
 * </copyright>
 *
 * $Id: MDeclaredMethodImplementation.java,v 1.1 2007-02-11 22:29:52 concentus Exp $
 */
package de.hasait.eclipse.ccg.java.model;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>MDeclared Method Implementation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.hasait.eclipse.ccg.java.model.MDeclaredMethodImplementation#getDeclaration <em>Declaration</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.hasait.eclipse.ccg.java.model.ModelPackage#getMDeclaredMethodImplementation()
 * @model
 * @generated
 */
public interface MDeclaredMethodImplementation extends AbstractMMethodImplementation {
	/**
	 * Returns the value of the '<em><b>Declaration</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link de.hasait.eclipse.ccg.java.model.AbstractMImplementableMethodDeclaration#getImplementations <em>Implementations</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Declaration</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Declaration</em>' reference.
	 * @see #setDeclaration(AbstractMImplementableMethodDeclaration)
	 * @see de.hasait.eclipse.ccg.java.model.ModelPackage#getMDeclaredMethodImplementation_Declaration()
	 * @see de.hasait.eclipse.ccg.java.model.AbstractMImplementableMethodDeclaration#getImplementations
	 * @model opposite="implementations" required="true"
	 * @generated
	 */
	AbstractMImplementableMethodDeclaration getDeclaration();

	/**
	 * Sets the value of the '{@link de.hasait.eclipse.ccg.java.model.MDeclaredMethodImplementation#getDeclaration <em>Declaration</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Declaration</em>' reference.
	 * @see #getDeclaration()
	 * @generated
	 */
	void setDeclaration(AbstractMImplementableMethodDeclaration value);

} // MDeclaredMethodImplementation