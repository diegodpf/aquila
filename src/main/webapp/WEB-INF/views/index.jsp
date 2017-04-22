<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <link type="text/css" rel="stylesheet" href="/resources/css/materialize.min.css"  media="screen,projection"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <style>
        #map {
            height: 550px;
            width: 100%;
        }
    </style>
</head>

<body>

    <div class="row purple darken-4" style="margin-bottom: 0;">
        <div class="col s12">
            <ul class="tabs purple darken-4">
                <li class="tab col s4"><a href="#hist"><i class=" material-icons white-text" style="line-height: 48px;">today</i></a></li>
                <li class="tab col s4"><a class="active" href="#mapWrapper"><img src="/resources/img/logo.png" style="margin-top:10px;"></a></li>
                <li class="tab col s4"><a href="#config"><i class="material-icons white-text" style="line-height: 48px;">settings</i></a></li>
            </ul>
        </div>
    </div>

    <div id="hist" class="col s12">Test 1</div>

    <div id="mapWrapper" class="row">
        <div id="map"></div>
    </div>

    <div id="config" class="col s12">
        <div class="row">
            <div class="col s12">
                <div class="card-panel">
                    <p><strong> Notificações </strong></p>
                    <div class="switch right">
                        <label>
                            Off
                            <input type="checkbox">
                            <span class="lever"></span>
                            On
                        </label>
                    </div>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col s12">
                <div class="card-panel">
                    <p><strong>Pagamento</strong></p>
                    <div class="input-field col s12">
                        <i class="material-icons prefix">payment</i>
                        <input id="icon_telephone" type="tel" class="validate">
                        <label for="icon_telephone">Nº do Cartão</label>
                        <button class="btn waves-effect waves-light right purple darken-4" type="submit" name="action" style="margin: 15px 0 20px;">Cadastrar
                            <i class="material-icons right">send</i>
                        </button>
                    </div>
                    <p class="disabled selected"><i class="material-icons prefix">payment</i>
                        <label for="icon_telephone">XXX.005</label>
                        <input type="checkbox" class="filled-in" checked="checked" /></p>
                    <p class="disabled selected"><i class="material-icons prefix">web</i>
                        <label for="icon_telephone">Boleto</label>
                        <input type="checkbox" class="filled-in" checked="checked" /></p>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col s12">
                <div class="card-panel">
                    <p><strong>Sobre</strong></p>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col s12">
                <div class="card-panel">
                    <p><strong>Políticas de Uso</strong></p>
                </div>
            </div>
        </div>
    </div>

    <script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
    <script type="text/javascript" src="/resources/js/materialize.min.js"></script>
    <script async defer
            src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAX-KFVkK5dFntDih5yXIl1fVoen1GupsI&callback=initMap">
    </script>

    <script type="text/javascript">
        function initMap() {
            var centerLocal = {lat: ${usuario.localizacao.latitude}, lng: ${usuario.localizacao.longitude}};
            var map = new google.maps.Map(document.getElementById('map'), {
                zoom: 16,
                center: centerLocal
            });

            var m = new google.maps.Marker({
                position: centerLocal,
                map: map,
                icon: 'http://maps.google.com/mapfiles/ms/icons/green-dot.png'
            });

            var markers = {};
            var idA;
            var idB;

            setInterval(function() {
                $.get("/vigilantes", function(data) {
                    var markerA = markers[idA];
                    if (markerA != null) {
                        markerA.setMap(null);
                    }

                    var markerB = markers[idB];
                    if (markerB != null) {
                        markerB.setMap(null);
                    }

                    var obj = $.parseJSON(data);

                    idA = "A";
                    idB = "B";

                    markerA = new google.maps.Marker({
                        id: idA,
                        position: {lat: obj.vigilanteA.lat, lng: obj.vigilanteA.lng},
                        map: map,
                        icon: '/resources/img/vigilante.png'
                    });

                    markerB = new google.maps.Marker({
                        id: idB,
                        position: {lat: obj.vigilanteB.lat, lng: obj.vigilanteB.lng},
                        map: map,
                        icon: '/resources/img/vigilante.png'
                    });

                    markers[idA] = markerA;
                    markers[idB] = markerB;
                });

            }, 3000);
        }
    </script>
</body>
</html>
