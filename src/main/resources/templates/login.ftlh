<#import "parts/common.ftlh" as c>

<@c.page>
    <div class="custom-login">
        <form class="form" action="/login" method="post">
            <h1 class="h3 mb-3 font-weight-normal">Авторизация</h1>
            <label for="inputEmail" class="sr-only">Логин</label>
            <input type="text" id="username" name="username" class="form-control mb-2" placeholder="Введите email" required autofocus>
            <label for="inputPassword" class="sr-only">Пароль</label>
            <input type="password" id="password" name="password" class="form-control mb-2" placeholder="Введите пароль" required>
            <input class="btn btn-lg btn-dark btn-block mb-4" type="submit" value="Войти">
        </form>
    </div>
</@c.page>

