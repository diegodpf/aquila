<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
{
    "vigilanteA": {
        "lat": ${vigilanteA.localizacao.latitude},
        "lng": ${vigilanteA.localizacao.longitude}
    },
    "vigilanteB": {
        "lat": ${vigilanteB.localizacao.latitude},
        "lng": ${vigilanteB.localizacao.longitude}
    }
}
