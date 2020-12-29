<#macro listRequest requests manager=false technical=false admin=false>
    <#if technical>
        <table class="table table-bordered w-auto small">
    <#else>
        <table class="table table-bordered">
    </#if>
    <thead class="thead-dark">
    <tr>
        <th scope="col">Тип</th>
        <th scope="col">Описание</th>
        <th scope="col">Адресс</th>
        <th scope="col">Телефон</th>
        <th scope="col">Email</th>
        <th scope="col">Статус</th>
        <th scope="col">Дата подачи</th>
        <th scope="col">Дата приема</th>
        <th scope="col">Дата выполнения</th>
        <th scope="col">Цена</th>
        <#if manager>
            <th scope="col"></th>
        </#if>
        <#if technical>
            <th scope="col"></th>
            <th scope="col"></th>
            <th scope="col"></th>
        </#if>
    </tr>
    </thead>
    <tbody>
    <#list requests as request>
        <tr>
            <td>
                ${request.types}
            </td>
            <td>${request.description}</td>
            <td>${request.addressDTOS.toString()}</td>
            <td>${request.phone}</td>
            <td>${request.email}</td>
            <td>${request.status}</td>
            <td>
                <#if request.dateCreate?has_content>
                    ${request.dateCreate}
                <#else>
                    Null
                </#if>
            </td>
            <td>
                <#if request.dateReception?has_content>
                    ${request.dateReception}
                <#else>
                    Null
                </#if>
            </td>
            <td>
                <#if request.dateCompletion?has_content>
                    ${request.dateCompletion}
                <#else>
                    Null
                </#if>
            </td>
            <td>
                <#if admin>
                    <#if request.price?has_content>
                        ${request.price}
                    <#else>
                        null
                    </#if>
                <#else>
                    <#if request.price?has_content>
                        ${request.price}
                    <#else>
                        <input id="price_${request.id}" type="text" name="price" class="form-control"
                               placeholder="Введите сумму">
                    </#if>
                </#if>
            </td>
            <#if manager>
                <td><a class="btn btn-primary" type="button" href="/pdf/employee/${request.id}">Сформировать чек</a></td>
            </#if>
            <#if technical>
                <td><input class="btn btn-primary" type="button" onclick="acceptedRequestById(${request.id})"
                           value="Принять"></td>
                <td><input class="btn btn-primary" type="button" onclick="performedRequestById(${request.id})"
                           value="Завершить"></td>
                <td><input class="btn btn-primary" type="button" onclick="declinedRequestById(${request.id})"
                           value="Отказать"></td>
            </#if>
        </tr>
    </#list>
    </table>
</#macro>