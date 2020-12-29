<#import "login.ftlh" as l>
<#include "security.ftlh">

<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="/">Интернет провайдер)</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item">
                <a class="nav-link" href="/make/request">Отправить заявку</a>
            </li>
            <#if isAdmin>
                <li class="nav-item">
                    <a class="nav-link" href="/admin/requests">Заявки</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/users">Сотрудники</a>
                </li>
            </#if>
            <#if isManagere>
                <li class="nav-item">
                    <a class="nav-link" href="/manager/requests">Заявки</a>
                </li>
            </#if>
            <#if isTechnican>
                <li class="nav-item">
                    <a class="nav-link" href="/technical/requests">Заявки</a>
                </li>
            </#if>
        </ul>

        <div class="navbar-text mr-3">${name}</div>
        <div class="navbar-text mr-3">${role}</div>
        <#if isAdmin>
            <a href="/registration" class="btn btn-primary mr-3" type="button">Регистрация</a>
        </#if>
        <form action="/logout" method="post">
            <#if isAdmin || isTechnican || isManagere>
                <input type="submit" class="btn btn-primary mr-3" value="Выйти"/>
            <#else>
                <input type="submit" class="btn btn-primary mr-3" value="Войти"/>
            </#if>
        </form>
    </div>
</nav>