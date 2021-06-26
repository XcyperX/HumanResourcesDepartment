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
                    <a class="nav-link" href="/admin/order/histories">Журнал продаж</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/admin/providers/products">Поставщики</a>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#">
                        Поставки
                    </a>
                    <ul class="dropdown-menu">
                        <li><a class="dropdown-item" href="/admin/products/deliveries">Заказы <span id="productsInDeliveries" class="badge badge-primary"></span></a></li>
                        <li><a class="dropdown-item" href="/admin/products/deliveries/order">Поставки</a></li>
                    </ul>
                </li>
<#--                <div class="dropdown">-->
<#--                    <button class="nav-link btn btn-light dropdown-toggle" type="button" id="dropdownMenuButton" data-bs-toggle="dropdown" aria-expanded="false">-->
<#--                        Поставки-->
<#--                    </button>-->
<#--                    <ul class="dropdown-menu" aria-labelledby="dropdownMenuButton">-->
<#--                        <li><a class="dropdown-item" href="#">Заявки</a></li>-->
<#--                        <li><a class="dropdown-item" href="#">Another action</a></li>-->
<#--                    </ul>-->
<#--                </div>-->
<#--                <li class="nav-item">-->
<#--                    <button class="nav-link btn btn-light" onclick="getDeliveries()">-->
<#--                        Поставки-->
<#--                        <span id="productsInDeliveries" class="badge badge-primary"></span>-->
<#--                    </button>-->
<#--&lt;#&ndash;                    <a class="nav-link" href="/admin/products/deliveries">Поставки&ndash;&gt;-->
<#--&lt;#&ndash;                        <span id="productsInDeliveries" class="badge badge-primary"></span>&ndash;&gt;-->
<#--&lt;#&ndash;                    </a>&ndash;&gt;-->
<#--                </li>-->
            <#elseif isSeller>
                <li class="nav-item">
                    <a class="nav-link" href="/products">Каталог товаров</a>
                </li>
                <li class="nav-item">
                    <button class="nav-link btn btn-light" onclick="getProductsByBasket()">
                        Корзина
                        <span id="productsInBasket" class="badge badge-primary"></span>
                    </button>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/seller/table/products">Продукты</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/admin/customers">Клиенты</a>
                </li>
            <#elseif isStorekeeper>
                <li class="nav-item">
                    <a class="nav-link" href="/admin/table/products">Продукты</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/admin/providers/products">Поставщики</a>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#">
                        Поставки
                    </a>
                    <ul class="dropdown-menu">
                        <li><a class="dropdown-item" href="/admin/products/deliveries">Заказы <span id="productsInDeliveries" class="badge badge-primary"></span></a></li>
                        <li><a class="dropdown-item" href="/admin/products/deliveries/order">Поставки</a></li>
                    </ul>
                </li>
            <#elseif isProvider>
                <li class="nav-item">
                    <a class="nav-link" href="/provider/table/product">Продукты</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/provider/products/deliveries">Поставки</a>
                </li>
            <#elseif isCustomer>
                <li class="nav-item">
                    <a class="nav-link" href="/products">Каталог товаров</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/products/basket">Корзина <span id="productsInBasket" class="badge badge-primary"></span></a>
                </li>
            <#else>
                <li class="nav-item">
                    <a class="nav-link" href="/products">Каталог товаров</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/products/basket">Корзина <span id="productsInBasket" class="badge badge-primary"></span></a>
                </li>
            </#if>
        </ul>

        <div class="navbar-text mr-3">${name}</div>
        <div class="navbar-text mr-3">${role}</div>
        <form action="/logout" method="post">
            <#if isAdmin || isProvider || isSeller || isStorekeeper || isCustomer>
                <input type="submit" class="btn btn-primary" value="Выйти"/>
            <#else>
                <input type="submit" class="btn btn-primary" value="Войти"/>
            </#if>
        </form>
    </div>
</nav>