/**
 * <copyright>
 * </copyright>
 *
 * $Id: MMethodDeclarationParameter.java,v 1.1 2007-02-11 22:29:51 concentus Exp $
 */
package de.hasait.eclipse.ccg.java.model;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>MMethod Declaration Parameter</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.hasait.eclipse.ccg.java.model.MMethodDeclarationParameter#getMethodDeclaration <em>Method Declaration</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.hasait.eclipse.ccg.java.model.ModelPackage#getMMethodDeclarationParameter()
 * @model
 * @generated
 */
public interface MMethodDeclarationParameter extends AbstractMTypeWithNameDeclaration {
	/**
	 * Returns the value of the '<em><b>Method Declaration</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.hasait.eclipse.ccg.java.model.AbstractMMethodDeclaration#getParameters <em>Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Method Declaration</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Method Declaration</em>' container reference.
	 * @see #setMethodDeclaration(AbstractMMethodDeclaration)
	 * @see de.hasait.eclipse.ccg.java.model.ModelPackage#getMMethodDeclarationParameter_MethodDeclaration()
	 * @see de.hasait.eclipse.ccg.java.model.AbstractMMethodDeclaration#getParameters
	 * @model opposite="parameters" required="true"
	 * @generated
	 */
	AbstractMMethodDeclaration getMethodDeclaration();

	/**
	 * Sets the value of the '{@link de.hasait.eclipse.ccg.java.model.MMethodDeclarationParameter#getMethodDeclaration <em>Method Declaration</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Method Declaration</em>' container reference.
	 * @see #getMethodDeclaration()
	 * @generated
	 */
	void setMethodDeclaration(AbstractMMethodDeclaration value);

} // MMethodDeclarationParameter