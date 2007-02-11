/**
 * <copyright>
 * </copyright>
 *
 * $Id: MDirectMethodImplementation.java,v 1.1 2007-02-11 22:29:52 concentus Exp $
 */
package de.hasait.eclipse.ccg.java.model;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>MDirect Method Implementation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.hasait.eclipse.ccg.java.model.MDirectMethodImplementation#getDeclaration <em>Declaration</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.hasait.eclipse.ccg.java.model.ModelPackage#getMDirectMethodImplementation()
 * @model
 * @generated
 */
public interface MDirectMethodImplementation extends AbstractMMethodImplementation {
	/**
	 * Returns the value of the '<em><b>Declaration</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link de.hasait.eclipse.ccg.java.model.MImplicitMethodDeclaration#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Declaration</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Declaration</em>' containment reference.
	 * @see #setDeclaration(MImplicitMethodDeclaration)
	 * @see de.hasait.eclipse.ccg.java.model.ModelPackage#getMDirectMethodImplementation_Declaration()
	 * @see de.hasait.eclipse.ccg.java.model.MImplicitMethodDeclaration#getOwner
	 * @model opposite="owner" containment="true" required="true"
	 * @generated
	 */
	MImplicitMethodDeclaration getDeclaration();

	/**
	 * Sets the value of the '{@link de.hasait.eclipse.ccg.java.model.MDirectMethodImplementation#getDeclaration <em>Declaration</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Declaration</em>' containment reference.
	 * @see #getDeclaration()
	 * @generated
	 */
	void setDeclaration(MImplicitMethodDeclaration value);

} // MDirectMethodImplementation