package com.KartikeySingh.project.UberApp.Uber_Cl.security;

import com.KartikeySingh.project.UberApp.Uber_Cl.entities.User;
import com.KartikeySingh.project.UberApp.Uber_Cl.services.UserService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.servlet.HandlerExceptionResolver;
@Component
@RequiredArgsConstructor
public class JWTAuthFilter extends OncePerRequestFilter {

        private final JWTService jwtService;// token verify krne k liye
        private final UserService userService;// DB se user fetch krne k liye
        @Autowired // ye yha isliye h kyuki @RequiredArgsConstructor kewal final wale ya fir @Nonnull ko hi inject krta h it is for handlerexception
                     //👇 ka kaam hai “agar controller ya service me exception aaye, to decide karna ki client ko kya response bhejna hai”
        @Qualifier("handlerExceptionResolver")
        private HandlerExceptionResolver handlerExceptionResolver;

        @Override      //👇 ye khud ek inbuilt method nahi hai, lekin iska definition OncePerRequestFilter me already hai as abstract method.
        protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) {
            try {
                final String requestTokenHeader = request.getHeader("Authorization");
                if (requestTokenHeader == null || !requestTokenHeader.startsWith("Bearer"))
                {
                    filterChain.doFilter(request, response);
                    return;
                }

                String token = requestTokenHeader.split("Bearer ")[1];
                Long userId = jwtService.getUserIdFromToken(token);

                if (userId != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                    User user = userService.getUserById(userId);

                    UsernamePasswordAuthenticationToken authenticationToken =
                            new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
                    authenticationToken.setDetails(
                            new WebAuthenticationDetailsSource().buildDetails(request)
                    );

                    SecurityContextHolder.getContext().setAuthentication(authenticationToken);
                }

                filterChain.doFilter(request, response);

            } catch (Exception ex) {
                handlerExceptionResolver.resolveException(request, response, null, ex);
            }

        }
    }

//        doFilterInternal  har request ke liye “check krta h jo bhi filters usme define kroge which could be
//        JWT validation,Logging,Exception handling, Response decide karna sab likha ja sakta hai.
//Jo bhi custom logic aap doFilterInternal me likhte ho, wo har request pe execute hoga.
//
//Agar aapka logic detect kare ki koi condition fail ho gayi (jaise authentication error,
//invalid token, ya koi custom check) → tab aap custom response return kar sakte ho aur request
// aage controller tak nahi jaayegi.
//Agar sab sahi ho → aap filterChain.doFilter(request, response) call karte ho, aur
// request normal flow me controller → service → response tak jata hai.
//
//
//
//
//

