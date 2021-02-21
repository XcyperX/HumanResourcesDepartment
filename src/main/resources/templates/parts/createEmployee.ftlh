<#macro employee employees subdivisions positionsNames>
<#--<div class="container pl-5 pr-5">-->
    <div class="row">
        <div class="col-sm">
            <div class="modal-header pl-0 pb-0 pt-0 pr-0 mb-2">
                <h5 class="modal-title" id="exampleModalLabel">Информация о сотруднике
                    <#if employees?has_content && employees.firstName?has_content>: ${employees.firstName} ${employees.lastName} ${employees.secondName}</#if></h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <form id="createEmployee<#if employees?has_content>_${employees.id}</#if>" name="createEmployee">
                <div class="form-row">
                    <div class="form-group col-md-4">
                        <label class="custom-label">Введите имя</label>
                        <input id="first_name" type="text" name="first_name" class="form-control"
                               placeholder="Введите имя"
                               value="<#if employees?has_content>${employees.firstName}</#if>">
                    </div>
                    <div class="form-group col-md-4">
                        <label class="custom-label">Введите фамилию</label>
                        <input id="last_name" type="text" name="last_name" class="form-control"
                               placeholder="Введите фамилию"
                               value="<#if employees?has_content>${employees.lastName}</#if>">
                    </div>
                    <div class="form-group col-md-4">
                        <label class="custom-label">Введите отчетсво</label>
                        <input id="second_name" type="text" name="second_name" class="form-control"
                               placeholder="Введите фамилию"
                               value="<#if employees?has_content>${employees.secondName}</#if>">
                    </div>
                </div>
                <div class="form-row">
                    <div class="form-group col-md-6">
                        <label class="custom-label">Выберите пол</label>
                        <select id="genders" class="form-control">
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
                    <div class="form-group col-md-6">
                        <label class="custom-label">Дата рождения</label>
                        <input id="date_birth" type="date" name="date_birth" class="form-control"
                               value="<#if employees?has_content>${employees.dateBirth}</#if>">
                    </div>
                </div>
                <div class="form-row">
                    <div class="form-group col">
                        <label class="custom-label">Введите ИНН</label>
                        <input id="number_inn" type="text" name="number_inn" class="form-control"
                               placeholder="Введите ИНН"
                               value="<#if employees?has_content>${employees.numberINN?c}</#if>">
                    </div>
                </div>
                <div class="form-row">
                    <div class="form-group col">
                        <label class="custom-label">Введите телефон</label>
                        <input id="phone" type="text" name="phone" class="form-control"
                               placeholder="Введите телефон"
                               value="<#if employees?has_content>${employees.phone}</#if>">
                    </div>
                </div>
                <div class="modal-header pl-0 pb-0 pt-0 mb-2">
                    <h5 class="modal-title" id="exampleModalLabel">Данные для входа</h5>
                </div>
                <div class="form-row">
                    <div class="form-group col-md-6">
                        <label class="custom-label">Введите email</label>
                        <input id="email" type="text" name="email" class="form-control" placeholder="Введите email"
                               value="<#if employees?has_content>${employees.email}</#if>">
                    </div>
                    <div class="form-group col-md-6">
                        <label class="custom-label">Введите пароль</label>
                        <input id="password" type="text" name="password" class="form-control"
                               placeholder="Введите телефон"
                               value="<#if employees?has_content && employees.password?has_content>${employees.password}</#if>">
                    </div>
                </div>
                <#--                <div class="row">-->
                <#--                    <h3>Адрес сотрудника</h3>-->
                <#--                </div>-->
                <div class="modal-header pl-0 pb-0 pt-0 mb-2">
                    <h5 class="modal-title" id="exampleModalLabel">Данные паспорта</h5>
                </div>
                <div class="form-row">
                    <div class="form-group col-md-3">
                        <label class="custom-label">Серия паспорта</label>
                        <input id="number_series" type="text" name="number_series" class="form-control"
                               placeholder="Введите серию паспорта"
                               value="<#if employees?has_content && employees.passport?has_content>${employees.passport.numberSeries?c}</#if>">
                    </div>
                    <div class="form-group col-md-3">
                        <label class="custom-label">Номер паспорта</label>
                        <input id="passport_id" type="text" name="passport_id" class="form-control"
                               placeholder="Введите номер паспорта"
                               value="<#if employees?has_content && employees.passport?has_content>${employees.passport.passportId?c}</#if>">
                    </div>
                    <div class="form-group col-md-3">
                        <label class="custom-label">Кем выдан</label>
                        <input id="issued_by" type="text" name="issued_by" class="form-control"
                               placeholder="Введите кем выдан паспорт"
                               value="<#if employees?has_content && employees.passport?has_content>${employees.passport.issuedBy}</#if>">
                    </div>
                    <div class="form-group col-md-3">
                        <label class="custom-label">Дата выдачи</label>
                        <input id="date_issue" type="date" name="date_issue" class="form-control"
                               value="<#if employees?has_content && employees.passport?has_content>${employees.passport.dateIssue}</#if>">
                    </div>
                </div>
                <div class="modal-header pl-0 pb-0 pt-0 mb-2">
                    <h5 class="modal-title" id="exampleModalLabel">Адрес сотрудника</h5>
                </div>
                <div class="form-row">
                    <div class="form-group col-md-3">
                        <label class="custom-label">Введите город</label>
                        <input id="city" type="text" name="city" class="form-control"
                               placeholder="Введите город"
                               value="<#if employees?has_content && employees.address?has_content>${employees.address.city}</#if>">
                    </div>
                    <div class="form-group col-md-3">
                        <label class="custom-label">Введите улицу</label>
                        <input id="street" type="text" name="street" class="form-control"
                               placeholder="Введите улицу"
                               value="<#if employees?has_content && employees.address?has_content>${employees.address.street}</#if>">
                    </div>
                    <div class="form-group col-md-3">
                        <label class="custom-label">Введите дома</label>
                        <input id="house" type="text" name="house" class="form-control"
                               placeholder="Введите дом"
                               value="<#if employees?has_content && employees.address?has_content>${employees.address.house}</#if>">
                    </div>
                    <div class="form-group col-md-3">
                        <label class="custom-label">Введите квартиры</label>
                        <input id="flat" type="text" name="flat" class="form-control"
                               placeholder="Введите квартиру"
                               value="<#if employees?has_content && employees.address?has_content>${employees.address.flat}</#if>">
                    </div>
                </div>
                <div class="modal-header pl-0 pb-0 pt-0 mb-2">
                    <h5 class="modal-title" id="exampleModalLabel">Положение в компании</h5>
                </div>
                <div class="form-row">
                    <div class="form-group col-md-4">
                        <label class="custom-label">Выберите подразделение</label>
                        <select id="role_id" class="form-control">
                            <#list roles?values as role>
                                <#if employees?has_content>
                                    <#if role == employees.role>
                                        <option value="${role}" selected>${role.getNameRole()}</option>
                                    <#else>
                                        <option value="${role}">${role.getNameRole()}</option>
                                    </#if>
                                <#else>
                                    <option value="${role}">${role.getNameRole()}</option>
                                </#if>
                            </#list>
                        </select>
                    </div>
                    <div class="form-group col-md-4">
                        <label class="custom-label">Выберите подразделение</label>
                        <select id="subdivision_id" class="form-control">
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
                    <div class="form-group col-md-4">
                        <label class="custom-label">Выберите должность</label>
                        <select id="positions_id" class="form-control">
                            <#list positionsNames as positions>
                                <#if employees?has_content && employees.position?has_content>
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
                </div>
                <div class="form-row">
                    <div class="form-group col-md-6">
                        <label class="custom-label">Дата приема на работу</label>
                        <input id="date_receipt" type="date" name="date_receipt" class="form-control"
                               value="<#if employees?has_content && employees.position?has_content && employees.position.dateReceipt?has_content>${employees.position.dateReceipt}</#if>">
                    </div>
                    <div class="form-group col-md-6">
                        <label class="custom-label">Дата увольнения</label>
                        <input id="date_dismissal" type="date" name="date_dismissal" class="form-control"
                               value="<#if employees?has_content && employees.position?has_content && employees.position.dateDismissal?has_content>${employees.position.dateDismissal}</#if>">
                    </div>
                </div>
                <input id="pas_id" type="text"
                       value="<#if employees?has_content && employees.passport?has_content>${employees.passport.id}</#if>" hidden>
                <input id="address_id" type="text"
                       value="<#if employees?has_content && employees.address?has_content>${employees.address.id}</#if>" hidden>
                <input id="position_id" type="text"
                       value="<#if employees?has_content && employees.position?has_content>${employees.position.id}</#if>" hidden>
                <#--<#if employees?has_content>-->
                <#--<div class="form-row">-->
                <#--<input class="btn btn-primary  mb-4" type="button"-->
                <#--onclick="submitUpdateEmployees(${employees.id})"-->
                <#--value="Изменить сотрудника">-->
                <#--</div>-->
                <#--&lt;#&ndash;<#else>&ndash;&gt;-->
                <#--&lt;#&ndash;<div class="form-row">&ndash;&gt;-->
                <#--&lt;#&ndash;<input class="btn btn-primary  mb-4" type="button" onclick="submitNewEmployees()"&ndash;&gt;-->
                <#--&lt;#&ndash;value="Добавить сотрудника">&ndash;&gt;-->
                <#--&lt;#&ndash;</div>&ndash;&gt;-->
                <#--</#if>-->
                <#--                        <div class="form-row mb-2">-->
                <#--                            <div class="form-group col-md-6 pl-0 ml-0">-->
                <#--                                <label>Дата начала отпуска</label>-->
                <#--                                <input id="vacation_start" type="date" name="vacation_start" class="form-control"-->
                <#--                                       value="<#if employees?has_content && employees.vacationStart?has_content>${employees.vacationStart}</#if>">-->
                <#--                            </div>-->
                <#--                            <div class="form-group col-md-6 pr-0 mr-0">-->
                <#--                                <label>Дата окончания отпуска</label>-->
                <#--                                <input id="vacation_final" type="date" name="vacation_final" class="form-control"-->
                <#--                                       value="<#if employees?has_content && employees.vacationFinal?has_content>${employees.vacationFinal}</#if>">-->
                <#--                            </div>-->
                <#--                        </div>-->
            </form>
        </div>
        <#--</div>-->
    </div>
</#macro>