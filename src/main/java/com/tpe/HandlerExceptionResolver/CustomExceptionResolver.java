package com.tpe.HandlerExceptionResolver;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

public class CustomExceptionResolver implements HandlerExceptionResolver {

    @Override
    public ModelAndView resolveException(HttpServletRequest request,
                                         HttpServletResponse response,
                                         Object handler,
                                         Exception ex) {
        ModelAndView mav = new ModelAndView();
        if (ex instanceof ProductNotFoundException) {
            mav.setViewName("productNotFound");
            mav.addObject("errorMessage", "Ürün bulunamadı: " + ex.getMessage());
        } else if (ex instanceof DatabaseException) {
            mav.setViewName("databaseError");
            mav.addObject("errorMessage", "Veritabanı hatası: " + ex.getMessage());
        } else {
            mav.setViewName("error");
            mav.addObject("errorMessage", "Bir hata oluştu: " + ex.getMessage());
        }
        return mav;
    }
}