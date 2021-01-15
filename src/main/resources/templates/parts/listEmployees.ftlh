<#import "createEmployee.ftlh" as ce>
<#macro listEmployees products orderHistory categories positions positionsNames categories=false position=false all=false vacation=false agreement=false>
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
    <#if categories>
        <form id="createSubdivisions" name="createSubdivisions">
            <div class="form-row mb-3">
                <div class="col-8">
                    <input id="subdivision_input" type="text" name="categories" class="form-control"
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
            <#elseif categories>
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
        <#elseif categories>
            <#list categories as categories>
                <tr>
                    <td>${categories.id}</td>
                    <td>${categories.name}</td>
                </tr>
            </#list>
        <#elseif agreement>
            <#list orderHistory as agreData>
                <tr>
                    <#list products as product>
                        <#if product.id == agreData.employeeId>
                            <td>${product.firstName}</td>
                            <td>${product.lastName}</td>
                            <td>${product.phone}</td>
                            <#list categories as categories>
                                <#if categories.id == product.subdivisionId>
                                    <td>${categories.name}</td>
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
        <#list products as product>
            <tr>
                <#if all>
                    <td>${product.firstName}</td>
                    <td>${product.lastName}</td>
                    <td>${product.gender}</td>
                    <td>${product.phone}</td>
                    <td>${product.email}</td>
                    <#list positionsNames as positionsName>
                        <#if positionsName.id == product.position.positionNameId>
                            <td>${positionsName.name}</td>
                        </#if>
                    </#list>
                    <#list categories as categories>
                        <#if categories.id == product.subdivisionId>
                            <td>${categories.name}</td>
                        </#if>
                    </#list>
                    <td>${product.position.dateReceipt}</td>
                    <td><#if product.position.dateDismissal?has_content>
                            ${product.position.dateDismissal}
                        <#else>
                            Null
                        </#if>
                    </td>
                    <td>${product.status}</td>
                <#elseif vacation>
                    <td>${product.firstName}</td>
                    <td>${product.lastName}</td>
                    <td>${product.phone}</td>
                    <td><#if product.vacationStart?has_content>
                            ${product.vacationStart}
                        <#else>
                            Null
                        </#if>
                    </td>
                    <td><#if product.vacationFinal?has_content>
                            ${product.vacationFinal}
                        <#else>
                            Null
                        </#if>
                    </td>
                </#if>

                <#if vacation>
                    <td>
                        <button type="button" class="btn btn-primary" data-toggle="modal"
                                data-target="#updateVacationEmployee_${product.id}">
                            Изменить
                        </button>

                        <!-- Modal -->
                        <div class="modal fade" id="updateVacationEmployee_${product.id}" tabindex="-1" role="dialog"
                             aria-labelledby="exampleModalLabel" aria-hidden="true">
                            <div class="modal-dialog modal-lg">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <h5 class="modal-title" id="exampleModalLabel">Отпуск
                                            сотрудника ${product.firstName} ${product.lastName}</h5>
                                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                            <span aria-hidden="true">&times;</span>
                                        </button>
                                    </div>
                                    <div class="modal-body">
                                        <@ce.product products=product categories=categories positionsNames=positionsNames vacation=true/>
                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Отмена
                                        </button>
                                        <button type="button" class="btn btn-primary"
                                                onclick="updateEmployeeVacationById(${product.id})">Сохранить отпуск
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
                                data-target="#updateEmployee_${product.id}">
                            Изменить
                        </button>

                        <!-- Modal -->
                        <div class="modal fade" id="updateEmployee_${product.id}" tabindex="-1" role="dialog"
                             aria-labelledby="exampleModalLabel" aria-hidden="true">
                            <div class="modal-dialog modal-lg">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <h5 class="modal-title" id="exampleModalLabel">Редактирование
                                            сотрудника ${product.firstName} ${product.lastName}</h5>
                                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                            <span aria-hidden="true">&times;</span>
                                        </button>
                                    </div>
                                    <div class="modal-body">
                                        <@ce.product products=product categories=categories positionsNames=positionsNames create=false/>
                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Отмена
                                        </button>
                                        <button type="button" class="btn btn-primary"
                                                onclick="submitCrateAndUpdateEmployees(${product.id})">Сохранить
                                            изменения
                                        </button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </td>
                    <td><input class="btn btn-primary" type="button" onclick="deleteEmployeeById(${product.id})"
                               value="Удалить"></td>
                </#if>
            </tr>
        </#list>
    </table>
</#macro>

