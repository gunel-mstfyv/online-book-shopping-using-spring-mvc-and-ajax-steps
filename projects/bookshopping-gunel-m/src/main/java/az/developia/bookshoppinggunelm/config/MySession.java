package az.developia.bookshoppinggunelm.config;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Component
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
@Getter
@Setter
public class MySession {
	private String username;

	public MySession() {
		Authentication loggerInUser = SecurityContextHolder.getContext().getAuthentication();
		String username = loggerInUser.getName();
		this.username = username;
	}

}
