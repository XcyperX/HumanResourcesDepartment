<#import "createEmployee.ftlh" as ce>
<#macro listEmployees employees subdivisions positionsNames genders>
    <table class="table table-bordered mb-0">
        <thead class="thead-dark">
        <tr>
            <th scope="col">Имя</th>
            <th scope="col">Фамилия</th>
            <th scope="col">Отчество</th>
            <th scope="col">Пол</th>
            <th scope="col">Телефон</th>
            <th scope="col">Email</th>
            <th scope="col">Должность</th>
            <th scope="col">Подразделение</th>
            <#--                <th scope="col">Дата приема</th>-->
            <#--                <th scope="col">Дата увольнения</th>-->
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
                <#list genders?values as gender>
                    <#if gender == employee.gender>
                        <td>${gender.getNameGender()}</td>
                    </#if>
                </#list>
                <td>${employee.phone}</td>
                <td>${employee.email}</td>
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
                <#--                    <td>${employee.position.dateReceipt}</td>-->
                <#--                    <td><#if employee.position.dateDismissal?has_content>-->
                <#--                            ${employee.position.dateDismissal}-->
                <#--                        <#else>-->
                <#--                            Null-->
                <#--                        </#if>-->
                <#--                    </td>-->
                <#--                    <td>${employee.status}</td>-->
                <#--                <#if vacation>-->
                <#--                    <td>-->
                <#--                        <button type="button" class="btn btn-primary" data-toggle="modal"-->
                <#--                                data-target="#updateVacationEmployee_${employee.id}">-->
                <#--                            Изменить-->
                <#--                        </button>-->

                <#--                        <!-- Modal &ndash;&gt;-->
                <#--                        <div class="modal fade" id="updateVacationEmployee_${employee.id}" tabindex="-1" role="dialog"-->
                <#--                             aria-labelledby="exampleModalLabel" aria-hidden="true">-->
                <#--                            <div class="modal-dialog modal-lg">-->
                <#--                                <div class="modal-content">-->
                <#--                                    <div class="modal-header">-->
                <#--                                        <h5 class="modal-title" id="exampleModalLabel">Отпуск-->
                <#--                                            сотрудника ${employee.firstName} ${employee.lastName}</h5>-->
                <#--                                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">-->
                <#--                                            <span aria-hidden="true">&times;</span>-->
                <#--                                        </button>-->
                <#--                                    </div>-->
                <#--                                    <div class="modal-body">-->
                <#--                                        <@ce.employee employees=employee categories=categories positionsNames=positionsNames vacation=true/>-->
                <#--                                    </div>-->
                <#--                                    <div class="modal-footer">-->
                <#--                                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Отмена-->
                <#--                                        </button>-->
                <#--                                        <button type="button" class="btn btn-primary"-->
                <#--                                                onclick="updateEmployeeVacationById(${employee.id})">Сохранить отпуск-->
                <#--                                            сотрудника-->
                <#--                                        </button>-->
                <#--                                    </div>-->
                <#--                                </div>-->
                <#--                            </div>-->
                <#--                        </div>-->
                <#--                    </td>-->
                <#--                <#elseif all>-->
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
<#--                                <div class="modal-header">-->
<#--                                    <h5 class="modal-title" id="exampleModalLabel">Редактирование-->
<#--                                        сотрудника: ${employee.firstName} ${employee.lastName} ${employee.secondName}</h5>-->
<#--                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">-->
<#--                                        <span aria-hidden="true">&times;</span>-->
<#--                                    </button>-->
<#--                                </div>-->
                                <div class="modal-body">
                                    <@ce.employee employees=employee subdivisions=subdivisions positionsNames=positionsNames/>
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Отмена
                                    </button>
                                    <button type="button" class="btn btn-primary"
                                            onclick="submitCrateAndUpdateEmployees(${employee.id})">
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

