/**
 * <copyright>
 * </copyright>
 *
 * $Id: MMethodImplementationParameter.java,v 1.1 2007-02-11 22:29:51 concentus Exp $
 */
package de.hasait.eclipse.ccg.java.model;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>MMethod Implementation Parameter</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.hasait.eclipse.ccg.java.model.MMethodImplementationParameter#getMethodImplementation <em>Method Implementation</em>}</li>
 *   <li>{@link de.hasait.eclipse.ccg.java.model.MMethodImplementationParameter#isFinal <em>Final</em>}</li>
 *   <li>{@link de.hasait.eclipse.ccg.java.model.MMethodImplementationParameter#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.hasait.eclipse.ccg.java.model.ModelPackage#getMMethodImplementationParameter()
 * @model
 * @generated
 */
public interface MMethodImplementationParameter extends EObject {
	/**
	 * Returns the value of the '<em><b>Method Implementation</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.hasait.eclipse.ccg.java.model.AbstractMMethodImplementation#getParameters <em>Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Method Implementation</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Method Implementation</em>' container reference.
	 * @see #setMethodImplementation(AbstractMMethodImplementation)
	 * @see de.hasait.eclipse.ccg.java.model.ModelPackage#getMMethodImplementationParameter_MethodImplementation()
	 * @see de.hasait.eclipse.ccg.java.model.AbstractMMethodImplementation#getParameters
	 * @model opposite="parameters" required="true"
	 * @generated
	 */
	AbstractMMethodImplementation getMethodImplementation();

	/**
	 * Sets the value of the '{@link de.hasait.eclipse.ccg.java.model.MMethodImplementationParameter#getMethodImplementation <em>Method Implementation</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Method Implementation</em>' container reference.
	 * @see #getMethodImplementation()
	 * @generated
	 */
	void setMethodImplementation(AbstractMMethodImplementation value);

	/**
	 * Returns the value of the '<em><b>Final</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Final</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Final</em>' attribute.
	 * @see #setFinal(boolean)
	 * @see de.hasait.eclipse.ccg.java.model.ModelPackage#getMMethodImplementationParameter_Final()
	 * @model default="true" required="true"
	 * @generated
	 */
	boolean isFinal();

	/**
	 * Sets the value of the '{@link de.hasait.eclipse.ccg.java.model.MMethodImplementationParameter#isFinal <em>Final</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Final</em>' attribute.
	 * @see #isFinal()
	 * @generated
	 */
	void setFinal(boolean value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see de.hasait.eclipse.ccg.java.model.ModelPackage#getMMethodImplementationParameter_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link de.hasait.eclipse.ccg.java.model.MMethodImplementationParameter#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

} // MMethodImplementationParameter