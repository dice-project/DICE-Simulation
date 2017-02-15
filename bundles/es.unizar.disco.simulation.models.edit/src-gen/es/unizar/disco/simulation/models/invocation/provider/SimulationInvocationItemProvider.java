/**
 */
package es.unizar.disco.simulation.models.invocation.provider;


import es.unizar.disco.simulation.models.invocation.InvocationPackage;
import es.unizar.disco.simulation.models.invocation.SimulationInvocation;

import es.unizar.disco.simulation.models.provider.DiceSimulationModelsEditPlugin;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.eclipse.emf.edit.provider.ViewerNotification;

/**
 * This is the item provider adapter for a {@link es.unizar.disco.simulation.models.invocation.SimulationInvocation} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class SimulationInvocationItemProvider 
	extends ItemProviderAdapter
	implements
		IEditingDomainItemProvider,
		IStructuredItemContentProvider,
		ITreeItemContentProvider,
		IItemLabelProvider,
		IItemPropertySource {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SimulationInvocationItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

			addIdentifierPropertyDescriptor(object);
			addTraceSetPropertyDescriptor(object);
			addToolResultPropertyDescriptor(object);
			addDefinitionPropertyDescriptor(object);
			addResultPropertyDescriptor(object);
			addStartPropertyDescriptor(object);
			addEndPropertyDescriptor(object);
			addStatusPropertyDescriptor(object);
			addVariableConfigurationPropertyDescriptor(object);
			addAnalyzableModelPropertyDescriptor(object);
			addAutoBuildPropertyDescriptor(object);
			addInvocationSetPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Identifier feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addIdentifierPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_SimulationInvocation_identifier_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_SimulationInvocation_identifier_feature", "_UI_SimulationInvocation_type"),
				 InvocationPackage.Literals.SIMULATION_INVOCATION__IDENTIFIER,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Trace Set feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTraceSetPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_SimulationInvocation_traceSet_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_SimulationInvocation_traceSet_feature", "_UI_SimulationInvocation_type"),
				 InvocationPackage.Literals.SIMULATION_INVOCATION__TRACE_SET,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Tool Result feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addToolResultPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_SimulationInvocation_toolResult_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_SimulationInvocation_toolResult_feature", "_UI_SimulationInvocation_type"),
				 InvocationPackage.Literals.SIMULATION_INVOCATION__TOOL_RESULT,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Definition feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addDefinitionPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_SimulationInvocation_definition_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_SimulationInvocation_definition_feature", "_UI_SimulationInvocation_type"),
				 InvocationPackage.Literals.SIMULATION_INVOCATION__DEFINITION,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Result feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addResultPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_SimulationInvocation_result_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_SimulationInvocation_result_feature", "_UI_SimulationInvocation_type"),
				 InvocationPackage.Literals.SIMULATION_INVOCATION__RESULT,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Start feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addStartPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_SimulationInvocation_start_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_SimulationInvocation_start_feature", "_UI_SimulationInvocation_type"),
				 InvocationPackage.Literals.SIMULATION_INVOCATION__START,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the End feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addEndPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_SimulationInvocation_end_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_SimulationInvocation_end_feature", "_UI_SimulationInvocation_type"),
				 InvocationPackage.Literals.SIMULATION_INVOCATION__END,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Status feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addStatusPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_SimulationInvocation_status_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_SimulationInvocation_status_feature", "_UI_SimulationInvocation_type"),
				 InvocationPackage.Literals.SIMULATION_INVOCATION__STATUS,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Variable Configuration feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addVariableConfigurationPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_SimulationInvocation_variableConfiguration_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_SimulationInvocation_variableConfiguration_feature", "_UI_SimulationInvocation_type"),
				 InvocationPackage.Literals.SIMULATION_INVOCATION__VARIABLE_CONFIGURATION,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Analyzable Model feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addAnalyzableModelPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_SimulationInvocation_analyzableModel_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_SimulationInvocation_analyzableModel_feature", "_UI_SimulationInvocation_type"),
				 InvocationPackage.Literals.SIMULATION_INVOCATION__ANALYZABLE_MODEL,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Auto Build feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addAutoBuildPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_SimulationInvocation_autoBuild_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_SimulationInvocation_autoBuild_feature", "_UI_SimulationInvocation_type"),
				 InvocationPackage.Literals.SIMULATION_INVOCATION__AUTO_BUILD,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Invocation Set feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addInvocationSetPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_SimulationInvocation_invocationSet_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_SimulationInvocation_invocationSet_feature", "_UI_SimulationInvocation_type"),
				 InvocationPackage.Literals.SIMULATION_INVOCATION__INVOCATION_SET,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
	 * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
	 * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(InvocationPackage.Literals.SIMULATION_INVOCATION__TRACE_SET);
			childrenFeatures.add(InvocationPackage.Literals.SIMULATION_INVOCATION__TOOL_RESULT);
			childrenFeatures.add(InvocationPackage.Literals.SIMULATION_INVOCATION__DEFINITION);
			childrenFeatures.add(InvocationPackage.Literals.SIMULATION_INVOCATION__RESULT);
			childrenFeatures.add(InvocationPackage.Literals.SIMULATION_INVOCATION__VARIABLE_CONFIGURATION);
			childrenFeatures.add(InvocationPackage.Literals.SIMULATION_INVOCATION__ANALYZABLE_MODEL);
		}
		return childrenFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EStructuralFeature getChildFeature(Object object, Object child) {
		// Check the type of the specified child object and return the proper feature to use for
		// adding (see {@link AddCommand}) it as a child.

		return super.getChildFeature(object, child);
	}

	/**
	 * This returns SimulationInvocation.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/SimulationInvocation"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((SimulationInvocation)object).getIdentifier();
		return label == null || label.length() == 0 ?
			getString("_UI_SimulationInvocation_type") :
			getString("_UI_SimulationInvocation_type") + " " + label;
	}
	

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(SimulationInvocation.class)) {
			case InvocationPackage.SIMULATION_INVOCATION__IDENTIFIER:
			case InvocationPackage.SIMULATION_INVOCATION__START:
			case InvocationPackage.SIMULATION_INVOCATION__END:
			case InvocationPackage.SIMULATION_INVOCATION__STATUS:
			case InvocationPackage.SIMULATION_INVOCATION__AUTO_BUILD:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
	 * that can be created under this object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);
	}

	/**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return DiceSimulationModelsEditPlugin.INSTANCE;
	}

}
