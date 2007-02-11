/**
 * <copyright>
 * </copyright>
 *
 * $Id: MConstructor.java,v 1.1 2007-02-11 22:29:52 concentus Exp $
 */
package de.hasait.eclipse.ccg.java.model;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>MConstructor</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.hasait.eclipse.ccg.java.model.MConstructor#getOwner <em>Owner</em>}</li>
 *   <li>{@link de.hasait.eclipse.ccg.java.model.MConstructor#getParameters <em>Parameters</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.hasait.eclipse.ccg.java.model.ModelPackage#getMConstructor()
 * @model
 * @generated
 */
public interface MConstructor extends AbstractMMethodLike {
	/**
	 * Returns the value of the '<em><b>Owner</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.hasait.eclipse.ccg.java.model.MDeclaredClass#getConstructors <em>Constructors</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owner</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owner</em>' container reference.
	 * @see #setOwner(MDeclaredClass)
	 * @see de.hasait.eclipse.ccg.java.model.ModelPackage#getMConstructor_Owner()
	 * @see de.hasait.eclipse.ccg.java.model.MDeclaredClass#getConstructors
	 * @model opposite="constructors" required="true"
	 * @generated
	 */
	MDeclaredClass getOwner();

	/**
	 * Sets the value of the '{@link de.hasait.eclipse.ccg.java.model.MConstructor#getOwner <em>Owner</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owner</em>' container reference.
	 * @see #getOwner()
	 * @generated
	 */
	void setOwner(MDeclaredClass value);

	/**
	 * Returns the value of the '<em><b>Parameters</b></em>' containment reference list.
	 * The list contents are of type {@link de.hasait.eclipse.ccg.java.model.MConstructorParameter}.
	 * It is bidirectional and its opposite is '{@link de.hasait.eclipse.ccg.java.model.MConstructorParameter#getConstructor <em>Constructor</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parameters</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameters</em>' containment reference list.
	 * @see de.hasait.eclipse.ccg.java.model.ModelPackage#getMConstructor_Parameters()
	 * @see de.hasait.eclipse.ccg.java.model.MConstructorParameter#getConstructor
	 * @model type="de.hasait.eclipse.ccg.java.model.MConstructorParameter" opposite="constructor" containment="true"
	 * @generated
	 */
	EList getParameters();

} // MConstructor