/**
 * <copyright>
 * </copyright>
 *
 * $Id: ModelSwitch.java,v 1.1 2007-02-11 22:29:54 concentus Exp $
 */
package de.hasait.eclipse.ccg.java.model.util;

import de.hasait.eclipse.ccg.java.model.*;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see de.hasait.eclipse.ccg.java.model.ModelPackage
 * @generated
 */
public class ModelSwitch {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static ModelPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelSwitch() {
		if (modelPackage == null) {
			modelPackage = ModelPackage.eINSTANCE;
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	public Object doSwitch(EObject theEObject) {
		return doSwitch(theEObject.eClass(), theEObject);
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected Object doSwitch(EClass theEClass, EObject theEObject) {
		if (theEClass.eContainer() == modelPackage) {
			return doSwitch(theEClass.getClassifierID(), theEObject);
		}
		else {
			List eSuperTypes = theEClass.getESuperTypes();
			return
				eSuperTypes.isEmpty() ?
					defaultCase(theEObject) :
					doSwitch((EClass)eSuperTypes.get(0), theEObject);
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected Object doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case ModelPackage.ABSTRACT_MPACKAGE_CONTAINER: {
				AbstractMPackageContainer abstractMPackageContainer = (AbstractMPackageContainer)theEObject;
				Object result = caseAbstractMPackageContainer(abstractMPackageContainer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.MROOT: {
				MRoot mRoot = (MRoot)theEObject;
				Object result = caseMRoot(mRoot);
				if (result == null) result = caseAbstractMPackageContainer(mRoot);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.MPACKAGE: {
				MPackage mPackage = (MPackage)theEObject;
				Object result = caseMPackage(mPackage);
				if (result == null) result = caseAbstractMPackageContainer(mPackage);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.ABSTRACT_MRESOURCE: {
				AbstractMResource abstractMResource = (AbstractMResource)theEObject;
				Object result = caseAbstractMResource(abstractMResource);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.MRESOURCE: {
				MResource mResource = (MResource)theEObject;
				Object result = caseMResource(mResource);
				if (result == null) result = caseAbstractMResource(mResource);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.ABSTRACT_MTYPE_CONTAINER: {
				AbstractMTypeContainer abstractMTypeContainer = (AbstractMTypeContainer)theEObject;
				Object result = caseAbstractMTypeContainer(abstractMTypeContainer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.MCOMPILATION_UNIT: {
				MCompilationUnit mCompilationUnit = (MCompilationUnit)theEObject;
				Object result = caseMCompilationUnit(mCompilationUnit);
				if (result == null) result = caseAbstractMResource(mCompilationUnit);
				if (result == null) result = caseAbstractMTypeContainer(mCompilationUnit);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.ABSTRACT_MDECLARED_TYPE: {
				AbstractMDeclaredType abstractMDeclaredType = (AbstractMDeclaredType)theEObject;
				Object result = caseAbstractMDeclaredType(abstractMDeclaredType);
				if (result == null) result = caseAbstractMTypeContainer(abstractMDeclaredType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.ABSTRACT_MEXTERNAL_TYPE: {
				AbstractMExternalType abstractMExternalType = (AbstractMExternalType)theEObject;
				Object result = caseAbstractMExternalType(abstractMExternalType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.ABSTRACT_MTYPE: {
				AbstractMType abstractMType = (AbstractMType)theEObject;
				Object result = caseAbstractMType(abstractMType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.ABSTRACT_MTYPE_REFERENCE: {
				AbstractMTypeReference abstractMTypeReference = (AbstractMTypeReference)theEObject;
				Object result = caseAbstractMTypeReference(abstractMTypeReference);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.MDECLARED_TYPE_REFERENCE: {
				MDeclaredTypeReference mDeclaredTypeReference = (MDeclaredTypeReference)theEObject;
				Object result = caseMDeclaredTypeReference(mDeclaredTypeReference);
				if (result == null) result = caseAbstractMTypeReference(mDeclaredTypeReference);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.MEXTERNAL_TYPE_REFERENCE: {
				MExternalTypeReference mExternalTypeReference = (MExternalTypeReference)theEObject;
				Object result = caseMExternalTypeReference(mExternalTypeReference);
				if (result == null) result = caseAbstractMTypeReference(mExternalTypeReference);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.MPRIMITIVE_TYPE_REFERENCE: {
				MPrimitiveTypeReference mPrimitiveTypeReference = (MPrimitiveTypeReference)theEObject;
				Object result = caseMPrimitiveTypeReference(mPrimitiveTypeReference);
				if (result == null) result = caseAbstractMTypeReference(mPrimitiveTypeReference);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.ABSTRACT_MODIFIERS: {
				AbstractModifiers abstractModifiers = (AbstractModifiers)theEObject;
				Object result = caseAbstractModifiers(abstractModifiers);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.ABSTRACT_MMETHOD_LIKE: {
				AbstractMMethodLike abstractMMethodLike = (AbstractMMethodLike)theEObject;
				Object result = caseAbstractMMethodLike(abstractMMethodLike);
				if (result == null) result = caseAbstractModifiers(abstractMMethodLike);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.ABSTRACT_MTYPE_WITH_NAME_DECLARATION: {
				AbstractMTypeWithNameDeclaration abstractMTypeWithNameDeclaration = (AbstractMTypeWithNameDeclaration)theEObject;
				Object result = caseAbstractMTypeWithNameDeclaration(abstractMTypeWithNameDeclaration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.ABSTRACT_MCLASS: {
				AbstractMClass abstractMClass = (AbstractMClass)theEObject;
				Object result = caseAbstractMClass(abstractMClass);
				if (result == null) result = caseAbstractMType(abstractMClass);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.MDECLARED_CLASS: {
				MDeclaredClass mDeclaredClass = (MDeclaredClass)theEObject;
				Object result = caseMDeclaredClass(mDeclaredClass);
				if (result == null) result = caseAbstractMClass(mDeclaredClass);
				if (result == null) result = caseAbstractMDeclaredType(mDeclaredClass);
				if (result == null) result = caseAbstractMType(mDeclaredClass);
				if (result == null) result = caseAbstractMTypeContainer(mDeclaredClass);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.MABSTRACT_DECLARED_CLASS: {
				MAbstractDeclaredClass mAbstractDeclaredClass = (MAbstractDeclaredClass)theEObject;
				Object result = caseMAbstractDeclaredClass(mAbstractDeclaredClass);
				if (result == null) result = caseMDeclaredClass(mAbstractDeclaredClass);
				if (result == null) result = caseAbstractMClass(mAbstractDeclaredClass);
				if (result == null) result = caseAbstractMDeclaredType(mAbstractDeclaredClass);
				if (result == null) result = caseAbstractMType(mAbstractDeclaredClass);
				if (result == null) result = caseAbstractMTypeContainer(mAbstractDeclaredClass);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.MEXTERNAL_CLASS: {
				MExternalClass mExternalClass = (MExternalClass)theEObject;
				Object result = caseMExternalClass(mExternalClass);
				if (result == null) result = caseAbstractMClass(mExternalClass);
				if (result == null) result = caseAbstractMExternalType(mExternalClass);
				if (result == null) result = caseAbstractMType(mExternalClass);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.ABSTRACT_MINTERFACE: {
				AbstractMInterface abstractMInterface = (AbstractMInterface)theEObject;
				Object result = caseAbstractMInterface(abstractMInterface);
				if (result == null) result = caseAbstractMType(abstractMInterface);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.MDECLARED_INTERFACE: {
				MDeclaredInterface mDeclaredInterface = (MDeclaredInterface)theEObject;
				Object result = caseMDeclaredInterface(mDeclaredInterface);
				if (result == null) result = caseAbstractMInterface(mDeclaredInterface);
				if (result == null) result = caseAbstractMDeclaredType(mDeclaredInterface);
				if (result == null) result = caseAbstractMType(mDeclaredInterface);
				if (result == null) result = caseAbstractMTypeContainer(mDeclaredInterface);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.MEXTERNAL_INTERFACE: {
				MExternalInterface mExternalInterface = (MExternalInterface)theEObject;
				Object result = caseMExternalInterface(mExternalInterface);
				if (result == null) result = caseAbstractMInterface(mExternalInterface);
				if (result == null) result = caseAbstractMExternalType(mExternalInterface);
				if (result == null) result = caseAbstractMType(mExternalInterface);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.ABSTRACT_MFIELD_DECLARATION: {
				AbstractMFieldDeclaration abstractMFieldDeclaration = (AbstractMFieldDeclaration)theEObject;
				Object result = caseAbstractMFieldDeclaration(abstractMFieldDeclaration);
				if (result == null) result = caseAbstractMTypeWithNameDeclaration(abstractMFieldDeclaration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.ABSTRACT_MCLASS_FIELD_DECLARATION: {
				AbstractMClassFieldDeclaration abstractMClassFieldDeclaration = (AbstractMClassFieldDeclaration)theEObject;
				Object result = caseAbstractMClassFieldDeclaration(abstractMClassFieldDeclaration);
				if (result == null) result = caseAbstractMFieldDeclaration(abstractMClassFieldDeclaration);
				if (result == null) result = caseAbstractMTypeWithNameDeclaration(abstractMClassFieldDeclaration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.MSTATIC_CLASS_FIELD_DECLARATION: {
				MStaticClassFieldDeclaration mStaticClassFieldDeclaration = (MStaticClassFieldDeclaration)theEObject;
				Object result = caseMStaticClassFieldDeclaration(mStaticClassFieldDeclaration);
				if (result == null) result = caseAbstractMClassFieldDeclaration(mStaticClassFieldDeclaration);
				if (result == null) result = caseAbstractMFieldDeclaration(mStaticClassFieldDeclaration);
				if (result == null) result = caseAbstractMTypeWithNameDeclaration(mStaticClassFieldDeclaration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.MINSTANCE_CLASS_FIELD_DECLARATION: {
				MInstanceClassFieldDeclaration mInstanceClassFieldDeclaration = (MInstanceClassFieldDeclaration)theEObject;
				Object result = caseMInstanceClassFieldDeclaration(mInstanceClassFieldDeclaration);
				if (result == null) result = caseAbstractMClassFieldDeclaration(mInstanceClassFieldDeclaration);
				if (result == null) result = caseAbstractMFieldDeclaration(mInstanceClassFieldDeclaration);
				if (result == null) result = caseAbstractMTypeWithNameDeclaration(mInstanceClassFieldDeclaration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.MCONSTANT_INTERFACE_FIELD_DECLARATION: {
				MConstantInterfaceFieldDeclaration mConstantInterfaceFieldDeclaration = (MConstantInterfaceFieldDeclaration)theEObject;
				Object result = caseMConstantInterfaceFieldDeclaration(mConstantInterfaceFieldDeclaration);
				if (result == null) result = caseAbstractMFieldDeclaration(mConstantInterfaceFieldDeclaration);
				if (result == null) result = caseAbstractMTypeWithNameDeclaration(mConstantInterfaceFieldDeclaration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.ABSTRACT_MMETHOD_DECLARATION: {
				AbstractMMethodDeclaration abstractMMethodDeclaration = (AbstractMMethodDeclaration)theEObject;
				Object result = caseAbstractMMethodDeclaration(abstractMMethodDeclaration);
				if (result == null) result = caseAbstractMTypeWithNameDeclaration(abstractMMethodDeclaration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.MMETHOD_DECLARATION_PARAMETER: {
				MMethodDeclarationParameter mMethodDeclarationParameter = (MMethodDeclarationParameter)theEObject;
				Object result = caseMMethodDeclarationParameter(mMethodDeclarationParameter);
				if (result == null) result = caseAbstractMTypeWithNameDeclaration(mMethodDeclarationParameter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.MIMPLICIT_METHOD_DECLARATION: {
				MImplicitMethodDeclaration mImplicitMethodDeclaration = (MImplicitMethodDeclaration)theEObject;
				Object result = caseMImplicitMethodDeclaration(mImplicitMethodDeclaration);
				if (result == null) result = caseAbstractMMethodDeclaration(mImplicitMethodDeclaration);
				if (result == null) result = caseAbstractMTypeWithNameDeclaration(mImplicitMethodDeclaration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.ABSTRACT_MIMPLEMENTABLE_METHOD_DECLARATION: {
				AbstractMImplementableMethodDeclaration abstractMImplementableMethodDeclaration = (AbstractMImplementableMethodDeclaration)theEObject;
				Object result = caseAbstractMImplementableMethodDeclaration(abstractMImplementableMethodDeclaration);
				if (result == null) result = caseAbstractMMethodDeclaration(abstractMImplementableMethodDeclaration);
				if (result == null) result = caseAbstractMTypeWithNameDeclaration(abstractMImplementableMethodDeclaration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.MABSTRACT_CLASS_METHOD_DECLARATION: {
				MAbstractClassMethodDeclaration mAbstractClassMethodDeclaration = (MAbstractClassMethodDeclaration)theEObject;
				Object result = caseMAbstractClassMethodDeclaration(mAbstractClassMethodDeclaration);
				if (result == null) result = caseAbstractMImplementableMethodDeclaration(mAbstractClassMethodDeclaration);
				if (result == null) result = caseAbstractMMethodDeclaration(mAbstractClassMethodDeclaration);
				if (result == null) result = caseAbstractMTypeWithNameDeclaration(mAbstractClassMethodDeclaration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.MINTERFACE_METHOD_DECLARATION: {
				MInterfaceMethodDeclaration mInterfaceMethodDeclaration = (MInterfaceMethodDeclaration)theEObject;
				Object result = caseMInterfaceMethodDeclaration(mInterfaceMethodDeclaration);
				if (result == null) result = caseAbstractMImplementableMethodDeclaration(mInterfaceMethodDeclaration);
				if (result == null) result = caseAbstractMMethodDeclaration(mInterfaceMethodDeclaration);
				if (result == null) result = caseAbstractMTypeWithNameDeclaration(mInterfaceMethodDeclaration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.MNATIVE_METHOD_DECLARATION: {
				MNativeMethodDeclaration mNativeMethodDeclaration = (MNativeMethodDeclaration)theEObject;
				Object result = caseMNativeMethodDeclaration(mNativeMethodDeclaration);
				if (result == null) result = caseAbstractMMethodDeclaration(mNativeMethodDeclaration);
				if (result == null) result = caseAbstractMTypeWithNameDeclaration(mNativeMethodDeclaration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.ABSTRACT_MMETHOD_IMPLEMENTATION: {
				AbstractMMethodImplementation abstractMMethodImplementation = (AbstractMMethodImplementation)theEObject;
				Object result = caseAbstractMMethodImplementation(abstractMMethodImplementation);
				if (result == null) result = caseAbstractMMethodLike(abstractMMethodImplementation);
				if (result == null) result = caseAbstractModifiers(abstractMMethodImplementation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.MDECLARED_METHOD_IMPLEMENTATION: {
				MDeclaredMethodImplementation mDeclaredMethodImplementation = (MDeclaredMethodImplementation)theEObject;
				Object result = caseMDeclaredMethodImplementation(mDeclaredMethodImplementation);
				if (result == null) result = caseAbstractMMethodImplementation(mDeclaredMethodImplementation);
				if (result == null) result = caseAbstractMMethodLike(mDeclaredMethodImplementation);
				if (result == null) result = caseAbstractModifiers(mDeclaredMethodImplementation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.MDIRECT_METHOD_IMPLEMENTATION: {
				MDirectMethodImplementation mDirectMethodImplementation = (MDirectMethodImplementation)theEObject;
				Object result = caseMDirectMethodImplementation(mDirectMethodImplementation);
				if (result == null) result = caseAbstractMMethodImplementation(mDirectMethodImplementation);
				if (result == null) result = caseAbstractMMethodLike(mDirectMethodImplementation);
				if (result == null) result = caseAbstractModifiers(mDirectMethodImplementation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.MMETHOD_IMPLEMENTATION_PARAMETER: {
				MMethodImplementationParameter mMethodImplementationParameter = (MMethodImplementationParameter)theEObject;
				Object result = caseMMethodImplementationParameter(mMethodImplementationParameter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.MCONSTRUCTOR: {
				MConstructor mConstructor = (MConstructor)theEObject;
				Object result = caseMConstructor(mConstructor);
				if (result == null) result = caseAbstractMMethodLike(mConstructor);
				if (result == null) result = caseAbstractModifiers(mConstructor);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.MCONSTRUCTOR_PARAMETER: {
				MConstructorParameter mConstructorParameter = (MConstructorParameter)theEObject;
				Object result = caseMConstructorParameter(mConstructorParameter);
				if (result == null) result = caseAbstractMTypeWithNameDeclaration(mConstructorParameter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.ABSTRACT_CSTATEMENT: {
				AbstractCStatement abstractCStatement = (AbstractCStatement)theEObject;
				Object result = caseAbstractCStatement(abstractCStatement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.CBLOCK_STATEMENT: {
				CBlockStatement cBlockStatement = (CBlockStatement)theEObject;
				Object result = caseCBlockStatement(cBlockStatement);
				if (result == null) result = caseAbstractCStatement(cBlockStatement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.CDECLARATION_STATEMENT: {
				CDeclarationStatement cDeclarationStatement = (CDeclarationStatement)theEObject;
				Object result = caseCDeclarationStatement(cDeclarationStatement);
				if (result == null) result = caseAbstractCStatement(cDeclarationStatement);
				if (result == null) result = caseAbstractMTypeWithNameDeclaration(cDeclarationStatement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.CEXPRESSION_STATEMENT: {
				CExpressionStatement cExpressionStatement = (CExpressionStatement)theEObject;
				Object result = caseCExpressionStatement(cExpressionStatement);
				if (result == null) result = caseAbstractCStatement(cExpressionStatement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.CIF_STATEMENT: {
				CIfStatement cIfStatement = (CIfStatement)theEObject;
				Object result = caseCIfStatement(cIfStatement);
				if (result == null) result = caseAbstractCStatement(cIfStatement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.CUNPARSED_STATEMENT: {
				CUnparsedStatement cUnparsedStatement = (CUnparsedStatement)theEObject;
				Object result = caseCUnparsedStatement(cUnparsedStatement);
				if (result == null) result = caseAbstractCStatement(cUnparsedStatement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.ABSTRACT_CEXPRESSION: {
				AbstractCExpression abstractCExpression = (AbstractCExpression)theEObject;
				Object result = caseAbstractCExpression(abstractCExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.CCONDITIONAL_EXPRESSION: {
				CConditionalExpression cConditionalExpression = (CConditionalExpression)theEObject;
				Object result = caseCConditionalExpression(cConditionalExpression);
				if (result == null) result = caseAbstractCExpression(cConditionalExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.CUNPARSED_EXPRESSION: {
				CUnparsedExpression cUnparsedExpression = (CUnparsedExpression)theEObject;
				Object result = caseCUnparsedExpression(cUnparsedExpression);
				if (result == null) result = caseAbstractCExpression(cUnparsedExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Abstract MPackage Container</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Abstract MPackage Container</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseAbstractMPackageContainer(AbstractMPackageContainer object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>MRoot</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>MRoot</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseMRoot(MRoot object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>MPackage</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>MPackage</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseMPackage(MPackage object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Abstract MResource</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Abstract MResource</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseAbstractMResource(AbstractMResource object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>MResource</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>MResource</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseMResource(MResource object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Abstract MType Container</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Abstract MType Container</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseAbstractMTypeContainer(AbstractMTypeContainer object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>MCompilation Unit</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>MCompilation Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseMCompilationUnit(MCompilationUnit object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Abstract MDeclared Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Abstract MDeclared Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseAbstractMDeclaredType(AbstractMDeclaredType object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Abstract MExternal Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Abstract MExternal Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseAbstractMExternalType(AbstractMExternalType object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Abstract MType</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Abstract MType</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseAbstractMType(AbstractMType object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Abstract MType Reference</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Abstract MType Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseAbstractMTypeReference(AbstractMTypeReference object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>MDeclared Type Reference</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>MDeclared Type Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseMDeclaredTypeReference(MDeclaredTypeReference object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>MExternal Type Reference</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>MExternal Type Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseMExternalTypeReference(MExternalTypeReference object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>MPrimitive Type Reference</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>MPrimitive Type Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseMPrimitiveTypeReference(MPrimitiveTypeReference object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Abstract Modifiers</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Abstract Modifiers</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseAbstractModifiers(AbstractModifiers object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Abstract MMethod Like</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Abstract MMethod Like</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseAbstractMMethodLike(AbstractMMethodLike object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Abstract MType With Name Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Abstract MType With Name Declaration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseAbstractMTypeWithNameDeclaration(AbstractMTypeWithNameDeclaration object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Abstract MClass</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Abstract MClass</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseAbstractMClass(AbstractMClass object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>MDeclared Class</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>MDeclared Class</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseMDeclaredClass(MDeclaredClass object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>MAbstract Declared Class</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>MAbstract Declared Class</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseMAbstractDeclaredClass(MAbstractDeclaredClass object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>MExternal Class</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>MExternal Class</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseMExternalClass(MExternalClass object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Abstract MInterface</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Abstract MInterface</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseAbstractMInterface(AbstractMInterface object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>MDeclared Interface</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>MDeclared Interface</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseMDeclaredInterface(MDeclaredInterface object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>MExternal Interface</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>MExternal Interface</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseMExternalInterface(MExternalInterface object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Abstract MField Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Abstract MField Declaration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseAbstractMFieldDeclaration(AbstractMFieldDeclaration object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Abstract MClass Field Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Abstract MClass Field Declaration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseAbstractMClassFieldDeclaration(AbstractMClassFieldDeclaration object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>MStatic Class Field Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>MStatic Class Field Declaration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseMStaticClassFieldDeclaration(MStaticClassFieldDeclaration object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>MInstance Class Field Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>MInstance Class Field Declaration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseMInstanceClassFieldDeclaration(MInstanceClassFieldDeclaration object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>MConstant Interface Field Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>MConstant Interface Field Declaration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseMConstantInterfaceFieldDeclaration(MConstantInterfaceFieldDeclaration object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Abstract MMethod Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Abstract MMethod Declaration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseAbstractMMethodDeclaration(AbstractMMethodDeclaration object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>MMethod Declaration Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>MMethod Declaration Parameter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseMMethodDeclarationParameter(MMethodDeclarationParameter object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>MImplicit Method Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>MImplicit Method Declaration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseMImplicitMethodDeclaration(MImplicitMethodDeclaration object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Abstract MImplementable Method Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Abstract MImplementable Method Declaration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseAbstractMImplementableMethodDeclaration(AbstractMImplementableMethodDeclaration object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>MAbstract Class Method Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>MAbstract Class Method Declaration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseMAbstractClassMethodDeclaration(MAbstractClassMethodDeclaration object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>MInterface Method Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>MInterface Method Declaration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseMInterfaceMethodDeclaration(MInterfaceMethodDeclaration object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>MNative Method Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>MNative Method Declaration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseMNativeMethodDeclaration(MNativeMethodDeclaration object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Abstract MMethod Implementation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Abstract MMethod Implementation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseAbstractMMethodImplementation(AbstractMMethodImplementation object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>MDeclared Method Implementation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>MDeclared Method Implementation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseMDeclaredMethodImplementation(MDeclaredMethodImplementation object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>MDirect Method Implementation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>MDirect Method Implementation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseMDirectMethodImplementation(MDirectMethodImplementation object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>MMethod Implementation Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>MMethod Implementation Parameter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseMMethodImplementationParameter(MMethodImplementationParameter object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>MConstructor</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>MConstructor</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseMConstructor(MConstructor object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>MConstructor Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>MConstructor Parameter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseMConstructorParameter(MConstructorParameter object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Abstract CStatement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Abstract CStatement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseAbstractCStatement(AbstractCStatement object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>CBlock Statement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>CBlock Statement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseCBlockStatement(CBlockStatement object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>CDeclaration Statement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>CDeclaration Statement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseCDeclarationStatement(CDeclarationStatement object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>CExpression Statement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>CExpression Statement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseCExpressionStatement(CExpressionStatement object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>CIf Statement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>CIf Statement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseCIfStatement(CIfStatement object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>CUnparsed Statement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>CUnparsed Statement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseCUnparsedStatement(CUnparsedStatement object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Abstract CExpression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Abstract CExpression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseAbstractCExpression(AbstractCExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>CConditional Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>CConditional Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseCConditionalExpression(CConditionalExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>CUnparsed Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>CUnparsed Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseCUnparsedExpression(CUnparsedExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	public Object defaultCase(EObject object) {
		return null;
	}

} //ModelSwitch
