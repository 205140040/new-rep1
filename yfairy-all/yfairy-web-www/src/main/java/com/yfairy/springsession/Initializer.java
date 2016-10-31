package com.yfairy.springsession;

import org.springframework.session.web.context.AbstractHttpSessionApplicationInitializer;

public class Initializer extends AbstractHttpSessionApplicationInitializer { // <1>

	/**
	 * 载入配置, The first step is to extend
	 * AbstractHttpSessionApplicationInitializer. This ensures that the Spring
	 * Bean by the name springSessionRepositoryFilter is registered with our
	 * Servlet Container for every request.
	 * AbstractHttpSessionApplicationInitializer also provides a mechanism to
	 * easily ensure Spring loads our Config.
	 */
	public Initializer() {
		super(Config.class); // <2>
	}
}
