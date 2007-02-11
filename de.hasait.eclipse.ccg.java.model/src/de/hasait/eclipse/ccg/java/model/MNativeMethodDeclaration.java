/**
 * <copyright>
 * </copyright>
 *
 * $Id: MNativeMethodDeclaration.java,v 1.1 2007-02-11 22:29:51 concentus Exp $
 */
package de.hasait.eclipse.ccg.java.model;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>MNative Method Declaration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.hasait.eclipse.ccg.java.model.MNativeMethodDeclaration#getOwner <em>Owner</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.hasait.eclipse.ccg.java.model.ModelPackage#getMNativeMethodDeclaration()
 * @model
 * @generated
 */
public interface MNativeMethodDeclaration extends AbstractMMethodDeclaration {
	/**
	 * Returns the value of the '<em><b>Owner</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.hasait.eclipse.ccg.java.model.MDeclaredClass#getNativeMethods <em>Native Methods</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owner</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owner</em>' container reference.
	 * @see #setOwner(MDeclaredClass)
	 * @see de.hasait.eclipse.ccg.java.model.ModelPackage#getMNativeMethodDeclaration_Owner()
	 * @see de.hasait.eclipse.ccg.java.model.MDeclaredClass#getNativeMethods
	 * @model opposite="nativeMethods" required="true"
	 * @generated
	 */
	MDeclaredClass getOwner();

	/**
	 * Sets the value of the '{@link de.hasait.eclipse.ccg.java.model.MNativeMethodDeclaration#getOwner <em>Owner</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owner</em>' container reference.
	 * @see #getOwner()
	 * @generated
	 */
	void setOwner(MDeclaredClass value);

} // MNativeMethodDeclaration