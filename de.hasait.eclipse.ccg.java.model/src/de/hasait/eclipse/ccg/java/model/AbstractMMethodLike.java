/**
 * <copyright>
 * </copyright>
 *
 * $Id: AbstractMMethodLike.java,v 1.1 2007-02-11 22:29:51 concentus Exp $
 */
package de.hasait.eclipse.ccg.java.model;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Abstract MMethod Like</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.hasait.eclipse.ccg.java.model.AbstractMMethodLike#getStatement <em>Statement</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.hasait.eclipse.ccg.java.model.ModelPackage#getAbstractMMethodLike()
 * @model abstract="true"
 * @generated
 */
public interface AbstractMMethodLike extends AbstractModifiers {
	/**
	 * Returns the value of the '<em><b>Statement</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Statement</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Statement</em>' containment reference.
	 * @see #setStatement(AbstractCStatement)
	 * @see de.hasait.eclipse.ccg.java.model.ModelPackage#getAbstractMMethodLike_Statement()
	 * @model containment="true"
	 * @generated
	 */
	AbstractCStatement getStatement();

	/**
	 * Sets the value of the '{@link de.hasait.eclipse.ccg.java.model.AbstractMMethodLike#getStatement <em>Statement</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Statement</em>' containment reference.
	 * @see #getStatement()
	 * @generated
	 */
	void setStatement(AbstractCStatement value);

} // AbstractMMethodLike