/**
 * <copyright>
 * </copyright>
 *
 * $Id: MInterfaceMethodDeclaration.java,v 1.1 2007-02-11 22:29:51 concentus Exp $
 */
package de.hasait.eclipse.ccg.java.model;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>MInterface Method Declaration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.hasait.eclipse.ccg.java.model.MInterfaceMethodDeclaration#getOwner <em>Owner</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.hasait.eclipse.ccg.java.model.ModelPackage#getMInterfaceMethodDeclaration()
 * @model
 * @generated
 */
public interface MInterfaceMethodDeclaration extends AbstractMImplementableMethodDeclaration {
	/**
	 * Returns the value of the '<em><b>Owner</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.hasait.eclipse.ccg.java.model.MDeclaredInterface#getMethods <em>Methods</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owner</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owner</em>' container reference.
	 * @see #setOwner(MDeclaredInterface)
	 * @see de.hasait.eclipse.ccg.java.model.ModelPackage#getMInterfaceMethodDeclaration_Owner()
	 * @see de.hasait.eclipse.ccg.java.model.MDeclaredInterface#getMethods
	 * @model opposite="methods" required="true"
	 * @generated
	 */
	MDeclaredInterface getOwner();

	/**
	 * Sets the value of the '{@link de.hasait.eclipse.ccg.java.model.MInterfaceMethodDeclaration#getOwner <em>Owner</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owner</em>' container reference.
	 * @see #getOwner()
	 * @generated
	 */
	void setOwner(MDeclaredInterface value);

} // MInterfaceMethodDeclaration