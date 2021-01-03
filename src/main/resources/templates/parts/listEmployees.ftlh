<#macro listEmployees employees subdivisions positions positionsNames subdivision=false position=false all=false vacation=false>
    <table class="table table-bordered">
        <thead class="thead-dark">
        <tr>
            <#if all>
                <th scope="col">Имя</th>
                <th scope="col">Фамилия</th>
                <th scope="col">Телефон</th>
                <th scope="col">Email</th>
                <th scope="col">Паспорт</th>
                <th scope="col">Адресс</th>
                <th scope="col">Дата рождения</th>
                <th scope="col">Пол</th>
                <th scope="col">Статус</th>
                <th scope="col"></th>
                <th scope="col"></th>
            <#elseif position>
                <th scope="col">Имя</th>
                <th scope="col">Фамилия</th>
                <th scope="col">Телефон</th>
                <th scope="col">Должность</th>
                <th scope="col">Дата приема</th>
                <th scope="col">Дата увольнения</th>
                <th scope="col"></th>
                <th scope="col"></th>
            <#elseif subdivision>
                <th scope="col">Имя</th>
                <th scope="col">Фамилия</th>
                <th scope="col">Телефон</th>
                <th scope="col">Подразделение</th>
                <th scope="col"></th>
                <th scope="col"></th>
            <#elseif vacation>
                <th scope="col">Имя</th>
                <th scope="col">Фамилия</th>
                <th scope="col">Телефон</th>
                <th scope="col">Начало отпуска</th>
                <th scope="col">Конец отпуска</th>
                <th scope="col"></th>
            </#if>
        </tr>
        </thead>
        <tbody>
        <#list employees as employee>
            <tr>
                <#if all>
                    <td>${employee.firstName}</td>
                    <td>${employee.lastName}</td>
                    <td>${employee.phone}</td>
                    <td>${employee.email}</td>
                    <td>${employee.passport.toString()}</td>
                    <td>${employee.address.toString()}</td>
                    <td>${employee.dateBirth}</td>
                    <td>${employee.gender}</td>
                    <td>${employee.status}</td>
                <#elseif position>
                    <td>${employee.firstName}</td>
                    <td>${employee.lastName}</td>
                    <td>${employee.phone}</td>
                    <#list positionsNames as positionsName>
                        <#if positionsName.id == employee.position.positionNameId>
                            <td>${positionsName.name}</td>
                        </#if>
                    </#list>
                    <td>${employee.position.dateReceipt}</td>
                    <td><#if employee.position.dateDismissal?has_content>
                            ${employee.position.dateDismissal}
                        <#else>
                            Null
                        </#if>
                    </td>
                <#elseif subdivision>
                    <td>${employee.firstName}</td>
                    <td>${employee.lastName}</td>
                    <td>${employee.phone}</td>
                    <#list subdivisions as subdivision>
                        <#if subdivision.id == employee.subdivisionId>
                            <td>${subdivision.name}</td>
                        </#if>
                    </#list>
                <#elseif vacation>
                    <td>${employee.firstName}</td>
                    <td>${employee.lastName}</td>
                    <td>${employee.phone}</td>
                    <td><#if employee.vacationStart?has_content>
                            ${employee.vacationStart}
                        <#else>
                            Null
                        </#if>
                    </td>
                    <td><#if employee.vacationFinal?has_content>
                            ${employee.vacationFinal}
                        <#else>
                            Null
                        </#if>
                    </td>
                </#if>



                <#if vacation>
                    <td><a class="btn btn-primary" type="button" href="/employees/vacation/${employee.id}">Изменить</a>
                    </td>
                <#else>
                    <td><a class="btn btn-primary" type="button" href="/employees/${employee.id}">Изменить</a></td>
                    <td><input class="btn btn-primary" type="button" onclick="deleteEmployeeById(${employee.id})"
                               value="Удалить"></td>
                </#if>
            </tr>
        </#list>
    </table>
</#macro>

