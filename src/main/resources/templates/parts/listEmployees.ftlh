<#import "createEmployee.ftlh" as ce>
<#macro listEmployees employees agreementData subdivisions positions positionsNames subdivision=false position=false all=false vacation=false agreement=false>
    <#if position>
        <form id="createPosition" name="createPosition">
            <div class="form-row mb-3">
                <div class="col-9">
                    <input id="position_input" type="text" name="position" class="form-control"
                           placeholder="Введите название должности">
                </div>
                <div class="col">
                    <input class="btn btn-primary btn-block" type="button" onclick="submitNewPosition()"
                           value="Добавить должность">
                </div>
            </div>
        </form>
    </#if>
    <#if subdivision>
        <form id="createSubdivisions" name="createSubdivisions">
            <div class="form-row mb-3">
                <div class="col-8">
                    <input id="subdivision_input" type="text" name="subdivision" class="form-control"
                           placeholder="Введите название подразделения">
                </div>
                <div class="col">
                    <input class="btn btn-primary btn-block" type="button" onclick="submitNewSubdivision()"
                           value="Добавить подразделение">
                </div>
            </div>
        </form>
    </#if>
    <table class="table table-bordered mb-0">
        <thead class="thead-dark">
        <tr>
            <#if all>
                <th scope="col">Имя</th>
                <th scope="col">Фамилия</th>
                <th scope="col">Пол</th>
                <th scope="col">Телефон</th>
                <th scope="col">Email</th>
                <th scope="col">Должность</th>
                <th scope="col">Подразделение</th>
                <th scope="col">Дата приема</th>
                <th scope="col">Дата увольнения</th>
                <th scope="col">Статус</th>
                <th scope="col"></th>
                <th scope="col"></th>
            <#elseif position>
                <th scope="col">#</th>
                <th scope="col">Название</th>
            <#elseif subdivision>
                <th scope="col">#</th>
                <th scope="col">Название</th>
            <#elseif vacation>
                <th scope="col">Имя</th>
                <th scope="col">Фамилия</th>
                <th scope="col">Телефон</th>
                <th scope="col">Начало отпуска</th>
                <th scope="col">Конец отпуска</th>
                <th scope="col"></th>
            <#elseif agreement>
                <th scope="col">Имя</th>
                <th scope="col">Фамилия</th>
                <th scope="col">Телефон</th>
                <th scope="col">Подразделение</th>
                <th scope="col">Дата начала</th>
                <th scope="col">Дата окончания</th>
                <th scope="col">Сумма по договору</th>
                <th scope="col">Оплата</th>
                <th scope="col">Код вычета</th>
                <th scope="col">Сумма вычета</th>
                <th scope="col"></th>
                <th scope="col"></th>
            </#if>
        </tr>
        </thead>
        <tbody>
        <#if position>
            <#list positionsNames as positionsName>
                <tr>
                    <td>${positionsName.id}</td>
                    <td>${positionsName.name}</td>
                </tr>
            </#list>
        <#elseif subdivision>
            <#list subdivisions as subdivision>
                <tr>
                    <td>${subdivision.id}</td>
                    <td>${subdivision.name}</td>
                </tr>
            </#list>
        <#elseif agreement>
            <#list agreementData as agreData>
                <tr>
                    <#list employees as employee>
                        <#if employee.id == agreData.employeeId>
                            <td>${employee.firstName}</td>
                            <td>${employee.lastName}</td>
                            <td>${employee.phone}</td>
                            <#list subdivisions as subdivision>
                                <#if subdivision.id == employee.subdivisionId>
                                    <td>${subdivision.name}</td>
                                </#if>
                            </#list>
                        </#if>
                    </#list>
                    <td>${agreData.start}</td>
                    <td>${agreData.finish}</td>
                    <td>${agreData.price}</td>
                    <td>${agreData.payment}</td>
                    <td>${agreData.deductionCode}</td>
                    <td>${agreData.sumTax}</td>
                    <td><input class="btn btn-primary" type="button"
                               value="Сформировать отчет"></td>
                    <td><input class="btn btn-primary" type="button"
                              value="Удалить"></td>
                </tr>
            </#list>
        </#if>
        <#list employees as employee>
            <tr>
                <#if all>
                    <td>${employee.firstName}</td>
                    <td>${employee.lastName}</td>
                    <td>${employee.gender}</td>
                    <td>${employee.phone}</td>
                    <td>${employee.email}</td>
                    <#list positionsNames as positionsName>
                        <#if positionsName.id == employee.position.positionNameId>
                            <td>${positionsName.name}</td>
                        </#if>
                    </#list>
                    <#list subdivisions as subdivision>
                        <#if subdivision.id == employee.subdivisionId>
                            <td>${subdivision.name}</td>
                        </#if>
                    </#list>
                    <td>${employee.position.dateReceipt}</td>
                    <td><#if employee.position.dateDismissal?has_content>
                            ${employee.position.dateDismissal}
                        <#else>
                            Null
                        </#if>
                    </td>
                    <td>${employee.status}</td>
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
                    <td>
                        <button type="button" class="btn btn-primary" data-toggle="modal"
                                data-target="#updateVacationEmployee_${employee.id}">
                            Изменить
                        </button>

                        <!-- Modal -->
                        <div class="modal fade" id="updateVacationEmployee_${employee.id}" tabindex="-1" role="dialog"
                             aria-labelledby="exampleModalLabel" aria-hidden="true">
                            <div class="modal-dialog modal-lg">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <h5 class="modal-title" id="exampleModalLabel">Отпуск
                                            сотрудника ${employee.firstName} ${employee.lastName}</h5>
                                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                            <span aria-hidden="true">&times;</span>
                                        </button>
                                    </div>
                                    <div class="modal-body">
                                        <@ce.employee employees=employee subdivisions=subdivisions positionsNames=positionsNames vacation=true/>
                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Отмена
                                        </button>
                                        <button type="button" class="btn btn-primary"
                                                onclick="updateEmployeeVacationById(${employee.id})">Сохранить отпуск
                                            сотрудника
                                        </button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </td>
                <#elseif all>
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
                                    <div class="modal-header">
                                        <h5 class="modal-title" id="exampleModalLabel">Редактирование
                                            сотрудника ${employee.firstName} ${employee.lastName}</h5>
                                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                            <span aria-hidden="true">&times;</span>
                                        </button>
                                    </div>
                                    <div class="modal-body">
                                        <@ce.employee employees=employee subdivisions=subdivisions positionsNames=positionsNames create=false/>
                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Отмена
                                        </button>
                                        <button type="button" class="btn btn-primary"
                                                onclick="submitCrateAndUpdateEmployees(${employee.id})">Сохранить
                                            изменения
                                        </button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </td>
                    <td><input class="btn btn-primary" type="button" onclick="deleteEmployeeById(${employee.id})"
                               value="Удалить"></td>
                </#if>
            </tr>
        </#list>
    </table>
</#macro>

