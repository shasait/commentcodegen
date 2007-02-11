/**
 * <copyright>
 * </copyright>
 *
 * $Id: MCompilationUnit.java,v 1.1 2007-02-11 22:29:51 concentus Exp $
 */
package de.hasait.eclipse.ccg.java.model;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>MCompilation Unit</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.hasait.eclipse.ccg.java.model.MCompilationUnit#getImports <em>Imports</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.hasait.eclipse.ccg.java.model.ModelPackage#getMCompilationUnit()
 * @model
 * @generated
 */
public interface MCompilationUnit extends AbstractMResource, AbstractMTypeContainer {
	/**
	 * Returns the value of the '<em><b>Imports</b></em>' reference list.
	 * The list contents are of type {@link de.hasait.eclipse.ccg.java.model.AbstractMType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Imports</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Imports</em>' reference list.
	 * @see de.hasait.eclipse.ccg.java.model.ModelPackage#getMCompilationUnit_Imports()
	 * @model type="de.hasait.eclipse.ccg.java.model.AbstractMType"
	 * @generated
	 */
	EList getImports();

} // MCompilationUnit