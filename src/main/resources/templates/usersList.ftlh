<#import "parts/common.ftlh" as c>

<@c.page>
    <a href="/registration" class="btn btn-primary mr-3 mb-2" type="button">Регистрация</a>
    <table class="table table-bordered">
        <thead class="thead-dark">
        <tr>
            <th scope="col">Имя</th>
            <th scope="col">Роль</th>
            <th scope="col">Email</th>
            <th scope="col"></th>
            <th scope="col"></th>
        </tr>
        </thead>
        <tbody>
        <#list users as user>
            <tr>
                <td>${user.name}</td>
                <td>${user.role}</td>
                <td>${user.email}</td>
                <td><a class="btn btn-primary" href="/users/edit/${user.id}">Редактировать</a></td>
                <td><input class="btn btn-primary" type="button" onclick="deleteUserById(${user.id})"
                           value="Удалить сотрудника"></td>
            </tr>
        </#list>
    </table>
</@c.page>