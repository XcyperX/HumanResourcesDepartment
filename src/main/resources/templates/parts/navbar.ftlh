<#import "login.ftlh" as l>
<#include "security.ftlh">
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand">АИС</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <#if isAdmin>
                <li class="nav-item">
                    <a class="nav-link" href="/admin/table/products">Продукты</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/admin/customers">Клиенты</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/admin/employees">Сотрудники</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/admin/order/history">Журнал продаж</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/admin/providers">Поставщики</a>
                </li>
            </#if>
            <#if isProvider>
                <li class="nav-item">
                    <a class="nav-link" href="/provider/table/product">Продукты</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/products/agreement">Поставки</a>
                </li>
            </#if>
        </ul>

        <div class="navbar-text mr-3">${name}</div>
        <div class="navbar-text mr-3">${role}</div>
<!--        <#if isAdmin>-->
<!--            <a href="/users" class="btn btn-primary mr-3" type="button">Сотрудники системы</a>-->
<!--        </#if>-->
        <form action="/logout" method="post">
            <#if isAdmin || isProvider || isSeller || isStorekeeper>
                <input type="submit" class="btn btn-primary" value="Выйти"/>
            <#else>
                <input type="submit" class="btn btn-primary" value="Войти"/>
            </#if>
        </form>
    </div>
</nav>