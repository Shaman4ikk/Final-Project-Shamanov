package filter;

import app.entities.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class SignupFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String path = request.getRequestURI().substring(request.getContextPath().length());
        // sign, reg. не требует пользователя
        if (path.equals("/actionPages/LogOut.jsp") || path.equals("/") || path.equals("/signIn") || path.equals("/reg")  || path.equals("/setLang") || path.equals("/index.jsp") || path.equals("/actionPages/errorPage.jsp") ) {
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        switch (user.getRoot()) {
            case "admin": {
                // все доступные пути для админа, jsp странички тоже(типо actionPages/searchPage.jsp)
                if (path.equals("/redBook") || path.equals("/admin") || path.equals("/deleteBook")
                        || path.equals("/addBook") || path.equals("/redLibr") || path.equals("/addLibr") || path.equals("/deleteLibr")
                        || path.equals("/getUsersAdm") || path.equals("/setBan") || path.equals("/unBan")) {
                    filterChain.doFilter(servletRequest, servletResponse);
                } else {
                    response.sendRedirect("actionPages/errorPage.jsp");
                }
                return;
            }
            case "user": {
                if (path.equals("/returnBook") ||path.equals("/actionPages/accountPage.jsp") ||path.equals("/searchBook") || path.equals("/UserAcc") || path.equals("/bookList") || path.equals("/AddBook")) {
                    filterChain.doFilter(servletRequest, servletResponse);
                }
                else {
                    response.sendRedirect("actionPages/errorPage.jsp");

                }
                return;
            }
            case "librarian": {
                if (path.equals("/OrderUserBook") || path.equals("/status") || path.equals("/getUsers") || path.equals("/wait")
                        || path.equals("/subscription") || path.equals("/readRoom") || path.equals("/rootPages/librPage.jsp")) {
                    filterChain.doFilter(servletRequest, servletResponse);
                }
                else {
                    response.sendRedirect("actionPages/errorPage.jsp");
                }
                return;
            }
            default:
                //перенаправление на ошибку
                response.sendRedirect("/actionPages/errorPage.jsp");
        }
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }
}
