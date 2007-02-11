/**
 * <copyright>
 * </copyright>
 *
 * $Id: AbstractMMethodImplementation.java,v 1.1 2007-02-11 22:29:52 concentus Exp $
 */
package de.hasait.eclipse.ccg.java.model;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Abstract MMethod Implementation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.hasait.eclipse.ccg.java.model.AbstractMMethodImplementation#getOwner <em>Owner</em>}</li>
 *   <li>{@link de.hasait.eclipse.ccg.java.model.AbstractMMethodImplementation#getParameters <em>Parameters</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.hasait.eclipse.ccg.java.model.ModelPackage#getAbstractMMethodImplementation()
 * @model abstract="true"
 * @generated
 */
public interface AbstractMMethodImplementation extends AbstractMMethodLike {
	/**
	 * Returns the value of the '<em><b>Owner</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.hasait.eclipse.ccg.java.model.MDeclaredClass#getImplementedMethods <em>Implemented Methods</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owner</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owner</em>' container reference.
	 * @see #setOwner(MDeclaredClass)
	 * @see de.hasait.eclipse.ccg.java.model.ModelPackage#getAbstractMMethodImplementation_Owner()
	 * @see de.hasait.eclipse.ccg.java.model.MDeclaredClass#getImplementedMethods
	 * @model opposite="implementedMethods" required="true"
	 * @generated
	 */
	MDeclaredClass getOwner();

	/**
	 * Sets the value of the '{@link de.hasait.eclipse.ccg.java.model.AbstractMMethodImplementation#getOwner <em>Owner</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owner</em>' container reference.
	 * @see #getOwner()
	 * @generated
	 */
	void setOwner(MDeclaredClass value);

	/**
	 * Returns the value of the '<em><b>Parameters</b></em>' containment reference list.
	 * The list contents are of type {@link de.hasait.eclipse.ccg.java.model.MMethodImplementationParameter}.
	 * It is bidirectional and its opposite is '{@link de.hasait.eclipse.ccg.java.model.MMethodImplementationParameter#getMethodImplementation <em>Method Implementation</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parameters</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameters</em>' containment reference list.
	 * @see de.hasait.eclipse.ccg.java.model.ModelPackage#getAbstractMMethodImplementation_Parameters()
	 * @see de.hasait.eclipse.ccg.java.model.MMethodImplementationParameter#getMethodImplementation
	 * @model type="de.hasait.eclipse.ccg.java.model.MMethodImplementationParameter" opposite="methodImplementation" containment="true"
	 * @generated
	 */
	EList getParameters();

} // AbstractMMethodImplementation