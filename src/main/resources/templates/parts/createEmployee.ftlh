<#macro employee employees subdivisions positionsNames create=true vacation=false>
    <div class="container pl-5 pr-5">
        <div class="row">
            <div class="col-sm">
                <form id="createEmployee" name="createEmployee">
                    <#if !vacation>
                        <div class="form-row">
                            <label>Форма заявки</label>
                        </div>
                        <div class="form-row mb-2">
                            <div class="form-group col-md-6">
                                <label>Введите имя</label>
                                <input id="first_name" type="text" name="first_name" class="form-control"
                                       placeholder="Введите имя"
                                       value="<#if employees?has_content>${employees.firstName}</#if>">
                            </div>
                            <div class="form-group col-md-6">
                                <label>Введите фамилию</label>
                                <input id="last_name" type="text" name="last_name" class="form-control"
                                       placeholder="Введите фамилию"
                                       value="<#if employees?has_content>${employees.lastName}</#if>">
                            </div>
                        </div>
                        <div class="form-row mb-2">
                            <div class="form-group col-md-3">
                                <label>Серия паспорта</label>
                                <input id="number_series" type="text" name="number_series" class="form-control"
                                       placeholder="Введите серию паспорта"
                                       value="<#if employees?has_content>${employees.passport.numberSeries?c}</#if>">
                            </div>
                            <div class="form-group col-md-3">
                                <label>Номер паспорта</label>
                                <input id="passport_id" type="text" name="passport_id" class="form-control"
                                       placeholder="Введите номер паспорта"
                                       value="<#if employees?has_content>${employees.passport.passportId?c}</#if>">
                            </div>
                            <div class="form-group col-md-3">
                                <label>Кем выдан</label>
                                <input id="issued_by" type="text" name="issued_by" class="form-control"
                                       placeholder="Введите кем выдан паспорт"
                                       value="<#if employees?has_content>${employees.passport.issuedBy}</#if>">
                            </div>
                            <div class="form-group col-md-3">
                                <label>Дата выдачи</label>
                                <input id="date_issue" type="date" name="date_issue" class="form-control"
                                       value="<#if employees?has_content>${employees.passport.dateIssue}</#if>">
                            </div>
                        </div>
                        <div class="form-row mb-2">
                            <label>Введите email</label>
                            <input id="email" type="text" name="email" class="form-control" placeholder="Введите email"
                                   value="<#if employees?has_content>${employees.email}</#if>">
                        </div>
                        <div class="form-row mb-2">
                            <label>Введите телефон</label>
                            <input id="phone" type="text" name="phone" class="form-control"
                                   placeholder="Введите телефон"
                                   value="<#if employees?has_content>${employees.phone}</#if>">
                        </div>
                        <div class="form-row mb-2">
                            <label>Дата рождения</label>
                            <input id="date_birth" type="date" name="date_birth" class="form-control"
                                   value="<#if employees?has_content>${employees.dateBirth}</#if>">
                        </div>
                        <div class="form-row mb-2">
                            <div class="form-group col-md-3">
                                <label>Введите город</label>
                                <input id="city" type="text" name="city" class="form-control"
                                       placeholder="Введите город"
                                       value="<#if employees?has_content>${employees.address.city}</#if>">
                            </div>
                            <div class="form-group col-md-3">
                                <label>Введите улицу</label>
                                <input id="street" type="text" name="street" class="form-control"
                                       placeholder="Введите улицу"
                                       value="<#if employees?has_content>${employees.address.street}</#if>">
                            </div>
                            <div class="form-group col-md-3">
                                <label>Введите дома</label>
                                <input id="house" type="text" name="house" class="form-control"
                                       placeholder="Введите дом"
                                       value="<#if employees?has_content>${employees.address.house}</#if>">
                            </div>
                            <div class="form-group col-md-3">
                                <label>Введите квартиры</label>
                                <input id="flat" type="text" name="flat" class="form-control"
                                       placeholder="Введите квартиру"
                                       value="<#if employees?has_content>${employees.address.flat}</#if>">
                            </div>
                        </div>
                        <div class="form-row mb-2">
                            <label>Введите ИНН</label>
                            <input id="number_inn" type="text" name="number_inn" class="form-control"
                                   placeholder="Введите ИНН"
                                   value="<#if employees?has_content>${employees.numberINN?c}</#if>">
                        </div>
                        <div class="form-row mb-2">
                            <label>Выберите пол</label>
                            <select id="genders" class="form-control">
                                <option value="null"></option>
                                <#list genders?values as gender>
                                    <#if employees?has_content>
                                        <#if gender.getNameGender() == employees.gender>
                                            <option value="${gender}" selected>${gender.getNameGender()}</option>
                                        <#else>
                                            <option value="${gender}">${gender.getNameGender()}</option>
                                        </#if>
                                    <#else>
                                        <option value="${gender}">${gender.getNameGender()}</option>
                                    </#if>
                                </#list>
                            </select>
                        </div>
                        <div class="form-row mb-2">
                            <label>Выберите подразделение</label>
                            <select id="subdivision" class="form-control">
                                <option value="null"></option>
                                <#list subdivisions as subdivision>
                                    <#if employees?has_content>
                                        <#if subdivision.id == employees.subdivisionId>
                                            <option value="${subdivision.id}" selected>${subdivision.name}</option>
                                        <#else>
                                            <option value="${subdivision.id}">${subdivision.name}</option>
                                        </#if>
                                    <#else>
                                        <option value="${subdivision.id}">${subdivision.name}</option>
                                    </#if>
                                </#list>
                            </select>
                        </div>
                        <div class="form-row mb-2">
                            <label>Выберите должность</label>
                            <select id="positions" class="form-control">
                                <option value="null"></option>
                                <#list positionsNames as positions>
                                    <#if employees?has_content>
                                        <#if positions.id == employees.position.positionNameId>
                                            <option value="${positions.id}" selected>${positions.name}</option>
                                        <#else>
                                            <option value="${positions.id}">${positions.name}</option>
                                        </#if>
                                    <#else>
                                        <option value="${positions.id}">${positions.name}</option>
                                    </#if>
                                </#list>
                            </select>
                        </div>
                        <div class="form-row mb-2">
                            <div class="form-group col-md-3">
                                <label>Дата приема на работу</label>
                                <input id="date_receipt" type="date" name="date_receipt" class="form-control"
                                       value="<#if employees?has_content>${employees.position.dateReceipt}</#if>">
                            </div>
                            <#if !create>
                                <div class="form-group col-md-3">
                                    <label>Дата увольнения</label>
                                    <input id="date_dismissal" type="date" name="date_dismissal" class="form-control"
                                           value="<#if employees?has_content && employees.position.dateDismissal?has_content>${employees.position.dateDismissal}</#if>">
                                </div>
                            </#if>
                        </div>
                        <#if !create>
                            <div class="form-row mb-2">
                                <label>Введите статус</label>
                                <input id="status" type="text" name="status" class="form-control"
                                       placeholder="Введите статус"
                                       value="<#if employees?has_content>${employees.status}</#if>">
                            </div>
                        </#if>
                        <input id="pas_id" type="text"
                               value="<#if employees?has_content>${employees.passport.id}</#if>" hidden>
                        <input id="address_id" type="text"
                               value="<#if employees?has_content>${employees.address.id}</#if>" hidden>
                        <input id="position_id" type="text"
                               value="<#if employees?has_content>${employees.position.id}</#if>" hidden>
                        <#if employees?has_content>
                            <div class="form-row">
                                <input class="btn btn-primary  mb-4" type="button"
                                       onclick="submitUpdateEmployees(${employees.id})"
                                       value="Изменить сотрудника">
                            </div>
                        <#else>
                            <div class="form-row">
                                <input class="btn btn-primary  mb-4" type="button" onclick="submitNewEmployees()"
                                       value="Добавить сотрудника">
                            </div>
                        </#if>
                    <#else>
                        <div class="form-row mb-2">
                            <div class="form-group col-md-6">
                                <label>Дата начала отпуска</label>
                                <input id="vacation_start" type="date" name="vacation_start" class="form-control"
                                       value="<#if employees?has_content && employees.vacationStart?has_content>${employees.vacationStart}</#if>">
                            </div>
                            <div class="form-group col-md-6">
                                <label>Дата окончания отпуска</label>
                                <input id="vacation_final" type="date" name="vacation_final" class="form-control"
                                       value="<#if employees?has_content && employees.vacationFinal?has_content>${employees.vacationFinal}</#if>">
                            </div>
                        </div>
                        <div class="form-row">
                            <input class="btn btn-primary  mb-4" type="button"
                                   onclick="updateEmployeeVacationById(${employees.id})"
                                   value="Изменить сотрудника">
                        </div>
                    </#if>
                </form>
            </div>
        </div>
    </div>
</#macro>