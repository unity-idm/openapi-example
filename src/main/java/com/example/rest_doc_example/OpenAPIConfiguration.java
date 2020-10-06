package com.example.rest_doc_example;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.OAuthFlow;
import io.swagger.v3.oas.models.security.OAuthFlows;
import io.swagger.v3.oas.models.security.Scopes;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;

@OpenAPIDefinition 
@Component
class OpenAPIConfiguration
{
    @Bean
    public OpenAPI customOpenAPI(@Value("${springdoc.version}") String appVersion) 
    {
    	final String bearerSchemeName = "bearerAuth";
    	final String oauthSchemaName = "authorizationCode";
        return new OpenAPI()
        	.info(new Info()
    			.title("Cake API")
    			.version(appVersion)
    			//https://github.com/Redocly/redoc/blob/master/docs/redoc-vendor-extensions.md#x-logo
    			.extensions(ImmutableMap.of("x-logo", ImmutableMap.of("url", "https://www.unity-idm.eu/wp-content/uploads/2020/05/logo-h500.png")))
				.description("This is a sample of Cake server created using springdocs - a library for OpenAPI 3 with spring boot.")
				.license(new License().name("Apache 2.0")
						.url("https://www.apache.org/licenses/LICENSE-2.0")))
			.servers(ImmutableList.of(new Server()
					.url("https//external-host.com")
					.description("Development host")))
			.addSecurityItem(new SecurityRequirement().addList(bearerSchemeName))
			.addSecurityItem(new SecurityRequirement().addList(oauthSchemaName))
			.components(new Components()
					.addSecuritySchemes(bearerSchemeName, 
							new SecurityScheme()
								.name(bearerSchemeName)
								.type(SecurityScheme.Type.HTTP)
								.scheme("bearer"))
					.addSecuritySchemes(oauthSchemaName, 
							new SecurityScheme()
								.name(oauthSchemaName)
								.type(SecurityScheme.Type.OAUTH2)
								.description("For more information, see https://api.slack.com/docs/oauth")
								.flows(new OAuthFlows()
										.authorizationCode(new OAuthFlow()
												.authorizationUrl("https://slack.com/oauth/authorize")
												.tokenUrl("https://slack.com/api/oauth.access")
												.scopes(new Scopes()
														.addString("users:read", "Read user information")
														.addString("im:read", "Read messages"))))));
    }
}
