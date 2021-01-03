<#import "login.ftlh" as l>
<#include "security.ftlh">

<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand">Отдел кадров</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <#if isAdmin>
                <li class="nav-item">
                    <a class="nav-link" href="/employees">Сотрудники</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/employees/position">Должности</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/employees/subdivisions">Подразделения</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/vacation">Отпуска</a>
                </li>
            </#if>
        </ul>

        <div class="navbar-text mr-3">${name}</div>
        <div class="navbar-text mr-3">${role}</div>
        <#if isAdmin>
            <a href="/users" class="btn btn-primary mr-3" type="button">Сотрудники системы</a>
            <a href="/registration" class="btn btn-primary mr-3" type="button">Регистрация</a>
        </#if>
        <form action="/logout" method="post">
            <#if isAdmin>
                <input type="submit" class="btn btn-primary mr-3" value="Выйти"/>
            <#else>
                <input type="submit" class="btn btn-primary mr-3" value="Войти"/>
            </#if>
        </form>
    </div>
</nav>