/**
 * <copyright>
 * </copyright>
 *
 * $Id: ModelAdapterFactory.java,v 1.1 2007-02-11 22:29:54 concentus Exp $
 */
package de.hasait.eclipse.ccg.java.model.util;

import de.hasait.eclipse.ccg.java.model.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see de.hasait.eclipse.ccg.java.model.ModelPackage
 * @generated
 */
public class ModelAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static ModelPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = ModelPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch the delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ModelSwitch modelSwitch =
		new ModelSwitch() {
			public Object caseAbstractMPackageContainer(AbstractMPackageContainer object) {
				return createAbstractMPackageContainerAdapter();
			}
			public Object caseMRoot(MRoot object) {
				return createMRootAdapter();
			}
			public Object caseMPackage(MPackage object) {
				return createMPackageAdapter();
			}
			public Object caseAbstractMResource(AbstractMResource object) {
				return createAbstractMResourceAdapter();
			}
			public Object caseMResource(MResource object) {
				return createMResourceAdapter();
			}
			public Object caseAbstractMTypeContainer(AbstractMTypeContainer object) {
				return createAbstractMTypeContainerAdapter();
			}
			public Object caseMCompilationUnit(MCompilationUnit object) {
				return createMCompilationUnitAdapter();
			}
			public Object caseAbstractMDeclaredType(AbstractMDeclaredType object) {
				return createAbstractMDeclaredTypeAdapter();
			}
			public Object caseAbstractMExternalType(AbstractMExternalType object) {
				return createAbstractMExternalTypeAdapter();
			}
			public Object caseAbstractMType(AbstractMType object) {
				return createAbstractMTypeAdapter();
			}
			public Object caseAbstractMTypeReference(AbstractMTypeReference object) {
				return createAbstractMTypeReferenceAdapter();
			}
			public Object caseMDeclaredTypeReference(MDeclaredTypeReference object) {
				return createMDeclaredTypeReferenceAdapter();
			}
			public Object caseMExternalTypeReference(MExternalTypeReference object) {
				return createMExternalTypeReferenceAdapter();
			}
			public Object caseMPrimitiveTypeReference(MPrimitiveTypeReference object) {
				return createMPrimitiveTypeReferenceAdapter();
			}
			public Object caseAbstractModifiers(AbstractModifiers object) {
				return createAbstractModifiersAdapter();
			}
			public Object caseAbstractMMethodLike(AbstractMMethodLike object) {
				return createAbstractMMethodLikeAdapter();
			}
			public Object caseAbstractMTypeWithNameDeclaration(AbstractMTypeWithNameDeclaration object) {
				return createAbstractMTypeWithNameDeclarationAdapter();
			}
			public Object caseAbstractMClass(AbstractMClass object) {
				return createAbstractMClassAdapter();
			}
			public Object caseMDeclaredClass(MDeclaredClass object) {
				return createMDeclaredClassAdapter();
			}
			public Object caseMAbstractDeclaredClass(MAbstractDeclaredClass object) {
				return createMAbstractDeclaredClassAdapter();
			}
			public Object caseMExternalClass(MExternalClass object) {
				return createMExternalClassAdapter();
			}
			public Object caseAbstractMInterface(AbstractMInterface object) {
				return createAbstractMInterfaceAdapter();
			}
			public Object caseMDeclaredInterface(MDeclaredInterface object) {
				return createMDeclaredInterfaceAdapter();
			}
			public Object caseMExternalInterface(MExternalInterface object) {
				return createMExternalInterfaceAdapter();
			}
			public Object caseAbstractMFieldDeclaration(AbstractMFieldDeclaration object) {
				return createAbstractMFieldDeclarationAdapter();
			}
			public Object caseAbstractMClassFieldDeclaration(AbstractMClassFieldDeclaration object) {
				return createAbstractMClassFieldDeclarationAdapter();
			}
			public Object caseMStaticClassFieldDeclaration(MStaticClassFieldDeclaration object) {
				return createMStaticClassFieldDeclarationAdapter();
			}
			public Object caseMInstanceClassFieldDeclaration(MInstanceClassFieldDeclaration object) {
				return createMInstanceClassFieldDeclarationAdapter();
			}
			public Object caseMConstantInterfaceFieldDeclaration(MConstantInterfaceFieldDeclaration object) {
				return createMConstantInterfaceFieldDeclarationAdapter();
			}
			public Object caseAbstractMMethodDeclaration(AbstractMMethodDeclaration object) {
				return createAbstractMMethodDeclarationAdapter();
			}
			public Object caseMMethodDeclarationParameter(MMethodDeclarationParameter object) {
				return createMMethodDeclarationParameterAdapter();
			}
			public Object caseMImplicitMethodDeclaration(MImplicitMethodDeclaration object) {
				return createMImplicitMethodDeclarationAdapter();
			}
			public Object caseAbstractMImplementableMethodDeclaration(AbstractMImplementableMethodDeclaration object) {
				return createAbstractMImplementableMethodDeclarationAdapter();
			}
			public Object caseMAbstractClassMethodDeclaration(MAbstractClassMethodDeclaration object) {
				return createMAbstractClassMethodDeclarationAdapter();
			}
			public Object caseMInterfaceMethodDeclaration(MInterfaceMethodDeclaration object) {
				return createMInterfaceMethodDeclarationAdapter();
			}
			public Object caseMNativeMethodDeclaration(MNativeMethodDeclaration object) {
				return createMNativeMethodDeclarationAdapter();
			}
			public Object caseAbstractMMethodImplementation(AbstractMMethodImplementation object) {
				return createAbstractMMethodImplementationAdapter();
			}
			public Object caseMDeclaredMethodImplementation(MDeclaredMethodImplementation object) {
				return createMDeclaredMethodImplementationAdapter();
			}
			public Object caseMDirectMethodImplementation(MDirectMethodImplementation object) {
				return createMDirectMethodImplementationAdapter();
			}
			public Object caseMMethodImplementationParameter(MMethodImplementationParameter object) {
				return createMMethodImplementationParameterAdapter();
			}
			public Object caseMConstructor(MConstructor object) {
				return createMConstructorAdapter();
			}
			public Object caseMConstructorParameter(MConstructorParameter object) {
				return createMConstructorParameterAdapter();
			}
			public Object caseAbstractCStatement(AbstractCStatement object) {
				return createAbstractCStatementAdapter();
			}
			public Object caseCBlockStatement(CBlockStatement object) {
				return createCBlockStatementAdapter();
			}
			public Object caseCDeclarationStatement(CDeclarationStatement object) {
				return createCDeclarationStatementAdapter();
			}
			public Object caseCExpressionStatement(CExpressionStatement object) {
				return createCExpressionStatementAdapter();
			}
			public Object caseCIfStatement(CIfStatement object) {
				return createCIfStatementAdapter();
			}
			public Object caseCUnparsedStatement(CUnparsedStatement object) {
				return createCUnparsedStatementAdapter();
			}
			public Object caseAbstractCExpression(AbstractCExpression object) {
				return createAbstractCExpressionAdapter();
			}
			public Object caseCConditionalExpression(CConditionalExpression object) {
				return createCConditionalExpressionAdapter();
			}
			public Object caseCUnparsedExpression(CUnparsedExpression object) {
				return createCUnparsedExpressionAdapter();
			}
			public Object defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	public Adapter createAdapter(Notifier target) {
		return (Adapter)modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link de.hasait.eclipse.ccg.java.model.AbstractMPackageContainer <em>Abstract MPackage Container</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.hasait.eclipse.ccg.java.model.AbstractMPackageContainer
	 * @generated
	 */
	public Adapter createAbstractMPackageContainerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.hasait.eclipse.ccg.java.model.MRoot <em>MRoot</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.hasait.eclipse.ccg.java.model.MRoot
	 * @generated
	 */
	public Adapter createMRootAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.hasait.eclipse.ccg.java.model.MPackage <em>MPackage</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.hasait.eclipse.ccg.java.model.MPackage
	 * @generated
	 */
	public Adapter createMPackageAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.hasait.eclipse.ccg.java.model.AbstractMResource <em>Abstract MResource</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.hasait.eclipse.ccg.java.model.AbstractMResource
	 * @generated
	 */
	public Adapter createAbstractMResourceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.hasait.eclipse.ccg.java.model.MResource <em>MResource</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.hasait.eclipse.ccg.java.model.MResource
	 * @generated
	 */
	public Adapter createMResourceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.hasait.eclipse.ccg.java.model.AbstractMTypeContainer <em>Abstract MType Container</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.hasait.eclipse.ccg.java.model.AbstractMTypeContainer
	 * @generated
	 */
	public Adapter createAbstractMTypeContainerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.hasait.eclipse.ccg.java.model.MCompilationUnit <em>MCompilation Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.hasait.eclipse.ccg.java.model.MCompilationUnit
	 * @generated
	 */
	public Adapter createMCompilationUnitAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.hasait.eclipse.ccg.java.model.AbstractMDeclaredType <em>Abstract MDeclared Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.hasait.eclipse.ccg.java.model.AbstractMDeclaredType
	 * @generated
	 */
	public Adapter createAbstractMDeclaredTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.hasait.eclipse.ccg.java.model.AbstractMExternalType <em>Abstract MExternal Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.hasait.eclipse.ccg.java.model.AbstractMExternalType
	 * @generated
	 */
	public Adapter createAbstractMExternalTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.hasait.eclipse.ccg.java.model.AbstractMType <em>Abstract MType</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.hasait.eclipse.ccg.java.model.AbstractMType
	 * @generated
	 */
	public Adapter createAbstractMTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.hasait.eclipse.ccg.java.model.AbstractMTypeReference <em>Abstract MType Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.hasait.eclipse.ccg.java.model.AbstractMTypeReference
	 * @generated
	 */
	public Adapter createAbstractMTypeReferenceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.hasait.eclipse.ccg.java.model.MDeclaredTypeReference <em>MDeclared Type Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.hasait.eclipse.ccg.java.model.MDeclaredTypeReference
	 * @generated
	 */
	public Adapter createMDeclaredTypeReferenceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.hasait.eclipse.ccg.java.model.MExternalTypeReference <em>MExternal Type Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.hasait.eclipse.ccg.java.model.MExternalTypeReference
	 * @generated
	 */
	public Adapter createMExternalTypeReferenceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.hasait.eclipse.ccg.java.model.MPrimitiveTypeReference <em>MPrimitive Type Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.hasait.eclipse.ccg.java.model.MPrimitiveTypeReference
	 * @generated
	 */
	public Adapter createMPrimitiveTypeReferenceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.hasait.eclipse.ccg.java.model.AbstractModifiers <em>Abstract Modifiers</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.hasait.eclipse.ccg.java.model.AbstractModifiers
	 * @generated
	 */
	public Adapter createAbstractModifiersAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.hasait.eclipse.ccg.java.model.AbstractMMethodLike <em>Abstract MMethod Like</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.hasait.eclipse.ccg.java.model.AbstractMMethodLike
	 * @generated
	 */
	public Adapter createAbstractMMethodLikeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.hasait.eclipse.ccg.java.model.AbstractMTypeWithNameDeclaration <em>Abstract MType With Name Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.hasait.eclipse.ccg.java.model.AbstractMTypeWithNameDeclaration
	 * @generated
	 */
	public Adapter createAbstractMTypeWithNameDeclarationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.hasait.eclipse.ccg.java.model.AbstractMClass <em>Abstract MClass</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.hasait.eclipse.ccg.java.model.AbstractMClass
	 * @generated
	 */
	public Adapter createAbstractMClassAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.hasait.eclipse.ccg.java.model.MDeclaredClass <em>MDeclared Class</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.hasait.eclipse.ccg.java.model.MDeclaredClass
	 * @generated
	 */
	public Adapter createMDeclaredClassAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.hasait.eclipse.ccg.java.model.MAbstractDeclaredClass <em>MAbstract Declared Class</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.hasait.eclipse.ccg.java.model.MAbstractDeclaredClass
	 * @generated
	 */
	public Adapter createMAbstractDeclaredClassAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.hasait.eclipse.ccg.java.model.MExternalClass <em>MExternal Class</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.hasait.eclipse.ccg.java.model.MExternalClass
	 * @generated
	 */
	public Adapter createMExternalClassAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.hasait.eclipse.ccg.java.model.AbstractMInterface <em>Abstract MInterface</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.hasait.eclipse.ccg.java.model.AbstractMInterface
	 * @generated
	 */
	public Adapter createAbstractMInterfaceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.hasait.eclipse.ccg.java.model.MDeclaredInterface <em>MDeclared Interface</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.hasait.eclipse.ccg.java.model.MDeclaredInterface
	 * @generated
	 */
	public Adapter createMDeclaredInterfaceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.hasait.eclipse.ccg.java.model.MExternalInterface <em>MExternal Interface</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.hasait.eclipse.ccg.java.model.MExternalInterface
	 * @generated
	 */
	public Adapter createMExternalInterfaceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.hasait.eclipse.ccg.java.model.AbstractMFieldDeclaration <em>Abstract MField Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.hasait.eclipse.ccg.java.model.AbstractMFieldDeclaration
	 * @generated
	 */
	public Adapter createAbstractMFieldDeclarationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.hasait.eclipse.ccg.java.model.AbstractMClassFieldDeclaration <em>Abstract MClass Field Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.hasait.eclipse.ccg.java.model.AbstractMClassFieldDeclaration
	 * @generated
	 */
	public Adapter createAbstractMClassFieldDeclarationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.hasait.eclipse.ccg.java.model.MStaticClassFieldDeclaration <em>MStatic Class Field Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.hasait.eclipse.ccg.java.model.MStaticClassFieldDeclaration
	 * @generated
	 */
	public Adapter createMStaticClassFieldDeclarationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.hasait.eclipse.ccg.java.model.MInstanceClassFieldDeclaration <em>MInstance Class Field Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.hasait.eclipse.ccg.java.model.MInstanceClassFieldDeclaration
	 * @generated
	 */
	public Adapter createMInstanceClassFieldDeclarationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.hasait.eclipse.ccg.java.model.MConstantInterfaceFieldDeclaration <em>MConstant Interface Field Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.hasait.eclipse.ccg.java.model.MConstantInterfaceFieldDeclaration
	 * @generated
	 */
	public Adapter createMConstantInterfaceFieldDeclarationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.hasait.eclipse.ccg.java.model.AbstractMMethodDeclaration <em>Abstract MMethod Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.hasait.eclipse.ccg.java.model.AbstractMMethodDeclaration
	 * @generated
	 */
	public Adapter createAbstractMMethodDeclarationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.hasait.eclipse.ccg.java.model.MMethodDeclarationParameter <em>MMethod Declaration Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.hasait.eclipse.ccg.java.model.MMethodDeclarationParameter
	 * @generated
	 */
	public Adapter createMMethodDeclarationParameterAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.hasait.eclipse.ccg.java.model.MImplicitMethodDeclaration <em>MImplicit Method Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.hasait.eclipse.ccg.java.model.MImplicitMethodDeclaration
	 * @generated
	 */
	public Adapter createMImplicitMethodDeclarationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.hasait.eclipse.ccg.java.model.AbstractMImplementableMethodDeclaration <em>Abstract MImplementable Method Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.hasait.eclipse.ccg.java.model.AbstractMImplementableMethodDeclaration
	 * @generated
	 */
	public Adapter createAbstractMImplementableMethodDeclarationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.hasait.eclipse.ccg.java.model.MAbstractClassMethodDeclaration <em>MAbstract Class Method Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.hasait.eclipse.ccg.java.model.MAbstractClassMethodDeclaration
	 * @generated
	 */
	public Adapter createMAbstractClassMethodDeclarationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.hasait.eclipse.ccg.java.model.MInterfaceMethodDeclaration <em>MInterface Method Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.hasait.eclipse.ccg.java.model.MInterfaceMethodDeclaration
	 * @generated
	 */
	public Adapter createMInterfaceMethodDeclarationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.hasait.eclipse.ccg.java.model.MNativeMethodDeclaration <em>MNative Method Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.hasait.eclipse.ccg.java.model.MNativeMethodDeclaration
	 * @generated
	 */
	public Adapter createMNativeMethodDeclarationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.hasait.eclipse.ccg.java.model.AbstractMMethodImplementation <em>Abstract MMethod Implementation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.hasait.eclipse.ccg.java.model.AbstractMMethodImplementation
	 * @generated
	 */
	public Adapter createAbstractMMethodImplementationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.hasait.eclipse.ccg.java.model.MDeclaredMethodImplementation <em>MDeclared Method Implementation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.hasait.eclipse.ccg.java.model.MDeclaredMethodImplementation
	 * @generated
	 */
	public Adapter createMDeclaredMethodImplementationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.hasait.eclipse.ccg.java.model.MDirectMethodImplementation <em>MDirect Method Implementation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.hasait.eclipse.ccg.java.model.MDirectMethodImplementation
	 * @generated
	 */
	public Adapter createMDirectMethodImplementationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.hasait.eclipse.ccg.java.model.MMethodImplementationParameter <em>MMethod Implementation Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.hasait.eclipse.ccg.java.model.MMethodImplementationParameter
	 * @generated
	 */
	public Adapter createMMethodImplementationParameterAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.hasait.eclipse.ccg.java.model.MConstructor <em>MConstructor</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.hasait.eclipse.ccg.java.model.MConstructor
	 * @generated
	 */
	public Adapter createMConstructorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.hasait.eclipse.ccg.java.model.MConstructorParameter <em>MConstructor Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.hasait.eclipse.ccg.java.model.MConstructorParameter
	 * @generated
	 */
	public Adapter createMConstructorParameterAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.hasait.eclipse.ccg.java.model.AbstractCStatement <em>Abstract CStatement</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.hasait.eclipse.ccg.java.model.AbstractCStatement
	 * @generated
	 */
	public Adapter createAbstractCStatementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.hasait.eclipse.ccg.java.model.CBlockStatement <em>CBlock Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.hasait.eclipse.ccg.java.model.CBlockStatement
	 * @generated
	 */
	public Adapter createCBlockStatementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.hasait.eclipse.ccg.java.model.CDeclarationStatement <em>CDeclaration Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.hasait.eclipse.ccg.java.model.CDeclarationStatement
	 * @generated
	 */
	public Adapter createCDeclarationStatementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.hasait.eclipse.ccg.java.model.CExpressionStatement <em>CExpression Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.hasait.eclipse.ccg.java.model.CExpressionStatement
	 * @generated
	 */
	public Adapter createCExpressionStatementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.hasait.eclipse.ccg.java.model.CIfStatement <em>CIf Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.hasait.eclipse.ccg.java.model.CIfStatement
	 * @generated
	 */
	public Adapter createCIfStatementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.hasait.eclipse.ccg.java.model.CUnparsedStatement <em>CUnparsed Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.hasait.eclipse.ccg.java.model.CUnparsedStatement
	 * @generated
	 */
	public Adapter createCUnparsedStatementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.hasait.eclipse.ccg.java.model.AbstractCExpression <em>Abstract CExpression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.hasait.eclipse.ccg.java.model.AbstractCExpression
	 * @generated
	 */
	public Adapter createAbstractCExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.hasait.eclipse.ccg.java.model.CConditionalExpression <em>CConditional Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.hasait.eclipse.ccg.java.model.CConditionalExpression
	 * @generated
	 */
	public Adapter createCConditionalExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.hasait.eclipse.ccg.java.model.CUnparsedExpression <em>CUnparsed Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.hasait.eclipse.ccg.java.model.CUnparsedExpression
	 * @generated
	 */
	public Adapter createCUnparsedExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //ModelAdapterFactory
