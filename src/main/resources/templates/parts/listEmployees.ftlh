<#import "createCustomer.ftlh" as cc>
<#import "createEmployee.ftlh" as ce>
<#macro listEmployees employees subdivisions positionsNames genders isCustomer=false>
    <table class="table table-bordered mb-0">
        <thead class="thead-dark">
        <tr>
            <th scope="col">Имя</th>
            <th scope="col">Фамилия</th>
            <th scope="col">Отчество</th>
            <#if !isCustomer>
                <th scope="col">Пол</th>
            </#if>
            <th scope="col">Телефон</th>
            <th scope="col">Email</th>
            <#if !isCustomer>
                <th scope="col">Должность</th>
                <th scope="col">Подразделение</th>
            </#if>
            <th scope="col"></th>
            <th scope="col"></th>
        </tr>
        </thead>
        <tbody>
        <#list employees as employee>
            <tr>
                <td>${employee.firstName}</td>
                <td>${employee.lastName}</td>
                <td>${employee.secondName}</td>
                <#if !isCustomer>
                    <#list genders?values as gender>
                        <#if gender == employee.gender>
                            <td>${gender.getNameGender()}</td>
                        </#if>
                    </#list>
                </#if>
                <td>${employee.phone}</td>
                <td>${employee.email}</td>
                <#if !isCustomer>
                    <#if employee.position?has_content>
                        <#list positionsNames as positionsName>
                            <#if positionsName.id == employee.position.positionNameId>
                                <td>${positionsName.name}</td>
                            </#if>
                        </#list>
                    <#else>
                        <td>-</td>
                    </#if>
                    <#list subdivisions as subdivision>
                        <#if subdivision.id == employee.subdivisionId>
                            <td>${subdivision.name}</td>
                        </#if>
                    </#list>
                </#if>
                <td>
                    <button type="button" class="btn btn-primary" data-toggle="modal"
                            data-target="#updateEmployee_${employee.id}">
                        Изменить
                    </button>

                    <!-- Modal -->
                    <div class="modal fade" id="updateEmployee_${employee.id}" tabindex="-1" role="dialog"
                         aria-labelledby="exampleModalLabel" aria-hidden="true">
                        <div class="modal-dialog modal-lg">
                            <div class="modal-content">
                                <div class="modal-body">
                                    <#if isCustomer>
                                        <@cc.employee employees=employee/>
                                    <#else>
                                        <@ce.employee employees=employee subdivisions=subdivisions positionsNames=positionsNames />
                                    </#if>
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Отмена
                                    </button>
                                    <button type="button" class="btn btn-primary"
                                            <#if isCustomer>
                                                onclick="submitCrateCustomer(${employee.id})"
                                            <#else>
                                                onclick="submitCrateAndUpdateEmployees(${employee.id})"
                                            </#if>
                                    >
                                        Сохранить изменения
                                    </button>
                                </div>
                            </div>
                        </div>
                    </div>
                </td>
                <td><input class="btn btn-primary" type="button" onclick="deleteEmployeeById(${employee.id})"
                           value="Удалить"></td>
            </tr>
        </#list>
    </table>
</#macro>

