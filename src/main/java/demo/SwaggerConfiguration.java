package demo;

import com.fasterxml.classmate.TypeResolver;
import com.google.common.base.Predicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.async.DeferredResult;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.schema.WildcardType;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.data.rest.configuration.SpringDataRestConfiguration;
//import springfox.documentation.spring.data.rest.configuration.SpringDataRestConfiguration;
import springfox.documentation.spring.web.plugins.Docket;
//import springfox.documentation.swagger.web.DocExpansion;
//import springfox.documentation.swagger.web.ModelRendering;
//import springfox.documentation.swagger.web.OperationsSorter;
import springfox.documentation.swagger.web.SecurityConfiguration;
//import springfox.documentation.swagger.web.SecurityConfigurationBuilder;
//import springfox.documentation.swagger.web.TagsSorter;
import springfox.documentation.swagger.web.UiConfiguration;
//import springfox.documentation.swagger.web.UiConfigurationBuilder;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;

import static com.google.common.collect.Lists.*;
import static springfox.documentation.schema.AlternateTypeRules.*;

import static com.google.common.base.Predicates.*;

//@EnableSwagger2
//@Import(SpringDataRestConfiguration.class)
//@Configuration
//@ComponentScan(basePackageClasses = {
//	    DepartmentRestControler.class
//	})
public class SwaggerConfiguration {
//	@Bean
//	public Docket publicDoc() {
//		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.any())
//				.paths(PathSelectors.any()).build().pathMapping("/")
//				.directModelSubstitute(java.time.LocalDate.class, String.class)
//				.genericModelSubstitutes(ResponseEntity.class)
//				.alternateTypeRules(newRule(
//						typeResolver.resolve(DeferredResult.class,
//								typeResolver.resolve(ResponseEntity.class, WildcardType.class)),
//						typeResolver.resolve(WildcardType.class)))
//				.useDefaultResponseMessages(false)
//				.globalResponseMessage(RequestMethod.GET,
//						newArrayList(new ResponseMessageBuilder().code(500).message("500 message")
//								.responseModel(new ModelRef("Error")).build()))
//				.securitySchemes(newArrayList(apiKey())).securityContexts(newArrayList(securityContext()))
//				.enableUrlTemplating(true)
//				.globalOperationParameters(newArrayList(new ParameterBuilder().name("someGlobalParameter")
//						.description("Description of someGlobalParameter").modelRef(new ModelRef("string"))
//						.parameterType("query").required(true).build()))
//				.tags(new Tag("Pet Service", "All apis relating to pets"));
//	}
//
//	@Autowired
//	private TypeResolver typeResolver;
//
//	private ApiKey apiKey() {
//		return new ApiKey("mykey", "api_key", "header");
//	}
//
//	private SecurityContext securityContext() {
//		return SecurityContext.builder().securityReferences(defaultAuth()).forPaths(PathSelectors.regex("/anyPath.*"))
//				.build();
//	}
//
//	List<SecurityReference> defaultAuth() {
//		AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
//		AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
//		authorizationScopes[0] = authorizationScope;
//		return newArrayList(new SecurityReference("mykey", authorizationScopes));
//	}
//
//	@Bean
//	SecurityConfiguration security() {
//		return SecurityConfigurationBuilder.builder().clientId("test-app-client-id")
//				.clientSecret("test-app-client-secret").realm("test-app-realm").appName("test-app").scopeSeparator(",")
//				.additionalQueryStringParams(null).useBasicAuthenticationWithAccessCodeGrant(false).build();
//	}
//
//	@Bean
//	UiConfiguration uiConfig() {
//		return UiConfigurationBuilder.builder().deepLinking(true).displayOperationId(false).defaultModelsExpandDepth(1)
//				.defaultModelExpandDepth(1).defaultModelRendering(ModelRendering.EXAMPLE).displayRequestDuration(false)
//				.docExpansion(DocExpansion.NONE).filter(false).maxDisplayedTags(null)
//				.operationsSorter(OperationsSorter.ALPHA).showExtensions(false).tagsSorter(TagsSorter.ALPHA)
//				.supportedSubmitMethods(UiConfiguration.Constants.DEFAULT_SUBMIT_METHODS).validatorUrl(null).build();
//	}
//	
	
	
    @Bean
    public Docket publicDocument()
    {
        return new Docket( DocumentationType.SWAGGER_2 ).groupName( "public" )
                .select()
                .paths( paths() )
                .build()
                .apiInfo( apiInfo() );
    }

    private ApiInfo apiInfo()
    {
        ApiInfo apiInfo = new ApiInfo(
                "デモシステム Web API",
                "",
                "",
                "",
                "",
                "",
                "");
        return apiInfo;
    }

    private Predicate<String> paths() {
    	 return or(containsPattern("/*"));  //APIのエントリポイントを正規表現で指定
    }

}