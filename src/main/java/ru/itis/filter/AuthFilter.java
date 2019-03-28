package ru.itis.filter;

import org.springframework.jdbc.datasource.DriverManagerDataSource;
import repositories.AuthRepository;
import repositories.AuthRepositoryImpl;
import repositories.UsersRepository;
import repositories.UsersRepositoryJdbcTemplateImpl;
import services.UsersService;
import services.UsersServiceImpl;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@WebFilter("/shop")
public class AuthFilter implements Filter {

    private UsersService usersService;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setDriverClassName("org.postgresql.Driver");
//        dataSource.setUsername("postgres");
//        dataSource.setPassword("annatugb17");
//        dataSource.setUrl("jdbc:postgresql://localhost:5434/TDC_table");
//        UsersRepository usersRepository = new UsersRepositoryJdbcTemplateImpl(dataSource);
//        AuthRepository authRepository = new AuthRepositoryImpl(dataSource);
//        usersService = new UsersServiceImpl(usersRepository, authRepository);
//    }

        ServletContext context = filterConfig.getServletContext();
        this.usersService = (UsersService) context.getAttribute("userService");

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        HttpServletResponse response = (HttpServletResponse)servletResponse;

        Cookie cookies[] = request.getCookies();

        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("auth")) {
                    if (usersService.isExistByCookie(cookie.getValue())) {
                        chain.doFilter(request, response);
                        return;
                    }
                }
            }
            response.sendRedirect("/signIn");
            return;
        }
        response.sendRedirect("/signIn");
        return;
    }

    @Override
    public void destroy() {

    }
}
