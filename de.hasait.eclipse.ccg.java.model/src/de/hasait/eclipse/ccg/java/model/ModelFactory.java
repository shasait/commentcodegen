/**
 * <copyright>
 * </copyright>
 *
 * $Id: ModelFactory.java,v 1.1 2007-02-11 22:29:51 concentus Exp $
 */
package de.hasait.eclipse.ccg.java.model;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see de.hasait.eclipse.ccg.java.model.ModelPackage
 * @generated
 */
public interface ModelFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ModelFactory eINSTANCE = de.hasait.eclipse.ccg.java.model.impl.ModelFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>MRoot</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>MRoot</em>'.
	 * @generated
	 */
	MRoot createMRoot();

	/**
	 * Returns a new object of class '<em>MPackage</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>MPackage</em>'.
	 * @generated
	 */
	MPackage createMPackage();

	/**
	 * Returns a new object of class '<em>MResource</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>MResource</em>'.
	 * @generated
	 */
	MResource createMResource();

	/**
	 * Returns a new object of class '<em>MCompilation Unit</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>MCompilation Unit</em>'.
	 * @generated
	 */
	MCompilationUnit createMCompilationUnit();

	/**
	 * Returns a new object of class '<em>MDeclared Type Reference</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>MDeclared Type Reference</em>'.
	 * @generated
	 */
	MDeclaredTypeReference createMDeclaredTypeReference();

	/**
	 * Returns a new object of class '<em>MExternal Type Reference</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>MExternal Type Reference</em>'.
	 * @generated
	 */
	MExternalTypeReference createMExternalTypeReference();

	/**
	 * Returns a new object of class '<em>MPrimitive Type Reference</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>MPrimitive Type Reference</em>'.
	 * @generated
	 */
	MPrimitiveTypeReference createMPrimitiveTypeReference();

	/**
	 * Returns a new object of class '<em>MDeclared Class</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>MDeclared Class</em>'.
	 * @generated
	 */
	MDeclaredClass createMDeclaredClass();

	/**
	 * Returns a new object of class '<em>MAbstract Declared Class</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>MAbstract Declared Class</em>'.
	 * @generated
	 */
	MAbstractDeclaredClass createMAbstractDeclaredClass();

	/**
	 * Returns a new object of class '<em>MExternal Class</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>MExternal Class</em>'.
	 * @generated
	 */
	MExternalClass createMExternalClass();

	/**
	 * Returns a new object of class '<em>MDeclared Interface</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>MDeclared Interface</em>'.
	 * @generated
	 */
	MDeclaredInterface createMDeclaredInterface();

	/**
	 * Returns a new object of class '<em>MExternal Interface</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>MExternal Interface</em>'.
	 * @generated
	 */
	MExternalInterface createMExternalInterface();

	/**
	 * Returns a new object of class '<em>MStatic Class Field Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>MStatic Class Field Declaration</em>'.
	 * @generated
	 */
	MStaticClassFieldDeclaration createMStaticClassFieldDeclaration();

	/**
	 * Returns a new object of class '<em>MInstance Class Field Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>MInstance Class Field Declaration</em>'.
	 * @generated
	 */
	MInstanceClassFieldDeclaration createMInstanceClassFieldDeclaration();

	/**
	 * Returns a new object of class '<em>MConstant Interface Field Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>MConstant Interface Field Declaration</em>'.
	 * @generated
	 */
	MConstantInterfaceFieldDeclaration createMConstantInterfaceFieldDeclaration();

	/**
	 * Returns a new object of class '<em>MMethod Declaration Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>MMethod Declaration Parameter</em>'.
	 * @generated
	 */
	MMethodDeclarationParameter createMMethodDeclarationParameter();

	/**
	 * Returns a new object of class '<em>MImplicit Method Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>MImplicit Method Declaration</em>'.
	 * @generated
	 */
	MImplicitMethodDeclaration createMImplicitMethodDeclaration();

	/**
	 * Returns a new object of class '<em>MAbstract Class Method Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>MAbstract Class Method Declaration</em>'.
	 * @generated
	 */
	MAbstractClassMethodDeclaration createMAbstractClassMethodDeclaration();

	/**
	 * Returns a new object of class '<em>MInterface Method Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>MInterface Method Declaration</em>'.
	 * @generated
	 */
	MInterfaceMethodDeclaration createMInterfaceMethodDeclaration();

	/**
	 * Returns a new object of class '<em>MNative Method Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>MNative Method Declaration</em>'.
	 * @generated
	 */
	MNativeMethodDeclaration createMNativeMethodDeclaration();

	/**
	 * Returns a new object of class '<em>MDeclared Method Implementation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>MDeclared Method Implementation</em>'.
	 * @generated
	 */
	MDeclaredMethodImplementation createMDeclaredMethodImplementation();

	/**
	 * Returns a new object of class '<em>MDirect Method Implementation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>MDirect Method Implementation</em>'.
	 * @generated
	 */
	MDirectMethodImplementation createMDirectMethodImplementation();

	/**
	 * Returns a new object of class '<em>MMethod Implementation Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>MMethod Implementation Parameter</em>'.
	 * @generated
	 */
	MMethodImplementationParameter createMMethodImplementationParameter();

	/**
	 * Returns a new object of class '<em>MConstructor</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>MConstructor</em>'.
	 * @generated
	 */
	MConstructor createMConstructor();

	/**
	 * Returns a new object of class '<em>MConstructor Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>MConstructor Parameter</em>'.
	 * @generated
	 */
	MConstructorParameter createMConstructorParameter();

	/**
	 * Returns a new object of class '<em>CBlock Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CBlock Statement</em>'.
	 * @generated
	 */
	CBlockStatement createCBlockStatement();

	/**
	 * Returns a new object of class '<em>CDeclaration Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CDeclaration Statement</em>'.
	 * @generated
	 */
	CDeclarationStatement createCDeclarationStatement();

	/**
	 * Returns a new object of class '<em>CExpression Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CExpression Statement</em>'.
	 * @generated
	 */
	CExpressionStatement createCExpressionStatement();

	/**
	 * Returns a new object of class '<em>CIf Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CIf Statement</em>'.
	 * @generated
	 */
	CIfStatement createCIfStatement();

	/**
	 * Returns a new object of class '<em>CUnparsed Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CUnparsed Statement</em>'.
	 * @generated
	 */
	CUnparsedStatement createCUnparsedStatement();

	/**
	 * Returns a new object of class '<em>CConditional Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CConditional Expression</em>'.
	 * @generated
	 */
	CConditionalExpression createCConditionalExpression();

	/**
	 * Returns a new object of class '<em>CUnparsed Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CUnparsed Expression</em>'.
	 * @generated
	 */
	CUnparsedExpression createCUnparsedExpression();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	ModelPackage getModelPackage();

} //ModelFactory
