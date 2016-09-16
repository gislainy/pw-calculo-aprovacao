<!DOCTYPE html>
<html>

<head>
    <%@ include file="header.html" %>
        <meta charset="ISO-8859-1">
        <title>Calculo de IMC</title>
</head>

<body>
    <!--CABEÇALHO-->
    <nav class="navbar navbar-default">
        <div class="container-fluid">
            <div class="navbar-header">
                <a class="navbar-brand" href="">Calculo IMC</a>
            </div>
        </div>
    </nav>
    <div class="container">
        <%@ include file="formulario.html" %>
            <div class="col-lg-12">
                <div class="alert alert-dismissible alert-success">
                    <h4>Resultado</h4>
                    <p>
                        ${resultado}
                    </p>
                </div>
            </div>
    </div>
</body>

</html>