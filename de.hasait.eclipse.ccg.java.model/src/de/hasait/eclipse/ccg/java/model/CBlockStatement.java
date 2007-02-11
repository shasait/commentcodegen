/**
 * <copyright>
 * </copyright>
 *
 * $Id: CBlockStatement.java,v 1.1 2007-02-11 22:29:52 concentus Exp $
 */
package de.hasait.eclipse.ccg.java.model;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>CBlock Statement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.hasait.eclipse.ccg.java.model.CBlockStatement#getStatements <em>Statements</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.hasait.eclipse.ccg.java.model.ModelPackage#getCBlockStatement()
 * @model
 * @generated
 */
public interface CBlockStatement extends AbstractCStatement {
	/**
	 * Returns the value of the '<em><b>Statements</b></em>' containment reference list.
	 * The list contents are of type {@link de.hasait.eclipse.ccg.java.model.AbstractCStatement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Statements</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Statements</em>' containment reference list.
	 * @see de.hasait.eclipse.ccg.java.model.ModelPackage#getCBlockStatement_Statements()
	 * @model type="de.hasait.eclipse.ccg.java.model.AbstractCStatement" containment="true"
	 * @generated
	 */
	EList getStatements();

} // CBlockStatement