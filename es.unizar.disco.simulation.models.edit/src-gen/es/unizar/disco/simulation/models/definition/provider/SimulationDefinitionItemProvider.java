/**
 */
package es.unizar.disco.simulation.models.definition.provider;


import es.unizar.disco.simulation.models.definition.DefinitionFactory;
import es.unizar.disco.simulation.models.definition.DefinitionPackage;
import es.unizar.disco.simulation.models.definition.SimulationDefinition;

import es.unizar.disco.simulation.models.measures.MeasuresFactory;

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
 * This is the item provider adapter for a {@link es.unizar.disco.simulation.models.definition.SimulationDefinition} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class SimulationDefinitionItemProvider 
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
	public SimulationDefinitionItemProvider(AdapterFactory adapterFactory) {
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
			addMaxExecutionTimePropertyDescriptor(object);
			addMeasuresToComputePropertyDescriptor(object);
			addBackendPropertyDescriptor(object);
			addActiveConfigurationsPropertyDescriptor(object);
			addAutoSyncPropertyDescriptor(object);
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
				 getString("_UI_SimulationDefinition_identifier_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_SimulationDefinition_identifier_feature", "_UI_SimulationDefinition_type"),
				 DefinitionPackage.Literals.SIMULATION_DEFINITION__IDENTIFIER,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Max Execution Time feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addMaxExecutionTimePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_SimulationDefinition_maxExecutionTime_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_SimulationDefinition_maxExecutionTime_feature", "_UI_SimulationDefinition_type"),
				 DefinitionPackage.Literals.SIMULATION_DEFINITION__MAX_EXECUTION_TIME,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Measures To Compute feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addMeasuresToComputePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_SimulationDefinition_measuresToCompute_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_SimulationDefinition_measuresToCompute_feature", "_UI_SimulationDefinition_type"),
				 DefinitionPackage.Literals.SIMULATION_DEFINITION__MEASURES_TO_COMPUTE,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Backend feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addBackendPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_SimulationDefinition_backend_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_SimulationDefinition_backend_feature", "_UI_SimulationDefinition_type"),
				 DefinitionPackage.Literals.SIMULATION_DEFINITION__BACKEND,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Active Configurations feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addActiveConfigurationsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_SimulationDefinition_activeConfigurations_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_SimulationDefinition_activeConfigurations_feature", "_UI_SimulationDefinition_type"),
				 DefinitionPackage.Literals.SIMULATION_DEFINITION__ACTIVE_CONFIGURATIONS,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Auto Sync feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addAutoSyncPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_SimulationDefinition_autoSync_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_SimulationDefinition_autoSync_feature", "_UI_SimulationDefinition_type"),
				 DefinitionPackage.Literals.SIMULATION_DEFINITION__AUTO_SYNC,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
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
			childrenFeatures.add(DefinitionPackage.Literals.SIMULATION_DEFINITION__INVOCATIONS);
			childrenFeatures.add(DefinitionPackage.Literals.SIMULATION_DEFINITION__PARAMETERS);
			childrenFeatures.add(DefinitionPackage.Literals.SIMULATION_DEFINITION__ACTIVE_SCENARIO);
			childrenFeatures.add(DefinitionPackage.Literals.SIMULATION_DEFINITION__INPUT_VARIABLES);
			childrenFeatures.add(DefinitionPackage.Literals.SIMULATION_DEFINITION__OUTPUT_VARIABLES);
			childrenFeatures.add(DefinitionPackage.Literals.SIMULATION_DEFINITION__DECLARED_MEASURES);
			childrenFeatures.add(DefinitionPackage.Literals.SIMULATION_DEFINITION__POSSIBLE_CONFIGURATIONS);
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
	 * This returns SimulationDefinition.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/SimulationDefinition"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((SimulationDefinition)object).getIdentifier();
		return label == null || label.length() == 0 ?
			getString("_UI_SimulationDefinition_type") :
			getString("_UI_SimulationDefinition_type") + " " + label;
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

		switch (notification.getFeatureID(SimulationDefinition.class)) {
			case DefinitionPackage.SIMULATION_DEFINITION__IDENTIFIER:
			case DefinitionPackage.SIMULATION_DEFINITION__DOMAIN_RESOURCE:
			case DefinitionPackage.SIMULATION_DEFINITION__MAX_EXECUTION_TIME:
			case DefinitionPackage.SIMULATION_DEFINITION__BACKEND:
			case DefinitionPackage.SIMULATION_DEFINITION__AUTO_SYNC:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case DefinitionPackage.SIMULATION_DEFINITION__PARAMETERS:
			case DefinitionPackage.SIMULATION_DEFINITION__INPUT_VARIABLES:
			case DefinitionPackage.SIMULATION_DEFINITION__OUTPUT_VARIABLES:
			case DefinitionPackage.SIMULATION_DEFINITION__DECLARED_MEASURES:
			case DefinitionPackage.SIMULATION_DEFINITION__POSSIBLE_CONFIGURATIONS:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
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

		newChildDescriptors.add
			(createChildParameter
				(DefinitionPackage.Literals.SIMULATION_DEFINITION__PARAMETERS,
				 DefinitionFactory.eINSTANCE.create(DefinitionPackage.Literals.SIMULATION_PARAMETER)));

		newChildDescriptors.add
			(createChildParameter
				(DefinitionPackage.Literals.SIMULATION_DEFINITION__INPUT_VARIABLES,
				 DefinitionFactory.eINSTANCE.createInputVariable()));

		newChildDescriptors.add
			(createChildParameter
				(DefinitionPackage.Literals.SIMULATION_DEFINITION__OUTPUT_VARIABLES,
				 DefinitionFactory.eINSTANCE.createOutputVariable()));

		newChildDescriptors.add
			(createChildParameter
				(DefinitionPackage.Literals.SIMULATION_DEFINITION__DECLARED_MEASURES,
				 MeasuresFactory.eINSTANCE.createDomainMeasureDefinition()));

		newChildDescriptors.add
			(createChildParameter
				(DefinitionPackage.Literals.SIMULATION_DEFINITION__POSSIBLE_CONFIGURATIONS,
				 DefinitionFactory.eINSTANCE.createVariableConfiguration()));
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
