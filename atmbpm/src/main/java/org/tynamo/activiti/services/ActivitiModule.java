package org.tynamo.activiti.services;

import org.activiti.engine.*;
import org.activiti.engine.impl.cfg.StandaloneProcessEngineConfiguration;
import org.activiti.engine.repository.DeploymentBuilder;
import org.apache.tapestry5.ioc.*;
import org.apache.tapestry5.ioc.annotations.Local;
import org.apache.tapestry5.ioc.internal.util.ClasspathResource;
import org.apache.tapestry5.ioc.services.PropertyShadowBuilder;
import org.apache.tapestry5.ioc.services.SymbolSource;
import org.apache.tapestry5.ioc.services.TypeCoercer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tynamo.activiti.ActivitiSymbols;
import org.tynamo.activiti.TapestryExpressionManager;

import java.io.IOException;
import java.util.Collection;

/**
 * Defines the Activiti services {@link ProcessEngine},
 * {@link RepositoryService}, {@link RuntimeService}, {@link FormService},
 * {@link TaskService}, {@link HistoryService} and {@link ManagementService}.
 */
public class ActivitiModule {

	private static Logger log = LoggerFactory.getLogger(ActivitiModule.class);

	public static void bind(ServiceBinder binder) {
	}

	/**
	 * Configure the defaults for Activiti, most of these values were obtained
	 * from the User's Guide and are Activit's defaults.
	 */
	public static void contributeFactoryDefaults(MappedConfiguration<String, String> configuration) {
//		configuration.add(ActivitiSymbols.USE_DEFAULT_SYMBOLS_BASED_CONFIGURER, true);

		// config mail information
		configuration.add(ActivitiSymbols.MAIL_SERVER_HOST, "192.168.10.77");
		configuration.add(ActivitiSymbols.MAIL_SERVER_PORT, "25");
		configuration.add(ActivitiSymbols.MAIL_SERVER_DEFAULT_FROM,"antivirus@tradewin.cn");
		configuration.add(ActivitiSymbols.MAIL_SERVER_USERNAME, "antivirus@tradewin.cn");
		configuration.add(ActivitiSymbols.MAIL_SERVER_PASSWORD, "antivirus");

		// config database information
		configuration.add(ActivitiSymbols.DATABASE_TYPE, "mysql");
		configuration.add(ActivitiSymbols.DATABASE_SCHEMA_UPDATE, "false");
		configuration.add(ActivitiSymbols.DB_JNDI_NAME, "java:comp/env/jdbc/atm");
	}

	/**
	 * build the StandaloneProcessEngineConfiguration Object
	 * @param symbolSource
	 * @param typeCoercer
	 * @param objectLocator
	 * @return
	 */
	public static ProcessEngineConfiguration buildProcessEngineConfiguration(
			final SymbolSource symbolSource, final TypeCoercer typeCoercer,
			final ObjectLocator objectLocator) {

		StandaloneProcessEngineConfiguration cfg = new StandaloneProcessEngineConfiguration();
		// JtaProcessEngineConfiguration cfg =  new JtaProcessEngineConfiguration();
		
		cfg.setActivityFontName("Microsoft YaHei");
		cfg.setLabelFontName("Microsoft YaHei");
		cfg.setExpressionManager(new TapestryExpressionManager(objectLocator));

		// mail configuration
		cfg.setMailServerHost(symbolSource.valueForSymbol(ActivitiSymbols.MAIL_SERVER_HOST));
		cfg.setMailServerPort(typeCoercer.coerce(symbolSource.valueForSymbol(ActivitiSymbols.MAIL_SERVER_PORT), Integer.class));
		cfg.setMailServerDefaultFrom(symbolSource.valueForSymbol(ActivitiSymbols.MAIL_SERVER_DEFAULT_FROM));
		cfg.setMailServerUsername(symbolSource.valueForSymbol(ActivitiSymbols.MAIL_SERVER_USERNAME));
		cfg.setMailServerPassword(symbolSource.valueForSymbol(ActivitiSymbols.MAIL_SERVER_PASSWORD));
		
		// database configuration
		cfg.setDatabaseSchemaUpdate(symbolSource.valueForSymbol(ActivitiSymbols.DATABASE_SCHEMA_UPDATE));
		cfg.setDatabaseType(symbolSource.valueForSymbol(ActivitiSymbols.DATABASE_TYPE));
		cfg.setDataSourceJndiName(symbolSource.valueForSymbol(ActivitiSymbols.DB_JNDI_NAME));

		cfg.setJobExecutorActivate(false);
		cfg.setAsyncExecutorEnabled(true);
		cfg.setAsyncExecutorActivate(true);

		// History configuration
//		cfg.setHistory("audit");
		return cfg;
	}

	public static ProcessEngine buildProcessEngine(
			@Local ProcessEngineConfiguration processEngineConfiguration,
			Collection<Resource> processes) throws IOException {

		// construct ProcessEngine engine based on ProcessEngineConfiguration
		ProcessEngine engine = processEngineConfiguration.buildProcessEngine();

		// deploy the process resource
		DeploymentBuilder deployment = engine.getRepositoryService().createDeployment()
				// This option ensure that processes are deployed only if they
				// are new or do not have any changes in comparison to the
				// latest revision in the database.
				.enableDuplicateFiltering().name("AtmAutoDeployment");

		for (Resource resource : processes) {
			log.info("Auto deploying process " + resource.getFile());
			deployment.addInputStream(resource.getFile(), resource.openStream());
		}
		deployment.deploy();
		return engine;
	}

	/**
	 * deploy process definition to the Process engine
	 * @param deploymentResources
	 */
	public void contributeProcessEngine(Configuration<Resource> deploymentResources) {
		deploymentResources.add(new ClasspathResource("diagrams/VacationRequest.bpmn20.xml"));
		deploymentResources.add(new ClasspathResource("diagrams/VacationRequest.png"));
	}
	
	/**
	 * Configure Tapestry service for {@link RepositoryService}.
	 */
	public static RepositoryService buildRepositoryService(
			@Local ProcessEngine processEngine,
			PropertyShadowBuilder propertyShadowBuilder) {
		return propertyShadowBuilder.build(processEngine, "repositoryService", RepositoryService.class);
	}

	/**
	 * Configure Tapestry service for {@link RuntimeService}.
	 */
	public static RuntimeService buildRuntimeService(
			@Local ProcessEngine processEngine,
			PropertyShadowBuilder propertyShadowBuilder) {
		return propertyShadowBuilder.build(processEngine, "runtimeService", RuntimeService.class);
	}

	/**
	 * Configure Tapestry service for {@link FormService}.
	 */
	public static FormService buildFormService(
			@Local ProcessEngine processEngine,
			PropertyShadowBuilder propertyShadowBuilder) {
		return propertyShadowBuilder.build(processEngine, "formService", FormService.class);
	}

	/**
	 * Configure Tapestry service for {@link TaskService}.
	 */
	public static TaskService buildTaskService(
			@Local ProcessEngine processEngine,
			PropertyShadowBuilder propertyShadowBuilder) {
		return propertyShadowBuilder.build(processEngine, "taskService", TaskService.class);
	}

	/**
	 * Configure Tapestry service for {@link HistoryService}.
	 */
	public static HistoryService buildHistoryService(
			@Local ProcessEngine processEngine,
			PropertyShadowBuilder propertyShadowBuilder) {
		return propertyShadowBuilder.build(processEngine, "historyService", HistoryService.class);
	}

	/**
	 * Configure Tapestry service for {@link ManagementService}.
	 */
	public static ManagementService buildManagementService(
			@Local ProcessEngine processEngine,
			PropertyShadowBuilder propertyShadowBuilder) {
		return propertyShadowBuilder.build(processEngine, "managementService", ManagementService.class);
	}
	
	public static IdentityService buildIdentityService(
			@Local ProcessEngine processEngine,
			PropertyShadowBuilder propertyShadowBuilder) {
		return propertyShadowBuilder.build(processEngine, "identityService", IdentityService.class);
	}
}