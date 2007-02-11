/**
 * <copyright>
 * </copyright>
 *
 * $Id: MStaticClassFieldDeclaration.java,v 1.1 2007-02-11 22:29:52 concentus Exp $
 */
package de.hasait.eclipse.ccg.java.model;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>MStatic Class Field Declaration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.hasait.eclipse.ccg.java.model.MStaticClassFieldDeclaration#getOwner <em>Owner</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.hasait.eclipse.ccg.java.model.ModelPackage#getMStaticClassFieldDeclaration()
 * @model
 * @generated
 */
public interface MStaticClassFieldDeclaration extends AbstractMClassFieldDeclaration {
	/**
	 * Returns the value of the '<em><b>Owner</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.hasait.eclipse.ccg.java.model.MDeclaredClass#getStaticFields <em>Static Fields</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owner</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owner</em>' container reference.
	 * @see #setOwner(MDeclaredClass)
	 * @see de.hasait.eclipse.ccg.java.model.ModelPackage#getMStaticClassFieldDeclaration_Owner()
	 * @see de.hasait.eclipse.ccg.java.model.MDeclaredClass#getStaticFields
	 * @model opposite="staticFields" required="true"
	 * @generated
	 */
	MDeclaredClass getOwner();

	/**
	 * Sets the value of the '{@link de.hasait.eclipse.ccg.java.model.MStaticClassFieldDeclaration#getOwner <em>Owner</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owner</em>' container reference.
	 * @see #getOwner()
	 * @generated
	 */
	void setOwner(MDeclaredClass value);

} // MStaticClassFieldDeclaration