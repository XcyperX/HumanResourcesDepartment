<#macro product products categories positionsNames create=true vacation=false workAgreement=false>
    <#--<div class="container pl-5 pr-5">-->
        <div class="row">
            <div class="col-sm">
                <form id="createEmployee<#if products?has_content>_${products.id}</#if>" name="createEmployee">
                    <#if !vacation>
                        <div class="form-row mb-2">
                            <div class="form-group col-md-6 pl-0 ml-0">
                                <label>Введите имя</label>
                                <input id="first_name" type="text" name="first_name" class="form-control"
                                       placeholder="Введите имя"
                                       value="<#if products?has_content>${products.firstName}</#if>">
                            </div>
                            <div class="form-group col-md-6 pr-0 mr-0">
                                <label>Введите фамилию</label>
                                <input id="last_name" type="text" name="last_name" class="form-control"
                                       placeholder="Введите фамилию"
                                       value="<#if products?has_content>${products.lastName}</#if>">
                            </div>
                        </div>
                        <div class="form-row mb-2">
                            <div class="form-group col-md-3  px-0 mx-0">
                                <label>Серия паспорта</label>
                                <input id="number_series" type="text" name="number_series" class="form-control"
                                       placeholder="Введите серию паспорта"
                                       value="<#if products?has_content>${products.passport.numberSeries?c}</#if>">
                            </div>
                            <div class="form-group col-md-3">
                                <label>Номер паспорта</label>
                                <input id="passport_id" type="text" name="passport_id" class="form-control"
                                       placeholder="Введите номер паспорта"
                                       value="<#if products?has_content>${products.passport.passportId?c}</#if>">
                            </div>
                            <div class="form-group col-md-3">
                                <label>Кем выдан</label>
                                <input id="issued_by" type="text" name="issued_by" class="form-control"
                                       placeholder="Введите кем выдан паспорт"
                                       value="<#if products?has_content>${products.passport.issuedBy}</#if>">
                            </div>
                            <div class="form-group col-md-3  px-0 mx-0">
                                <label>Дата выдачи</label>
                                <input id="date_issue" type="date" name="date_issue" class="form-control"
                                       value="<#if products?has_content>${products.passport.dateIssue}</#if>">
                            </div>
                        </div>
                        <div class="form-row mb-2">
                            <label>Введите email</label>
                            <input id="email" type="text" name="email" class="form-control" placeholder="Введите email"
                                   value="<#if products?has_content>${products.email}</#if>">
                        </div>
                        <div class="form-row mb-2">
                            <label>Введите телефон</label>
                            <input id="phone" type="text" name="phone" class="form-control"
                                   placeholder="Введите телефон"
                                   value="<#if products?has_content>${products.phone}</#if>">
                        </div>
                        <div class="form-row mb-2">
                            <label>Дата рождения</label>
                            <input id="date_birth" type="date" name="date_birth" class="form-control"
                                   value="<#if products?has_content>${products.dateBirth}</#if>">
                        </div>
                        <div class="form-row mb-2">
                            <div class="form-group col-md-3 px-0 mx-0">
                                <label>Введите город</label>
                                <input id="city" type="text" name="city" class="form-control"
                                       placeholder="Введите город"
                                       value="<#if products?has_content>${products.address.city}</#if>">
                            </div>
                            <div class="form-group col-md-3">
                                <label>Введите улицу</label>
                                <input id="street" type="text" name="street" class="form-control"
                                       placeholder="Введите улицу"
                                       value="<#if products?has_content>${products.address.street}</#if>">
                            </div>
                            <div class="form-group col-md-3">
                                <label>Введите дома</label>
                                <input id="house" type="text" name="house" class="form-control"
                                       placeholder="Введите дом"
                                       value="<#if products?has_content>${products.address.house}</#if>">
                            </div>
                            <div class="form-group col-md-3  px-0 mx-0">
                                <label>Введите квартиры</label>
                                <input id="flat" type="text" name="flat" class="form-control"
                                       placeholder="Введите квартиру"
                                       value="<#if products?has_content>${products.address.flat}</#if>">
                            </div>
                        </div>
                        <div class="form-row mb-2">
                            <label>Введите ИНН</label>
                            <input id="number_inn" type="text" name="number_inn" class="form-control"
                                   placeholder="Введите ИНН"
                                   value="<#if products?has_content>${products.numberINN?c}</#if>">
                        </div>
                        <div class="form-row mb-2">
                            <label>Выберите пол</label>
                            <select id="genders" class="form-control">
                                <option value="null"></option>
                                <#list genders?values as gender>
                                    <#if products?has_content>
                                        <#if gender.getNameGender() == products.gender>
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
                            <select id="categories" class="form-control">
                                <option value="null"></option>
                                <#list categories as categories>
                                    <#if products?has_content>
                                        <#if categories.id == products.subdivisionId>
                                            <option value="${categories.id}" selected>${categories.name}</option>
                                        <#else>
                                            <option value="${categories.id}">${categories.name}</option>
                                        </#if>
                                    <#else>
                                        <option value="${categories.id}">${categories.name}</option>
                                    </#if>
                                </#list>
                            </select>
                        </div>
                        <div class="form-row mb-2">
                            <label>Выберите должность</label>
                            <select id="positions" class="form-control">
                                <option value="null"></option>
                                <#list positionsNames as positions>
                                    <#if products?has_content>
                                        <#if positions.id == products.position.positionNameId>
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
                        <div class="form-row">
                            <div class="form-group col-md-3 pl-0 ml-0">
                                <label>Дата приема на работу</label>
                                <input id="date_receipt" type="date" name="date_receipt" class="form-control"
                                       value="<#if products?has_content>${products.position.dateReceipt}</#if>">
                            </div>
                            <#if !create>
                                <div class="form-group col-md-3  pr-0 mr-0">
                                    <label>Дата увольнения</label>
                                    <input id="date_dismissal" type="date" name="date_dismissal" class="form-control"
                                           value="<#if products?has_content && products.position.dateDismissal?has_content>${products.position.dateDismissal}</#if>">
                                </div>
                            </#if>
                        </div>
                        <#if !create>
                            <div class="form-row mb-2">
                                <label>Введите статус</label>
                                <input id="status" type="text" name="status" class="form-control"
                                       placeholder="Введите статус"
                                       value="<#if products?has_content>${products.status}</#if>">
                            </div>
                        </#if>
                        <input id="pas_id" type="text"
                               value="<#if products?has_content>${products.passport.id}</#if>" hidden>
                        <input id="address_id" type="text"
                               value="<#if products?has_content>${products.address.id}</#if>" hidden>
                        <input id="position_id" type="text"
                               value="<#if products?has_content>${products.position.id}</#if>" hidden>
                        <input id="work_agreement" type="text"
                               value="<#if workAgreement>true<#else>false</#if>" hidden>
                        <#--<#if products?has_content>-->
                            <#--<div class="form-row">-->
                                <#--<input class="btn btn-primary  mb-4" type="button"-->
                                       <#--onclick="submitUpdateEmployees(${products.id})"-->
                                       <#--value="Изменить сотрудника">-->
                            <#--</div>-->
                        <#--&lt;#&ndash;<#else>&ndash;&gt;-->
                            <#--&lt;#&ndash;<div class="form-row">&ndash;&gt;-->
                                <#--&lt;#&ndash;<input class="btn btn-primary  mb-4" type="button" onclick="submitNewEmployees()"&ndash;&gt;-->
                                       <#--&lt;#&ndash;value="Добавить сотрудника">&ndash;&gt;-->
                            <#--&lt;#&ndash;</div>&ndash;&gt;-->
                        <#--</#if>-->
                    <#else>
                        <div class="form-row mb-2">
                            <div class="form-group col-md-6 pl-0 ml-0">
                                <label>Дата начала отпуска</label>
                                <input id="vacation_start" type="date" name="vacation_start" class="form-control"
                                       value="<#if products?has_content && products.vacationStart?has_content>${products.vacationStart}</#if>">
                            </div>
                            <div class="form-group col-md-6 pr-0 mr-0">
                                <label>Дата окончания отпуска</label>
                                <input id="vacation_final" type="date" name="vacation_final" class="form-control"
                                       value="<#if products?has_content && products.vacationFinal?has_content>${products.vacationFinal}</#if>">
                            </div>
                        </div>
                    </#if>
                </form>
            </div>
        <#--</div>-->
    </div>
</#macro>