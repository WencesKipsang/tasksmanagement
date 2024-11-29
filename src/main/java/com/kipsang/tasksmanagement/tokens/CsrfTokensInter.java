package com.kipsang.tasksmanagement.tokens;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;

public interface CsrfTokensInter {
    public CsrfToken getCsrfToken(HttpServletRequest request);
}

