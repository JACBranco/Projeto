<script>

// A VERSAO ABAIXO É A QUE É UTILIZADA PARA CRIAR UM JSON OBJECT E ENVIAR OARA O CONTROLADOR

//function submitLoginForm() {
//
//    var usernameToParse = document.getElementById("username").value;
//    var passwordToParse = document.getElementById("password").value;
//
//    console.log(usernameToParse);
//    console.log(passwordToParse);
//
//    const loginData = {
//        username: usernameToParse,
//        password: passwordToParse
//    }
//
//    console.log(loginData);
//
//    var jsonInput = document.getElementById("json");
//    jsonInput.value = JSON.stringify(loginData);
//
//    console.log(jsonInput);
//
//    document.getElementById("submitLoginForm").submit();
//}

function submitLoginForm() {
    document.getElementById("loginForm").submit();
}

</script>